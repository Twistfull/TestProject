package com.bms.reader.service.impl;

import com.bms.reader.common.ContextHolder;
import com.bms.reader.constant.ParamConstants;
import com.bms.reader.constant.DescribableEnum;
import com.bms.reader.exception.BusinessException;
import com.bms.reader.model.*;
import com.bms.reader.persist.*;
import com.bms.reader.model.ReaderUser;
import com.bms.reader.service.LoginService;
import com.bms.reader.util.MD5;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private ReaderUserMapper readerUserMapper;

	@Autowired
	private ReaderReaderMapper readerReaderMapper;

	@Autowired
	private ReaderAdminMapper readerAdminMapper;

	/**
	 *
	 * @Title: GetLoginName
	 * @Description: 获取登录名称
	 * @return
	 * @return: String
	 */
	@Override
	public String getLoginName() {
		try {
			ReaderUser u = ContextHolder.getSessionUser();
			if (u == null)
				return "";
			if (u.getUserType().equals(ParamConstants.USER_TYPE_0)) {
				return ContextHolder.getSessionReader().getReaderName();
			} else if (u.getUserType().equals(ParamConstants.USER_TYPE_1)) {
				return ContextHolder.getSessionAdmin().getAdminName();
			}
			return u.getUsername();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
	

	/**
	 *
	 * @Title: doLogin
	 * @Description: 用户登录校验
	 * @author: shenlx
	 * @param studyUser
	 * @return:
	 */
	@Override
	public DescribableEnum doLogin(ReaderUser readerUser) {
		if (null == readerUser) {
			System.out.println(DescribableEnum.UNKNOWNUSER.getMsg());// 用户类对象为空，用户名不存在
			return DescribableEnum.UNKNOWNUSER;
		} else {
			/* StringUtils.isBlank判断某字符串是否为空或长度为0或由空白符(whitespace) 构成 */
			if (StringUtils.isBlank(readerUser.getUsername())) {
				System.out.println(DescribableEnum.UNKNOWNUSER1.getMsg());// 用户名为空，用户名不存在
				return DescribableEnum.UNKNOWNUSER;
			} else {
				ReaderUser u = readerUserMapper.selectByUserName(readerUser.getUsername());
				if (null == u) {
					System.out.println(DescribableEnum.UNKNOWNUSER2.getMsg());// 查询不到用户，用户名不存在
					return DescribableEnum.UNKNOWNUSER;
				} else {
					if (StringUtils.equals(MD5.getMD5(readerUser.getPassword()), u.getPassword())) {

						if (StringUtils.equals(u.getUserType(), ParamConstants.USER_TYPE_0)) {
							System.out.println("这是一个读者===================");

							ReaderReader reader = readerReaderMapper.selectByUserId(u.getId());

							ContextHolder.getSession().setAttribute(ParamConstants.LOCAL_CLINET_READER, reader);

						} else if (StringUtils.equals(u.getUserType(), ParamConstants.USER_TYPE_1)) {
							System.out.println("这是一个管理员===================");

							ReaderAdmin admin = readerAdminMapper.selectByUserId(u.getId());
							
							/*System.out.println("这是一个管理员获取到的数据===================");*/
                             
							ContextHolder.getSession().setAttribute(ParamConstants.LOCAL_CLINET_ADMIN, admin);

						} else {
							System.out.println("未指定用户类型===================");
						}

						// 存放用户对象到session中
						ContextHolder.getSession().setAttribute(ParamConstants.LOCAL_CLINET_USER, u);
						return DescribableEnum.SUCCESS;

					} else {
						System.out.println(DescribableEnum.ERROR_PWD.getMsg());// 密码错误
						return DescribableEnum.ERROR_PWD;
					}
				}
			}
		}
	}



	/**
	 * 登出
	 */
	@Override
	public void doLogout() {
		HttpSession session = ContextHolder.getSession();
		if (session != null) {
			session.removeAttribute(ParamConstants.LOCAL_CLINET_USER);
			session.removeAttribute(ParamConstants.LOCAL_CLINET_READER);
			session.removeAttribute(ParamConstants.LOCAL_CLINET_ADMIN);
			//session.removeAttribute(ParamConstants.LOCAL_SELETCT_TERM);
			session.invalidate();//清空所有已定义的session的对象
		}
	}

	/**
	 * 获取菜单
	 * @return
	 * @author jerry.pan
	 * @date 2017-04-12 10:04:33
	 *//*
	@Override
	public List menu(){
		StudyUser studyUser = ContextHolder.getSessionUser();
		String userType = studyUser.getUserType();
		String menuJson = "";
		if(ParamConstants.USER_TYPE_0.equals(userType)){//学生
			menuJson = "[{\"name\":\"学生菜单\",\"url\":\"\",\"class\":\"glyphicon-education\",\"child\":[{\"name\":\"作业列表\",\"url\":\"/study/homework/page/list?publishStatus=1\",\"class\":\"glyphicon-book\",\"icon\":\"icon-more\"}]}]";
		}else if(ParamConstants.USER_TYPE_1.equals(userType)){//老师
			menuJson = "[{\"name\":\"老师菜单\",\"url\":\"\",\"class\":\"glyphicon-education\",\"child\":[{\"name\":\"我的发布\",\"url\":\"/study/homework/page/findByTeacher\",\"class\":\"glyphicon-book\",\"icon\":\"icon-more\"}]}]";
		}
		List menuList = JacksonUtil.json2Bean(menuJson,ArrayList.class);
		return menuList;
	}*/
}
