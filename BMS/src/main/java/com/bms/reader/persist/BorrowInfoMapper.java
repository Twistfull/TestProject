package com.bms.reader.persist;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BorrowInfo;


public interface BorrowInfoMapper {
   



	
	/**
	 * @Title:insert
	 * @Description:添加借阅信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月15日
	 * @param record
	 * @return
	 */
	int insert(BorrowInfo record);

	/**
	 * @Title:selectByReaderId
	 * @Description: 根据用户id检索出用户的借阅信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月16日
	 * @param string
	 * @return
	 */
	List<BorrowInfo> selectByReaderId(String id);
	
	
	/**
	 * @Title:selectByReaderId
	 * @Description: 根据记录号检索借阅信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月16日
	 * @param string
	 * @return
	 */
	BorrowInfo selectByRecordId(String id);
	
	
	/**
	 * @Title:selectByReaderId
	 * @Description: 多条件查询用户的借阅信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月16日
	 * @param sessionTerm
	 * @return
	 */
	List<BorrowInfo> listAll(BorrowInfo borrowInfo);

	/**
	 * @Title:selectcountborrow
	 * @Description:查询借阅未归还数量
	 * @author:TwistFate丶QK
	 * @Date:2017年8月18日
	 * @param id
	 * @return
	 */
	int selectCountBorrow(String id);

	/**
	 * @Title:selectcountoverdue
	 * @Description:查询逾期书籍数量
	 * @author:TwistFate丶QK
	 * @Date:2017年8月18日
	 * @param id
	 * @return
	 */
	int selectCountOverdue(String id);

	/**
	 * @Title:selectTipByReaderId
	 * @Description:根据用户id检索出用户的快要到期的借阅信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月18日
	 * @param id
	 * @param end 
	 * @param start 
	 * @return
	 */
	List<BorrowInfo> selectTipByReaderId(@Param("readerId")String id, @Param("end")Date end, @Param("start") Date start);



	/**
	 * @Title:insertreturn
	 * @Description:插入借阅信息的同时插入一条归还记录的记录号
	 * @author:TwistFate丶QK
	 * @Date:2017年8月20日
	 * @param recordId
	 * @return
	 */
	int insertreturn(@Param("recordId")String recordId);

	

	/**
	 * @Title:payforAll
	 * @Description:查询所有有关于罚款的信息
	 * @author:TwistFate丶QK
	 * @param readerId 
	 * @param id //检索条件(0:已处理,1:未处理,2:全部)
	 * @Date:2017年8月22日
	 * @return
	 */
	List<BorrowInfo> payforAll(@Param("readerId")String readerId,@Param("id")int id);


}