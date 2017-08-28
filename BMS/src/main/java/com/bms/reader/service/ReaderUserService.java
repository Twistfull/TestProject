package com.bms.reader.service;

/*import com.bms.reader.model.ReaderReader;
import com.bms.reader.model.ReaderAdmin;*/
import com.bms.reader.model.ReaderUser;

/**
 * 
 * @ClassName: StudyUserService 
 * @Description: 用户相关service
 * @author: shenlx
 * @date: 2017年3月29日 上午8:52:49
 */
public interface ReaderUserService {

/*	*//**
	 * 
	 * @Title: doLogin 
	 * @Description: 用户登录校验
	 * @author: shenlx
	 * @param studyUser
	 * @return: void
	 *//*
	public String doLogin(StudyUser studyUser);
	
	*//**
	 * 
	 * @Title: selectStudentByUserId 
	 * @Description: 通过用户ID获取学生对象
	 * @author: shenlx
	 * @param userId
	 * @return
	 * @return: StudyStudent
	 *//*
	public StudyStudent selectStudentByUserId(String userId);
	
	*//**
	 * 
	 * @Title: selectTeacherByUserId 
	 * @Description: 通过用户ID获取老师对象
	 * @author: shenlx
	 * @param userId
	 * @return
	 * @return: StudyTeacher
	 *//*
	public StudyTeacher selectTeacherByUserId(String userId);
	
	
	*//**
	 * 
	 * @Title: remoteUsername 
	 * @Description: 校验用户名唯一性
	 * @author: shenlx
	 * @param username
	 * @return
	 * @return: boolean
	 */
	public boolean remoteUsername(String username);
	
	
	/**
	  * 
	  * @Title: addRegister 
	  * @Description: 用户注册
	  * @author: shenlx
	  * @param studyUser
	  * @param studentName  这里为了方便，只做了读者注册，并只保存读者姓名
	  * @return
	  */
	public void addRegister(ReaderUser readerUser,String readerName);




	
}
