package com.bms.reader.service;

import java.util.Map;

import com.bms.reader.model.BorrowQueryVo;
import com.bms.reader.model.ReaderQueryVo;
import com.bms.reader.model.ReaderReader;
import com.bms.reader.model.ReturnQueryVo;

public interface ReaderAdminService {
	public Map findReaderList(ReaderQueryVo readerQueryVo);
	public Map findBorrowReaderBook(BorrowQueryVo borrowQueryVo);
	public Map findReturnInfo(ReturnQueryVo returnQueryVo);
	public Map listReturnByReaderId(String id);
	public Integer findOutNum(int day);
	public Integer findInNum(int day);
	public Integer updateReader(ReaderReader readeReader);
}
