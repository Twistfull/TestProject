package com.bms.reader.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bms.reader.common.ContextHolder;
import com.bms.reader.constant.ParamConstants;
import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BorrowInfo;
import com.bms.reader.model.PayforInfo;
import com.bms.reader.model.ReturnInfo;
import com.bms.reader.persist.BookInfoMapper;
import com.bms.reader.persist.BorrowInfoMapper;
import com.bms.reader.persist.ReturnInfoMapper;
import com.bms.reader.service.BookBorrowService;
import com.bms.reader.service.BookInfoService;
import com.bms.reader.service.BookReturnService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BookReturnServiceImpl implements BookReturnService{
    
	  @Autowired
	   private BorrowInfoMapper borrowInfoMapper;
	  @Autowired
	   private BookInfoMapper bookInfoMapper;
	  @Autowired
	   private ReturnInfoMapper returnInfoMapper;
	  
	  @Override
	  public ReturnInfo  produceReturn(ReturnInfo returninfo) throws ParseException{
		 //begin 获取当前日期，与限定归还日期
		  Date now=new Date();
		  SimpleDateFormat datemodel=new SimpleDateFormat("yyyy-MM-dd");
		  String date = datemodel.format(now);//Date转String转换为yyyy-MM-dd类型,这样转换是为了只保留天数，00:00
		  Date  today= datemodel.parse(date);//当前日期，既归还日期
          
		  BorrowInfo borrowinfo=borrowInfoMapper.selectByRecordId(returninfo.getRecordId());
		  Date end=borrowinfo.getEndDate();
		  String date2= datemodel.format(end);
		 // Date  returns= datemodel.parse(date);
		  
		  long ms=datemodel.parse(date).getTime()-datemodel.parse(date2).getTime();
		  long day=(ms/ ( 1000 * 60 * 60 * 24));
		  int  Day=(int)day;//为计算罚款金额做转换
		  BigDecimal overdueDay= new BigDecimal(day);//需要存储的逾期天数
		  BigDecimal price=borrowinfo.getBookInfo().getBookPrice();//获取书本价格
		  double Price=price.doubleValue();//为计算罚款金额做转换
           
	      //end 结束
		  
		  BigDecimal payFor=new  BigDecimal(0.001*Day*Price).setScale(2,BigDecimal.ROUND_HALF_UP);//需要存储的书籍价格.注明：setScale(2,BigDecimal.ROUND_HALF_UP)保留2位小数，4舍5入
		  System.out.println("逾期天数:"+day+"赔偿金额:"+ payFor);
		  //用set 将数据存进javeBean对象
		  returninfo.setOverdueDay(overdueDay);
		  returninfo.setPayFor(payFor);
		  returninfo.setReturnDate(today);
		  returninfo.setBorrowInfo(borrowinfo);
		  /* borrowinfo.setEndDate(end);
		  borrowinfo.setReaderId(ContextHolder.getSessionReader().getId());
		  System.out.println( borrowinfo.getReaderId());*/
		 // borrowInfoMapper.insert(borrowinfo);
	     // System.out.println("添加成功");
	     // bookInfoMapper.updateBookStatus(borrowinfo.getBookId());
	      //borrowinfo.setReaderId(ContextHolder.getSessionReader().getReaderName());
	     /* borrowinfo.setBookName(bookInfoMapper.selectBookName(borrowinfo.getBookId()));*/
	      return  returninfo;
}

	@Override
	public void returnBook(ReturnInfo returnInfo, String type) {
		BookInfo bookStatus=bookInfoMapper.selectByBookId(returnInfo.getBorrowInfo().getBookId());
		if(bookStatus.getBookStatus().equals("外借")){
			returnInfo.setPayExplain("已处理");
			returnInfoMapper.updateReturnInfo(returnInfo);
			bookInfoMapper.updateBookStatus(returnInfo.getBorrowInfo().getBookId(),type);
			System.out.println("归还成功");
			}else{
			System.out.println("请不要重复点击");
			}			
			
	}

	@Override
	public List<PayforInfo> selectByreaderId(String readerId, int i,int limit,int id,boolean paging) {
		// TODO Auto-generated method stub
		List<PayforInfo> list = new ArrayList<PayforInfo>();		
		List<BorrowInfo> borrowinfo;
		if(paging){
		PageHelper.startPage(i, limit);
		}
		else{
			
		}
		 SimpleDateFormat datemodel=new SimpleDateFormat("yyyy-MM-dd");//日期格式
		 borrowinfo=borrowInfoMapper.payforAll(readerId,id);
		 PageInfo<BorrowInfo> pageInfo = new PageInfo<BorrowInfo>(borrowinfo);
	     long total = pageInfo.getTotal(); //获取总记录数
		    for(BorrowInfo str : borrowinfo){//循环将borrowinfo的数据封装到payforinfo中，以适应前端分页的需求
			     String recordId=str.getRecordId();//得到记录数
			     String bookName=str.getBookInfo().getBookName();//得到书名
			     String startDate =datemodel.format(str.getStartDate());//得到借阅日期
			     String endDate;
			     if(str.getReturnInfo().getReturnDate()==null){
			         endDate="未归还";
			     }
			     else{
			        endDate=datemodel.format(str.getReturnInfo().getReturnDate());//得到归还日期
			     }
			     BigDecimal overDue;//逾期天数
			     BigDecimal payFor;	//罚款金额	
			     BigDecimal bookPrice=str.getBookInfo().getBookPrice();
			     if(str.getReturnInfo().getOverdueDay()==null){//如果记录中不存在
			    	 ReturnInfo ref=new ReturnInfo();
					try {
						ref = produceReturn(str.getReturnInfo());//调用这个方法生成逾期天数和罚款金额
					} catch (ParseException e) {
						System.out.println("不希望发生的错误!");
					}
			    	 overDue=ref.getOverdueDay();//得到逾期天数
				     payFor=ref.getPayFor();//得到罚款金额
			     }else{
			    	  overDue=str.getReturnInfo().getOverdueDay();
				     payFor=str.getReturnInfo().getPayFor();
			     }
			     String payExplain=str.getReturnInfo().getPayExplain();
			     PayforInfo pyf=new PayforInfo(recordId,bookName,bookPrice,startDate,endDate,overDue, payFor,payExplain,total);						     
			     list.add(pyf);		    	 
		       //System.out.println(str.getBookAddress());
		     }
		 /* for(PayforInfo str : list){
			     System.out.println("我是天数"+str.getOverDue()+"我是金额"+str.getPayFor()+"总数"+total);
		     }*/
		return list;
	}

/*	@Override
	public void addBorrow(BorrowInfo borrowInfo) {
		
		BookInfo bookStatus=bookInfoMapper.selectByBookId(borrowInfo.getBookId());
		if(bookStatus.getBookStatus().equals("在架")){
		borrowInfoMapper.insert(borrowInfo);
		bookInfoMapper.updateBookStatus(borrowInfo.getBookId());
		System.out.println("借阅成功");
		}else{
		System.out.println("请不要重复点击");
		}
		
	}*/
	


}
