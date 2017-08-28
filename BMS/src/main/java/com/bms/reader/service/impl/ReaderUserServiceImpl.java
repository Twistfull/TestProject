package com.bms.reader.service.impl;

import com.bms.reader.common.ContextHolder;
import com.bms.reader.constant.ParamConstants;
import com.bms.reader.model.ReaderReader;
import com.bms.reader.model.ReaderUser;
import com.bms.reader.persist.ReaderReaderMapper;
import com.bms.reader.persist.ReaderUserMapper;
import com.bms.reader.service.ReaderUserService;
import com.bms.reader.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @ClassName: ReaderuserService
 * @Description: 用户相关service实现类
 * @author: shenlx
 * @date: 2017年3月29日 上午8:51:12
 */
@Service
public class ReaderUserServiceImpl implements ReaderUserService {

	@Autowired
	private ReaderUserMapper readerUserMapper;
	@Autowired
	private ReaderReaderMapper readerReaderMapper;
	/*@Autowired
	private StudyTeacherMapper studyTeacherMapper;*/

	/**
	 * 
	 * @Title: doLogin
	 * @Description: 用户登录校验
	 * @author: shenlx
	 * @param studyUser
	 * @return: String
	 *//*
	@Override
	public String doLogin(StudyUser studyUser) {

		if (null == studyUser) {
			return JacksonUtil.bean2Json(new JsonResult(DescribableEnum.UNKNOWNUSER));
		} else {
			if (StringUtils.isBlank(studyUser.getUsername())) {
				return JacksonUtil.bean2Json(new JsonResult(DescribableEnum.UNKNOWNUSER));// 用户名不存在
			} else {
				StudyUser u = studyUserMapper.selectByUserName(studyUser.getUsername());
				if (null == u) {
					return JacksonUtil.bean2Json(new JsonResult(DescribableEnum.UNKNOWNUSER));// 用户名不存在
				} else {
					if (StringUtils.equals(MD5.getMD5(studyUser.getPassword()), u.getPassword())) {

						return JacksonUtil.bean2Json(new JsonResult(DescribableEnum.SUCCESS,u));

					} else {
						
						return JacksonUtil.bean2Json(new JsonResult(DescribableEnum.ERROR_PWD));// 密码错误
						
					}
				}
			}
		}

	}
	
	*//**
	 * 
	 * @Title: selectStudentByUserId 
	 * @Description: 通过用户ID获取学生对象
	 * @author: shenlx
	 * @param userId
	 * @return
	 * @return: StudyStudent
	 *//*
	@Override
	public StudyStudent selectStudentByUserId(String userId) {
		return studyStudentMapper.selectByUserId(userId);
	}

	*//**
	 * 
	 * @Title: selectTeacherByUserId 
	 * @Description: 通过用户ID获取老师对象
	 * @author: shenlx
	 * @param userId
	 * @return
	 * @return: StudyTeacher
	 *//*
	@Override
	public StudyTeacher selectTeacherByUserId(String userId) {
		return studyTeacherMapper.selectByUserId(userId);
	}

	*//**
	 * 
	 * @Title: remoteUsername
	 * @Description: 校验用户名唯一性
	 * @author: shenlx
	 * @param username
	 * @return
	 * @return: boolean
	 */
	@Override
	public boolean remoteUsername(String username) {
		ReaderUser u = readerUserMapper.selectByUserName(username);
		if (null != u) {// 用户已经存在
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 
	 * @Title: addRegister
	 * @Description: 用户注册
	 * @author: shenlx
	 * @param readerUser
	 * @param readerName
	 *  读者注册，并只保存读者姓名
	 * @return
	 */
	@Override
	public void addRegister(ReaderUser readerUser, String readerName) {
    if(readerUserMapper.selectByUserName(readerUser.getUsername())==null&& readerUser!=null){
		readerUser.setUserType(ParamConstants.USER_TYPE_0);
		readerUser.setPassword(MD5.getMD5(readerUser.getPassword()));
		readerUserMapper.insert(readerUser);
		System.out.println("注册成功");
		ReaderReader reader = new ReaderReader();
		reader.setUserId(readerUser.getId());
		reader.setReaderName(readerName);
		readerReaderMapper.insert(reader);
		ContextHolder.getSession().setAttribute(ParamConstants.LOCAL_CLINET_USER, readerUser);
		ContextHolder.getSession().setAttribute(ParamConstants.LOCAL_CLINET_READER, reader);
		}
     else{
    	  System.out.println("已存在");
      }
	}


}
