package com.bms.reader.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bms.reader.common.ContextHolder;
import com.bms.reader.constant.ParamConstants;
import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BorrowInfo;
import com.bms.reader.model.DisallowInfo;
import com.bms.reader.persist.BookInfoMapper;
import com.bms.reader.persist.BorrowInfoMapper;
import com.bms.reader.service.BookBorrowService;
import com.bms.reader.service.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BookBorrowServiceImpl implements BookBorrowService{
    
	  @Autowired
	   private BorrowInfoMapper borrowInfoMapper;
	  @Autowired
	   private BookInfoMapper bookInfoMapper;
	  
	  
	  @Override
	  public BorrowInfo  produceBorrow(BorrowInfo borrowinfo) throws ParseException{
		 //begin 获取借阅日期，与归还日期
		  Date now=new Date();
		  SimpleDateFormat datemodel=new SimpleDateFormat("yyyy-MM-dd");
		  String date = datemodel.format(now);//Date转String转换为yyyy-MM-dd类型
		  Date  start = datemodel.parse(date);//将String类型转会Date
		
		  Calendar rightNow = Calendar.getInstance();
		  rightNow.setTime(start);
		  //rightNow.add(Calendar.YEAR,-1);//日期减1年
		  //rightNow.add(Calendar.MONTH,1);//日期加1个月
		  rightNow.add(Calendar.DAY_OF_YEAR,+31);//日期加31天
		  Date end=rightNow.getTime();
		  // System.out.println(start);
		  //System.out.println(end); 
	      //end 结
		  borrowinfo.setStartDate(start);
		  borrowinfo.setEndDate(end);
		  borrowinfo.setReaderId(ContextHolder.getSessionReader().getId());
		  System.out.println( borrowinfo.getReaderId());
		 // borrowInfoMapper.insert(borrowinfo);
	     // System.out.println("添加成功");
	     // bookInfoMapper.updateBookStatus(borrowinfo.getBookId());
	      //borrowinfo.setReaderId(ContextHolder.getSessionReader().getReaderName());
	      borrowinfo.setBookName(bookInfoMapper.selectBookName(borrowinfo.getBookId()));
	      return borrowinfo;
}
    @Transactional
	@Override
	public Boolean addBorrow(BorrowInfo borrowInfo) {
		
		 int countborrow,countoverdue;//未还书籍数量b和逾期书籍数量o(b>=8,o>=3不予借阅)
	     countborrow=borrowInfoMapper.selectCountBorrow(ContextHolder.getSessionReader().getId());
	     countoverdue=borrowInfoMapper.selectCountOverdue(ContextHolder.getSessionReader().getId());
	     System.out.println("未还书籍:"+countborrow+"逾期书籍:"+countoverdue);
	     if(countborrow>=8||countoverdue>=3){//判断用户是不是满足借阅条件
	    	  //DisallowInfo disallowInfo=null;
	    	 System.out.println("未还书籍:"+countborrow+"逾期书籍:"+countoverdue);
	    	  DisallowInfo  disallowInfo=new DisallowInfo();
	    	  disallowInfo.setCountborrow(countborrow);
	    	  disallowInfo.setCountoverdue(countoverdue);
	    	  ContextHolder.getSession().setAttribute(ParamConstants.LOCAL__ERROR_INFO,disallowInfo);
	    	 return false;
	     }else{
		       BookInfo bookStatus=bookInfoMapper.selectByBookId(borrowInfo.getBookId());
		     
		       if(bookStatus.getBookStatus().equals("在架")){
			       borrowInfoMapper.insert(borrowInfo);
			       String recordId=borrowInfo.getRecordId();//获取刚插入的记录号
			       borrowInfoMapper.insertreturn(recordId);			       
                  /* SqlSession session = sessionFactory.openSession(false); // 打开会话，事务开始
			    			
			    			try {
			    				IUserMapper mapper = session.getMapper(IUserMapper.class);
			    				User user = new User(9, "Test transaction");
			    				int affectedCount = mapper.updateUser(user); // 因后面的异常而未执行commit语句
			    				User user = new User(10, "Test transaction continuously");
			    				int affectedCount2 = mapper.updateUser(user2); // 因后面的异常而未执行commit语句
			    				int i = 2 / 0; // 触发运行时异常
			    				session.commit(); // 提交会话，即事务提交
			    			} finally {
			    				session.close(); // 关闭会话，释放资源
			    			}
			    		}
			    	}*/

			       String status="外借";
			       bookInfoMapper.updateBookStatus(borrowInfo.getBookId(),status);
			       System.out.println("借阅成功");
		      }else{
		           System.out.println("请不要重复点击");
		      }
		       
		      return true;
	     }	
	}

	@Override
	public ModelAndView borrowpageSelectInit(ModelAndView mav, Integer id) {
		if(id==null||id<0)
		 {
			 id=1;
		 }
		 Integer count=8;//书籍分页数
		 List<BorrowInfo>  list;//图书信息对象
		 PageHelper.startPage(id, count);
		// BorrowInfo flag=null;
		//检索条件
		 BorrowInfo borrowInfo=ContextHolder.getSessionBorrowTerm();
	     if(borrowInfo!=null){	 
	    	/* System.out.println("开始时间:"+borrowInfo.getStartDate());
	    	 System.out.println("截至时间:"+borrowInfo.getEndDate());*/
	    	 //System.out.println("payExplain字段:"+borrowInfo.getReturnInfo().getPayExplain());
	         list=borrowInfoMapper.listAll(borrowInfo);	         
	     }else{
	         list= borrowInfoMapper.selectByReaderId(ContextHolder.getSessionReader().getId());
	     }
	     System.out.println("成功查询");
	    /* for(BorrowInfo str : list){
	           System.out.println(str.getBookInfo().getBookName());
	           System.out.println(str.getBookInfo().getBookStatus());
	           System.out.println("支付情况"+str.getReturnInfo().getPayExplain());
	     }*/
	     // 取分页信息
	     PageInfo<BorrowInfo> pageInfo = new PageInfo<BorrowInfo>(list);
	     long total = pageInfo.getTotal(); //获取总记录数	     
	     if(total==0){
	    	  String error="defeat";
	    	  ContextHolder.getSession().setAttribute(ParamConstants.LOCAL_ERROR_TIP,error);
	     }
	     System.out.println("共有借阅信息：" + total);
	     long endpage;//
	     if(total%count!=0){
	          endpage=total/count+1;
	     }
	     else{
	    	 endpage=total/count;
	     }
	     mav.addObject("total",total);//返回总记录数
    	 mav.addObject("list",list);//返回数据集合
    	 mav.addObject("endpage",endpage);//返回结束页码，相当于总页数
    	 if(id>endpage)
    	 { int a=(int)endpage;//int和Integer可以互转，int 和long ,以及long 和Long .
    	   id=(Integer)a;  
    	   }
    	 mav.addObject("nowpage",id);//返回当前页数
		return mav;
	}

	@Override
	public ModelAndView borrowtip(ModelAndView mav) throws ParseException {
		 List<BorrowInfo>  tip;//逾期提示对象
		 Date now=new Date();
		 SimpleDateFormat datemodel=new SimpleDateFormat("yyyy-MM-dd");
		 String date = datemodel.format(now);//Date转String转换为yyyy-MM-dd类型
		 Date  start = datemodel.parse(date);//将String类型转会Date
		
		  Calendar rightNow = Calendar.getInstance();
		  rightNow.setTime(start);
		  rightNow.add(Calendar.DAY_OF_YEAR,+10);//日期加10天
		  Date end=rightNow.getTime();
		  //String date3 = datemodel.format(end);//10天后的日期
		  tip= borrowInfoMapper.selectTipByReaderId(ContextHolder.getSessionReader().getId(),end,start);
		  System.out.println(tip);
		  for(BorrowInfo str : tip){
			  Date overDate=str.getEndDate();
			  String date2= datemodel.format(overDate);
			 // Date  returns= datemodel.parse(date);			  
			  long ms=datemodel.parse(date2).getTime()-datemodel.parse(date).getTime();
			  long day=(ms/ ( 1000 * 60 * 60 * 24));
			  str.setTipday((int)day);//为计算罚款金额做转换
	     }
		  
	     mav.addObject("tip",tip);//返回数据集合
		  
		return mav;
	}


}
