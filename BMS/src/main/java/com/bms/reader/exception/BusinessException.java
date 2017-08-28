package com.bms.reader.exception;

import com.bms.reader.constant.Describable;

/**
 * 
 * @ClassName: BusinessException
 * @Description: 
 * @author: 
 * @date: 2017/07/26
 * @version: v1.0
 */
@SuppressWarnings("all")
public class BusinessException extends DescribableException
{
	public BusinessException(Describable describableInfo) {
		super(describableInfo);
	}
	
	public BusinessException(Describable describableInfo, String errorDetails) {
		super(describableInfo, errorDetails);
	}
	
	public BusinessException(Describable describableInfo, Object data) {
		super(describableInfo, data);
	}
	
	public BusinessException(Integer code, String  msg) {
		super(code, msg);
	}
}
