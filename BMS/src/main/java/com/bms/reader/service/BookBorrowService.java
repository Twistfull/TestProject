package com.bms.reader.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.bms.reader.model.BorrowInfo;
import com.github.pagehelper.PageInfo;


public interface BookBorrowService {

	
	/**
	 * @Title:addBorrow
	 * @Description:生成借阅信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月15日
	 * @param borrowinfo
	 * @return
	 * @throws ParseException 
	 */
	BorrowInfo produceBorrow(BorrowInfo borrowinfo) throws ParseException;

	/**
	 * @Title:addBorrow
	 * @Description:借阅信息写入数据库
	 * @author:TwistFate丶QK
	 * @Date:2017年8月17日
	 * @param borrowInfo
	 */
	Boolean addBorrow(BorrowInfo borrowInfo);

	/**
	 * @Title:borrowpageSelectInit
	 * @Description: 读者借阅列表页面初始化
	 * @author:TwistFate丶QK
	 * @Date:2017年8月16日
	 * @param mav
	 * @param id
	 * @return
	 */
	ModelAndView borrowpageSelectInit(ModelAndView mav, Integer id);

	/**
	 * @Title:borrowtip
	 * @Description:逾期提醒
	 * @author:TwistFate丶QK
	 * @Date:2017年8月18日
	 * @param mav
	 * @return
	 * @throws ParseException 
	 */
	ModelAndView borrowtip(ModelAndView mav) throws ParseException;



}
