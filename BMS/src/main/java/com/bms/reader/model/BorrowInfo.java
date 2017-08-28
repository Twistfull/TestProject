package com.bms.reader.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BorrowInfo implements Serializable{
    /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 主键
     */
    private String recordId;

    /**
     * 读者编号
     */
    private String readerId;
    /**
     * 书籍编号
     */
    private String bookId;
    /**
     * 借阅日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    /**
     * 归还日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    
    
    /**
     * 逾期天数提醒
     */
    private int tipday;
    
    public int getTipday() {
		return tipday;
	}
	public void setTipday(int tipday) {
		this.tipday = tipday;
	}


	/**
     * 书籍信息映射
     */
	private BookInfo bookInfo;
	
    public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	
	
    private ReturnInfo returnInfo;
	
    
	
	public ReturnInfo getReturnInfo() {
		return returnInfo;
	}
	public void setReturnInfo(ReturnInfo returnInfo) {
		this.returnInfo = returnInfo;
	}


	private DisallowInfo disallowInfo;

	 public DisallowInfo getDisallowInfo() {
		return disallowInfo;
	}
	public void setDisallowInfo(DisallowInfo disallowInfo) {
		this.disallowInfo = disallowInfo;
	}


	/**
     * 生成借阅信息时，存储书籍名称
     */
    private String bookName;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
    
	
	
	

	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getReaderId() {
		return readerId;
	}
	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public BorrowInfo(){
		super();
	}
	public BorrowInfo(String recordId,String readerId,String bookId,Date startDate,Date endDate){
		this.recordId=recordId;
		this.readerId=readerId;
		this.bookId=bookId;
		this.startDate=startDate;
		this.endDate=endDate;
		
	}

}
