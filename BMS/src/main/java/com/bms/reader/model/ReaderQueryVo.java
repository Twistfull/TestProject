package com.bms.reader.model;

public class ReaderQueryVo {
	private ReaderReader readerReader;
	//以何字段排序(为属性，须将转换成表的字段)
	private String sort;
	//对应的表的字段
	private String tableSort;
	//升序还是降序
	private String order;
	//查找记录起始下标
	private int start=0;
	//查找记录截止数
	private int end=0;
	
	//每页记录数
	private int rows=10;
	//当前页数
	private int page=1;
	public ReaderReader getReaderReader() {
		return readerReader;
	}
	public void setReaderReader(ReaderReader readerReader) {
		this.readerReader = readerReader;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getTableSort() {
		return tableSort;
	}
	public void setTableSort(String tableSort) {
		this.tableSort = tableSort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
