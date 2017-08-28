package com.bms.reader.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.bms.reader.common.ContextHolder;
import com.bms.reader.constant.DescribableEnum;
import com.bms.reader.constant.ParamConstants;
import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BookInfoQueryVo;
import com.bms.reader.model.PayforInfo;
import com.bms.reader.persist.BookInfoMapper;
import com.bms.reader.service.BookInfoService;
import com.bms.reader.service.BookReturnService;
import com.bms.reader.service.ExportInfoService;
import com.bms.reader.util.TransformToColumn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ExportInfoServiceImpl implements ExportInfoService {
    
	  @Autowired
	   private BookInfoMapper bookInfoMapper;

	@Override
	public void export(String[] titles, ServletOutputStream out,List<PayforInfo> payfor) {		
        try{
            // 第一步，创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");
           // hssfSheet.autoSizeColumn(1, true);     //自动列宽      
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow hssfRow = hssfSheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = workbook.createCellStyle();
            //居中样式
           // style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直   
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平   
            HSSFCell hssfCell = null;
            for (int i = 0; i < titles.length; i++) {
            	if(i<3){
            	  hssfSheet.setColumnWidth(i, titles[i].getBytes().length*2*256);//设置列宽
            	}else{
            	  hssfSheet.setColumnWidth(i, titles[i].getBytes().length*1*256);//设置列宽
            	}
                hssfCell = hssfRow.createCell(i);//列索引从0开始
                hssfCell.setCellValue(titles[i]);//列名1
                hssfCell.setCellStyle(style);//列居中显示  
               // hssfCell.setCellComment(comment);
            }      
            // 第五步，写入传入的数据    

           // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            if(payfor != null && !payfor.isEmpty()){
                /*for (int i = 0; i < users.size(); i++) {*/
            	int i=0;
                for (PayforInfo str: payfor) {
                    hssfRow = hssfSheet.createRow(i+1);                
                    
                    // 第六步，创建单元格，并设置值
                    hssfRow.setRowStyle(style);
                    hssfRow.createCell(0).setCellValue(str.getBookName());                   
                    hssfRow.createCell(1).setCellValue(str.getStartDate());
                    String EndDate = "";
                    if(str.getEndDate() != null){
                    	EndDate = str.getEndDate();
                    }else{
                    	EndDate="未归还";
                    }
                    hssfRow.createCell(2).setCellValue(EndDate);
                    //String OverDue = "";
                    long OverDue=0;
                    long getoverDue=str.getOverDue().longValue();//把BigDecimal转换成long
                    if(getoverDue<0){
                    	OverDue = 0;
                    }else{
                    	OverDue=getoverDue;
                    }
                    hssfRow.createCell(3).setCellValue(OverDue);
                    double PayFor=0.00;
                    double getpayFor=str.getPayFor().doubleValue();
                    if(getpayFor<0){
                    	PayFor = 0.00;
                    }else{
                    	PayFor=getpayFor;
                    }
                    hssfRow.createCell(4).setCellValue(PayFor);
                    String PayExplain = "";
                    if(str.getPayExplain()!= null){
                    	PayExplain = str.getPayExplain();
                    }else{
                    	PayExplain ="未处理";
                    }
                    hssfRow.createCell(5).setCellValue(PayExplain);
                    i++;
                   // System.out.println("输出行数:"+i);
                }               
              }            
            // 第七步，将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
           System.out.println("导出信息失败！");
        }    
    }
}
