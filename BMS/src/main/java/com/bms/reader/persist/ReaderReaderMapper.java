package com.bms.reader.persist;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bms.reader.model.ReaderQueryVo;
import com.bms.reader.model.ReaderReader;

public interface ReaderReaderMapper {
	
	
	
	//查找所有的读者
	public List<ReaderReader> findReaderList(ReaderQueryVo readerQueryVo );
	//查找读者数
	public Integer findReaderCount();
	
	public Integer updateReader(ReaderReader readerReader);
	
//    int deleteByPrimaryKey(String id);

    int insert(ReaderReader record);

//    int insertSelective(ReaderReader record);

//    ReaderReader selectByPrimaryKey(String id);
    /**
     * 
     * @Title: selectByUserId 
     * @Description:  根据userId获取读者对象
     * @author: shenlx
     * @param userId
     * @return
     * @return: ReaderReader
     */
    ReaderReader selectByUserId(String userId);
    
	/**
	 * @Title:updataavatar
	 * @Description:更新用户头像信息
	 * @author:TwistFate丶QK
	 * @Date:2017年8月24日
	 * @param path
	 */
	void updataavatar(@Param("path")String path,@Param("readerId")String readerId);

/*    int updateByPrimaryKeySelective(ReaderReader record);

    int updateByPrimaryKey(ReaderReader record);*/
}