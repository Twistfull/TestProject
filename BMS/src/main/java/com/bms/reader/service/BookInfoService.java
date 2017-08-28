package com.bms.reader.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.bms.reader.constant.DescribableEnum;
import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BookInfoQueryVo;
import com.github.pagehelper.PageInfo;


public interface BookInfoService {
     //kkk
	/**
	 * @Title:addBook
	 * @Description:书籍信息添加
	 * @author:TwistFate丶QK
	 * @Date:2017年8月10日
	 * @param bookInfo
	 */
	public int addBook(BookInfo bookInfo);
	
	/**
	 * @Title:listAll
	 * @Description:查询书籍信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月11日
	 * @param bookInfo
	 * @return
	 */
	List<BookInfo> listAll(BookInfo bookInfo);
    
	/**
	 * @Title:selectByBookId
	 * @Description:查询书籍详细信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月15日
	 * @param id
	 * @return
	 */
	BookInfo selectByBookId(String bookId);
	

	List<BookInfo> selectByBookName(String bookName, Integer page);

	/**
	 * @Title:pageSelectInit
	 * @Description: 图书列表图书列表页面初始化
	 * @author:TwistFate丶QK
	 * @Date:2017年8月13日
	 * @param mav
	 * @param id
	 * @return
	 */
	public ModelAndView pageSelectInit(ModelAndView mav, Integer id);

	public Map listAll(BookInfoQueryVo bookInfoQueryVo);

	public Integer deleteByBookId(String book_id);


}
