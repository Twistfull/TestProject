package com.bms.reader.service;

import org.springframework.web.servlet.ModelAndView;

import com.bms.reader.constant.DescribableEnum;
import com.bms.reader.model.ReaderUser;


public interface LoginService {

	/**
	 *
	 * @Title: GetLoginName
	 * @Description: 获取登录名称
	 * @return
	 * @return: String
	 */
	String getLoginName();
	
	/**
	 *
	 * @Title: doLogin
	 * @Description: 用户登录校验
	 * @author: shenlx
	 * @param studyUser
	 * @return: void
	 */
	DescribableEnum doLogin(ReaderUser readerUser);

    /**
	 *
	 * @Title: doLogout
	 * @Description: 退出登录
	 * @author: shenlx
	 * @return: void
	 */
	void doLogout();
	
/*	
	*//**
	 *
	 * @Title: getUserInfo
	 * @Description: 获取用户信息
	 * @author: QK
	 * @return: void
	 *//*
	List getUserInfo();*/

	/**
	 * 获取菜单
	 * @return
	 * @author jerry.pan
	 * @date 2017-04-12 10:04:33
	 *//*
	List menu();*/
}
