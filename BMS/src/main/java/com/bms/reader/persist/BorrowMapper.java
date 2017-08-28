package com.bms.reader.persist;

import java.util.List;

import com.bms.reader.model.BorrowPojo;
import com.bms.reader.model.BorrowQueryVo;

public interface BorrowMapper {
	public List<BorrowPojo> findBorrowReaderBook(BorrowQueryVo borrowQueryVo);
	public Integer findBorrowCount();
	public Integer findOutNum(int day);
}
