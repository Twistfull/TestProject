package com.bms.reader.persist;

import com.bms.reader.model.ReaderAdmin;

public interface ReaderAdminMapper {
  /*  int deleteByPrimaryKey(String id);

    int insert(ReaderAdmin record);

    int insertSelective(ReaderAdmin record);

    ReaderAdmin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReaderAdmin record);

    int updateByPrimaryKey(ReaderAdmin record);*/
    
    /**
     * 
     * @Title: selectByUserId 
     * @Description:  根据userId获取管理员对象
     * @author: shenlx
     * @param userId
     * @return
     * @return: ReaderAdmin
     */
    ReaderAdmin selectByUserId(String userId);
}