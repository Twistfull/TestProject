package com.bms.reader.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


//用于封装罚款信息的具体内容
public class PayforInfo implements Serializable{
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
     * 借阅书籍
     */
    private String bookName;

    /**
     * 借阅日期(以免前端再转换格式)
     */
    private String startDate;
    /**
     * 归还日期
     */
    private String endDate;  
    
    /**
     * 逾期天数
     */
    private BigDecimal overDue;
    
    /**
     * 罚款金额
     */
    private BigDecimal payFor;
    
    /**
     *处理情况
     */
    private String payExplain;
    
    /**
     *总条数
     */
    private long total;
    
    /**
     *书籍价格
     */
	private BigDecimal bookPrice;
    
    
	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getOverDue() {
		return overDue;
	}

	public void setOverDue(BigDecimal overDue) {
		this.overDue = overDue;
	}

	public BigDecimal getPayFor() {
		return payFor;
	}

	public void setPayFor(BigDecimal payFor) {
		this.payFor = payFor;
	}

	public String getPayExplain() {
		return payExplain;
	}

	public void setPayExplain(String payExplain) {
		this.payExplain = payExplain;
	}
    public  PayforInfo(String recordId,String bookName, BigDecimal bookPrice, String startDate, String endDate,BigDecimal overDue, BigDecimal payFor,String payExplain, long total){
    	this.recordId=recordId;
    	this.bookName=bookName;
    	this.bookPrice=bookPrice;
    	this.startDate=startDate;
    	this.endDate=endDate;
    	this.overDue=overDue;
    	this.payFor=payFor;
    	this.payExplain=payExplain;
    	this.total=total;
    }


}
