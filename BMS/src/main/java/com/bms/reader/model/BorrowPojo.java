package com.bms.reader.model;

public class BorrowPojo extends BorrowInfo{
	private ReaderReader reader;
	private BookInfo bookInfo;
	public ReaderReader getReader() {
		return reader;
	}
	public void setReader(ReaderReader reader) {
		this.reader = reader;
	}
	public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	
}
