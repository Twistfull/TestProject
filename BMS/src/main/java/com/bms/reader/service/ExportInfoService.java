package com.bms.reader.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.springframework.web.servlet.ModelAndView;

import com.bms.reader.constant.DescribableEnum;
import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BookInfoQueryVo;
import com.bms.reader.model.PayforInfo;
import com.github.pagehelper.PageInfo;


public interface ExportInfoService {

	/**
	 * @Title:export
	 * @Description:导出到客户端下载
	 * @author:TwistFate丶QK
	 * @Date:2017年8月23日
	 * @param titles
	 * @param out
	 * @param payfor 
	 */
	public void export(String[] titles, ServletOutputStream out, List<PayforInfo> payfor);
    



}
