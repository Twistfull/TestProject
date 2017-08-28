package com.bms.reader.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReturnInfo implements Serializable{
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
     * 归还日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date returnDate;
    
    /**
     * 逾期天数
     */
    private BigDecimal overdueDay;
    
    /**
     * 罚款金额
     */
    private BigDecimal payFor;
    /**
     * 借阅日期
     */
    private String payExplain;
    
    /*
     * 结果集
     */
    private BorrowInfo borrowInfo;
    
    
	
	public BorrowInfo getBorrowInfo() {
		return borrowInfo;
	}
	public void setBorrowInfo(BorrowInfo borrowInfo) {
		this.borrowInfo = borrowInfo;
	}
	
	
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public BigDecimal getOverdueDay() {
		return overdueDay;
	}
	public void setOverdueDay(BigDecimal overdueDay) {
		this.overdueDay = overdueDay;
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
	public ReturnInfo(){
		super();
	}
	
	public ReturnInfo(String recordId,Date returnDate,BigDecimal overdueDay,BigDecimal payFor,String payExplain){
		this.recordId=recordId;
		this.returnDate=returnDate;
		this.overdueDay=overdueDay;
		this.payFor=payFor;
		this.payExplain=payExplain;
		
	}

}
