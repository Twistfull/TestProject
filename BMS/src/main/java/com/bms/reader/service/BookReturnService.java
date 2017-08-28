package com.bms.reader.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BorrowInfo;
import com.bms.reader.model.PayforInfo;
import com.bms.reader.model.ReturnInfo;
import com.github.pagehelper.PageInfo;


public interface BookReturnService {

	
	/**
	 * @Title:addBorrow
	 * @Description:生成借阅信息
	 * @author:TwistFate丶QK
	 * @param type 
	 * @Date:2017年8月15日
	 * @param borrowinfo
	 * @return
	 * @throws ParseException 
	 */
	//BorrowInfo produceBorrow(BorrowInfo borrowinfo) throws ParseException;
	
	/**
	 * @Title:produceReturn
	 * @Description:生成归还信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月17日
	 * @param returninfo
	 * @return
	 * @throws ParseException 
	 */
	ReturnInfo produceReturn(ReturnInfo returninfo) throws ParseException;

	/**
	 * @Title:returnBook
	 * @Description:归还信息添加至数据库
	 * @author:TwistFate丶QK
	 * @Date:2017年8月17日
	 * @param returnInfo
	 */
	void returnBook(ReturnInfo returnInfo,String type);

	/**
	 * @Title:selectByreaderId
	 * @Description:查询罚款信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月22日
	 * @param readerId
	 * @param i //页码
	 * @param limit //分页数
	 * @param id
	 * @param paging//是否分页
	 * @return
	 */
	List<PayforInfo> selectByreaderId(String string, int i, int limit, int id, boolean paging);


	//void addBorrow(BorrowInfo borrowInfo);

	/**
	 * @Title:borrowpageSelectInit
	 * @Description: 读者借阅列表页面初始化
	 * @author:TwistFate丶QK
	 * @Date:2017年8月16日
	 * @param mav
	 * @param id
	 * @return
	 */
	//ModelAndView borrowpageSelectInit(ModelAndView mav, Integer id);



}
