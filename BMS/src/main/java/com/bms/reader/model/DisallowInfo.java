package com.bms.reader.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bms.reader.common.ContextHolder;

public class DisallowInfo implements Serializable{
    /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 未归还数量
     */
    private Integer countborrow;


    /**
     * 逾期数量
     */
    private Integer countoverdue;


	public Integer getCountborrow() {
		return countborrow;
	}


	public void setCountborrow(Integer countborrow) {
		this.countborrow = countborrow;
	}


	public Integer getCountoverdue() {
		return countoverdue;
	}


	public void setCountoverdue(Integer countoverdue) {
		this.countoverdue = countoverdue;
	}

	public DisallowInfo(){
		super();
	}

}
