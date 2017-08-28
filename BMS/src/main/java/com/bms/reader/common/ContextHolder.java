package com.bms.reader.common;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bms.reader.constant.ParamConstants;
import com.bms.reader.model.ReaderReader;
import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BorrowInfo;
import com.bms.reader.model.DisallowInfo;
import com.bms.reader.model.ReaderAdmin;
import com.bms.reader.model.ReaderUser;
import com.bms.reader.model.ReturnInfo;

/**
* @ClassName: ContextHolderUtils 
* @Description: 上下文工具类，用于在Server,Dao层获取当前登录用户信息等；
* @author  shenlx
 */
public class ContextHolder {
	/**
	 * SpringMvc下获取request
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;

	}
	/**
	 * SpringMvc下获取session
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		HttpSession session = getRequest().getSession();
		return session;

	}
	
	/**
	 * 获取当前借阅信息查询条件
	 * @return
     */
	public static final BorrowInfo getSessionBorrowTerm() {
		HttpSession session = ContextHolder.getSession();
		BorrowInfo borrowterm= (BorrowInfo)session.getAttribute(ParamConstants.LOCAL_SELETCT_BORROWTERM);
		return borrowterm;
	}
	
	/**
	 * @Title:getSessionError
	 * @Description:获取警告信息(不允许用户借阅)
	 * @author:TwistFate丶QK
	 * @Date:2017年8月18日
	 * @return
	 */
	public static final DisallowInfo getSessionError() {
		HttpSession session = ContextHolder.getSession();
		DisallowInfo disallow= (DisallowInfo)session.getAttribute(ParamConstants.LOCAL__ERROR_INFO);
		return disallow;
	}
	
	
	/**
	 * 获取当前书籍信息查询条件
	 * @return
     */
	public static final BookInfo getSessionBookTerm() {
		HttpSession session = ContextHolder.getSession();
		BookInfo bookterm = (BookInfo)session.getAttribute(ParamConstants.LOCAL_SELETCT_BOOKTERM);
		return bookterm;
	}
	
	
	
	/**
	 * 获取借阅信息
	 * @return
     */
	public static final BorrowInfo getSessionBorrow() {
		HttpSession session = ContextHolder.getSession();
		BorrowInfo borrow= (BorrowInfo)session.getAttribute(ParamConstants.LOCAL__ADDBORROW_INFO);
		return borrow;
	}
	
	/**
	 * 获取归还信息
	 * @return
     */
	public static final ReturnInfo getSessionReturn() {
		HttpSession session = ContextHolder.getSession();
		ReturnInfo returns= (ReturnInfo)session.getAttribute(ParamConstants.LOCAL__ADDRETURN_INFO);
		return returns;
	}
	
	/**
	 * 获取错误信息
	 * @return
     */
	public static final String getErrorTip() {
		HttpSession session = ContextHolder.getSession();
		String error = (String)session.getAttribute(ParamConstants.LOCAL_ERROR_TIP);
		return error;
	}


	/**
	 * 获取当前登录用户
	 * @return
     */
	public static final ReaderUser getSessionUser() {
		HttpSession session = ContextHolder.getSession();
		ReaderUser u = (ReaderUser) session.getAttribute(ParamConstants.LOCAL_CLINET_USER);
		return u;
	}
	
	/**
	 * 获取当前登录的读者
	 * @return
     */
	public static final ReaderReader getSessionReader() {
		HttpSession session = ContextHolder.getSession();
		ReaderReader student = (ReaderReader) session.getAttribute(ParamConstants.LOCAL_CLINET_READER);
		return student;
	}
	
	/**
	 * 获取当前登录的管理员
	 * @return
     */
	public static final ReaderAdmin getSessionAdmin() {
		HttpSession session = ContextHolder.getSession();
		ReaderAdmin teacher = (ReaderAdmin) session.getAttribute(ParamConstants.LOCAL_CLINET_ADMIN);
		return teacher;
	}

//	/**
//	 * 获取当前登录科室
//	 */
//	public static final SysDeptEntity getSessionDept() {
//		HttpSession session = ContextHolder.getSession();
//		SysDeptEntity dept = (SysDeptEntity) session.getAttribute(ParamConstants.LOCAL_CLINET_DEPT);
//		return dept;
//	}
}
