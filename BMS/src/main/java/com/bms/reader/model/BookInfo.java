package com.bms.reader.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bms.reader.constant.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BookInfo implements Serializable{
    /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
//	 try{
//	SimpleDateFormat storage = new SimpleDateFormat("yyyy-MM-dd ");
//	publDate = storage.parse(cstorageDate);
//}
//catch(ParseException e)
//{
//	System.out.println("storage"+e.getMessage());
//}

	/**
     * 主键
     */
    private String bookId;

    /**
     * 书籍类型
     */
    private String bookKind;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 作者
     */
    private String bookAuthor;
    /**
     * 出版社
     */
    private String bookPubl;
    /**
     * 出版日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date publDate;

    /**
     * 价格
     * 如果不指定number的长度，或指定长度n>18
     * id number not null，转换为pojo类时，为Java.math.BigDecimal类型
     * 如果number的长度在10 <= n <= 18
     * id number(n) not null，转换为pojo类时，为java.lang.Long类型
     * 如果number的长度在1 <= n <= 9
     * id number(n) not null，转换为pojo类时，为java.lang.Integer类型
     */
    private   BigDecimal bookPrice;
    
    /**
     * 在架位置
     */
    private String bookAddress;
       
    /**
     * 入库时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date storageDate;

	/**
     * 简介
     */
    private String bookIntro;
    
    /**
     * 状态
     */
    private String bookStatus;
    
/*    *//**
     * 页数
     *//*
    private Integer pageAll;
    
    
       
	
    public Integer getPageAll() {
		return pageAll;
	}

	public void setPageAll(Integer pageAll) {
		if(pageAll==null)
			pageAll=1;
		this.pageAll = pageAll;
	}
*/
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookKind() {
		return bookKind;
	}

	public void setBookKind(String bookKind) {
		this.bookKind = bookKind;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPubl() {
		return bookPubl;
	}

	public void setBookPubl(String bookPubl) {
		this.bookPubl = bookPubl;
	}
     
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")

	public Date getPublDate() {
		return publDate;
	}

	public void setPublDate(Date publDate) {
		this.publDate = publDate;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookAddress() {
		return bookAddress;
	}

	public void setBookAddress(String bookAddress) {
		this.bookAddress = bookAddress;
	}

	public Date getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}

	public String getBookIntro() {
		return bookIntro;
	}

	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}
	
	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	

	public BookInfo() {
        super();
    }

	public BookInfo(String bookId, String bookKind,String bookName,String bookAuthor,String bookPubl,
			 Date publDate,BigDecimal bookPrice,String bookAddress, Date storageDate, String bookIntro,String bookStatus) {
		    this.bookId=bookId;
		    this.bookKind=bookKind;
		    this.bookName=bookName;
		    this.bookAuthor=bookAuthor;
		    this.bookPubl=bookPubl;
		    this.publDate=publDate;
		    this.bookPrice=bookPrice;
		    this.bookAddress=bookAddress;
		    this.storageDate=storageDate;
		    this.bookIntro=bookIntro;
		    this.bookStatus=bookStatus;
    }


}
