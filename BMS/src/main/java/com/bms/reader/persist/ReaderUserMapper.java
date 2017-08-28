package com.bms.reader.persist;

import com.bms.reader.model.ReaderUser;;
/**
 * 
 * @ClassName: StudyUserMapper 
 * @Description: 用户mapper
 * @author: shenlx
 * @date: 2017年3月28日 下午5:18:42
 */
public interface ReaderUserMapper {
   
//  int deleteByPrimaryKey(String id);

    int insert(ReaderUser record);

//    int insertSelective(ReaderUser record);

//    ReaderUser selectByPrimaryKey(String id);
    
    /**
     * 
     * @Title: selectByUserName 
     * @Description: 根据用户名查询用户
     * @author: shenlx
     * @param username
     * @return
     * @return: StudyUser
     */
	
    ReaderUser selectByUserName(String username);



/*    int updateByPrimaryKeySelective(ReaderUser record);

    int updateByPrimaryKey(ReaderUser record);*/
}