package com.bms.reader.persist;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BookInfoQueryVo;


public interface BookInfoMapper {
   


	/**
	 * @Title:insert
	 * @Description:增加书籍信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月10日
	 * @param record
	 * @return
	 */
	
	int insert(BookInfo record);
	
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
	 * @Title:selectBookName
	 * @Description:查询书籍名称
	 * @author:TwistFate丶QK
	 * @Date:2017年8月15日
	 * @param bookId
	 * @return
	 */
	String selectBookName(String bookId);
	
	/**
	 * @Title:updateBookStatus
	 * @Description:更新书籍状态
	 * @author:TwistFate丶QK
	 * @Date:2017年8月15日
	 * @param bookId
	 * @param status 
	 * @return
	 */
	int updateBookStatus(@Param("bookId")String bookId,@Param("status")String status);
	
	List<BookInfo> selectByBookName(String bookName);
	
	/**
	 * @Title:selectByBookId
	 * @Description:查询书籍详细信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月15日
	 * @param bookId
	 * @return
	 */
	BookInfo selectByBookId(String bookId);

	public Integer deleteByBookId(String id);

	public Integer findCount();

	List<BookInfo> listAlladm(BookInfoQueryVo bookInfoQueryVo);



}