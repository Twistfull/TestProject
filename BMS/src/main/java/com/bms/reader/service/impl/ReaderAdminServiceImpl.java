package com.bms.reader.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.reader.model.BorrowPojo;
import com.bms.reader.model.BorrowQueryVo;
import com.bms.reader.model.ReaderQueryVo;
import com.bms.reader.model.ReaderReader;
import com.bms.reader.model.ReturnPojo;
import com.bms.reader.model.ReturnQueryVo;
import com.bms.reader.persist.BorrowMapper;
import com.bms.reader.persist.ReaderReaderMapper;
import com.bms.reader.persist.ReturnMapper;
import com.bms.reader.service.ReaderAdminService;
import com.bms.reader.util.TransformToColumn;
import com.github.pagehelper.PageHelper;
@Service
public class ReaderAdminServiceImpl implements ReaderAdminService {

	@Autowired
	private ReaderReaderMapper readerReaderMapper;
	
	@Autowired
	private BorrowMapper borrowMapper;
	
	@Autowired
	private ReturnMapper returnMapper;
	
	public Map findReaderList(ReaderQueryVo readerQueryVo) {
		//当前页数
		int currentPage = readerQueryVo.getPage();
		// 每页的行数
		int rows=readerQueryVo.getRows();
		// 起始记录
		int start = (currentPage - 1) * rows+1;
		//截止记录
		int end=start+rows-1;
		//以何种方式排序
		String sort=readerQueryVo.getSort();
		//转化成字段
		String tableSort=TransformToColumn.transfromToReaderColumn(sort);
		readerQueryVo.setTableSort(tableSort);
		List<ReaderReader> readers=new ArrayList<ReaderReader>();
		PageHelper.startPage(currentPage, rows);
		readers=readerReaderMapper.findReaderList(readerQueryVo);
		System.out.println(readers);
		// 总共记录数
		int total=readerReaderMapper.findReaderCount();
		Map map=new HashMap();
		map.put("total", total);
		map.put("rows", readers);
		return map;
	}

	public Map findBorrowReaderBook(BorrowQueryVo borrowQueryVo) {
		int currentPage = borrowQueryVo.getPage();
		// 每页的行数
		int rows=borrowQueryVo.getRows();
		// 起始记录
		int start = (currentPage - 1) * rows+1;
		//截止记录
		int end=start+rows-1;
		//以何种方式排序
		String sort=borrowQueryVo.getSort();
		//转化成字段
		String tableSort=TransformToColumn.transfromToBorrowColumn(sort);
		borrowQueryVo.setTableSort(tableSort);
		List<BorrowPojo> borrows=new ArrayList<BorrowPojo>();
		PageHelper.startPage(currentPage, rows);
		borrows=borrowMapper.findBorrowReaderBook(borrowQueryVo);
		// 总共记录数
		int total=borrowMapper.findBorrowCount();
		Map map=new HashMap();
		map.put("total", total);
		map.put("rows", borrows);
		return map;
	}

	public Map findReturnInfo(ReturnQueryVo returnQueryVo) {
		int currentPage = returnQueryVo.getPage();
		// 每页的行数
		int rows=returnQueryVo.getRows();
		// 起始记录
		int start = (currentPage - 1) * rows+1;
		//截止记录
		int end=start+rows-1;
		//以何种方式排序
		String sort=returnQueryVo.getSort();
		//转化成字段
		String tableSort=TransformToColumn.transfromToReturnColumn(sort);
		returnQueryVo.setTableSort(tableSort);
		List<ReturnPojo> returns=new ArrayList<ReturnPojo>();
		PageHelper.startPage(currentPage, rows);
		returns=returnMapper.findReturnInfo(returnQueryVo);
		// 总共记录数
		int total=returnMapper.findReturnCount();
		Map map=new HashMap();
		map.put("total", total);
		map.put("rows", returns);
		return map;
	}

	public Map listReturnByReaderId(String id) {
		List<ReturnPojo> returns=returnMapper.listReturnByReaderId(id);
		// 总共记录数
		int total=returnMapper.findReturnCount();
		Map map=new HashMap();
		map.put("total", total);
		map.put("rows", returns);
		return map;
	}

	public Integer findOutNum(int day) {
		return borrowMapper.findOutNum(day);
	}

	public Integer findInNum(int day) {
		return returnMapper.findInNum(day);
	}

	public Integer updateReader(ReaderReader readerReader) {

		return readerReaderMapper.updateReader(readerReader);
	}


	
}
