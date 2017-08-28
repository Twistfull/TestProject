package com.bms.reader.persist;

import java.util.List;

import com.bms.reader.model.ReturnPojo;
import com.bms.reader.model.ReturnQueryVo;

public interface ReturnMapper {
	public List<ReturnPojo> findReturnInfo(ReturnQueryVo returnQueryVo);
	public Integer findReturnCount();
	public List<ReturnPojo> listReturnByReaderId(String id);
	public Integer findInNum(int day);
}
