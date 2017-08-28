package com.bms.reader.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bms.reader.common.ContextHolder;
import com.bms.reader.constant.DescribableEnum;
import com.bms.reader.constant.ParamConstants;
import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BookInfoQueryVo;
import com.bms.reader.persist.BookInfoMapper;
import com.bms.reader.service.BookInfoService;
import com.bms.reader.util.TransformToColumn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BookInfoServiceImpl implements BookInfoService{
    
	  @Autowired
	   private BookInfoMapper bookInfoMapper;
	/**
	 * @Title:addBook
	 * @Description:书籍信息添加Impl
	 * @author:TwistFate丶QK
	 * @Date:2017年8月10日
	 * @param bookInfo
	 */
	@Override
	public int addBook(BookInfo bookInfo){
				//bookInfoMapper.insert(bookInfo);
				//System.out.println("添加成功");
				return bookInfoMapper.insert(bookInfo);
	}
	
	  @Override
	public List<BookInfo> listAll(BookInfo bookInfo) {
	        return bookInfoMapper.listAll(bookInfo);
	    }
	  
	  @Override
	public List<BookInfo> selectByBookName(String bookName,Integer page) {
		     PageHelper.startPage(page, 5);
		     List<BookInfo>  list= bookInfoMapper.selectByBookName(bookName);
		     for(BookInfo str : list){
		    	 System.out.println(str);
		       System.out.println(str.getBookAddress());
		     }
		     // 取分页信息
		     PageInfo<BookInfo> pageInfo = new PageInfo<BookInfo>(list);
		     long total = pageInfo.getTotal(); //获取总记录数
		     System.out.println("共有书本信息：" + total);
		     
		     return list;
		    }

	@Override
	public ModelAndView pageSelectInit(ModelAndView mav, Integer id) {
		 if(id==null||id<0)
		 {
			 id=1;
		 }
		 Integer count=8;//书籍分页数
		 List<BookInfo>  list;//图书信息对象
		 PageHelper.startPage(id, count);
	     BookInfo bookInfo=ContextHolder.getSessionBookTerm();//获取查询条件
	     if(bookInfo!=null){	    	
	    	 System.out.println(bookInfo.getBookAuthor()+bookInfo.getBookIntro());
	         list=bookInfoMapper.listAll(bookInfo);
	     }else{
	         list= bookInfoMapper.selectByBookName("ifyoubooknameisthissorry");
	     }
	     /*for(BookInfo str : list){
	    	 System.out.println(str.getPublDate());
	    	 System.out.println(str.getStorageDate());
	         System.out.println(str.getBookAddress());
	     }*/
	     // 取分页信息
	     PageInfo<BookInfo> pageInfo = new PageInfo<BookInfo>(list);
	     long total = pageInfo.getTotal(); //获取总记录数
	     if(total==0){
	    	  String error="defeat";
	    	 ContextHolder.getSession().setAttribute(ParamConstants.LOCAL_ERROR_TIP,error);
	     }
	     System.out.println("共有书本信息：" + total);
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
	public BookInfo selectByBookId(String bookId) {
		 System.out.println("查询ID"+bookId);
		 return bookInfoMapper.selectByBookId(bookId);
	}
	
	//查找所有图书
		public Map listAll(BookInfoQueryVo bookInfoQueryVo) {
			//当前页数
			int currentPage = bookInfoQueryVo.getPage();
			// 每页的行数
			int rows=bookInfoQueryVo.getRows();
			// 起始记录
			int start = (currentPage - 1) * rows+1;
			//截止记录
			int end=start+rows-1;
			//以何种方式排序
			String sort=bookInfoQueryVo.getSort();
			//转化成字段
			String tableSort=TransformToColumn.transfromToBookColumn(sort);
			bookInfoQueryVo.setTableSort(tableSort);
			bookInfoQueryVo.setStart(start);
			bookInfoQueryVo.setStart(end);
			List<BookInfo> books=new ArrayList<BookInfo>();
			PageHelper.startPage(currentPage, rows);
			books=bookInfoMapper.listAlladm(bookInfoQueryVo);
			// 总共记录数
			int total=bookInfoMapper.findCount();
			Map map=new HashMap();
			map.put("total", total);
			map.put("rows", books);
			return map;
		}
		public Integer deleteByBookId(String id) {
			return bookInfoMapper.deleteByBookId(id);
		}
		
}
