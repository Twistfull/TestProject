package com.bms.reader.persist;

import java.util.List;

import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BorrowInfo;
import com.bms.reader.model.PayforInfo;
import com.bms.reader.model.ReturnInfo;


public interface ReturnInfoMapper {
   



	
	/**
	 * @Title:insert
	 * @Description:添加归还信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月15日
	 * @param record
	 * @return
	 */
	// int insert(ReturnInfo returnInfo);

	 int updateReturnInfo(ReturnInfo returnInfo);



	
	
	/**
	 * @Title:selectByReaderId
	 * @Description: 根据用户id检索出用户的借阅信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月16日
	 * @param string
	 * @return
	 *//*
	List<BorrowInfo> selectByReaderId(String id);
	
	
	*//**
	 * @Title:selectByReaderId
	 * @Description: 根据记录号检索借阅信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月16日
	 * @param string
	 * @return
	 *//*
	BorrowInfo selectByRecordId(String id);
	
	
	*//**
	 * @Title:selectByReaderId
	 * @Description: 多条件查询用户的借阅信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月16日
	 * @param sessionTerm
	 * @return
	 *//*
	List<BorrowInfo> listAll(BorrowInfo borrowInfo);*/


}