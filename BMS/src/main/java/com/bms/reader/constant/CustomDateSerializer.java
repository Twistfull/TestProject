package com.bms.reader.constant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


/** 
* @description 自定义返回JSON 数据格中日期格式化处理 
* @author aokunsang 
* @date 
*/  
public class CustomDateSerializer extends JsonSerializer<Date> {  

  @Override  
  public void serialize(Date value,   
          JsonGenerator jsonGenerator,   
          SerializerProvider provider)  
          throws IOException, JsonProcessingException {  
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
      jsonGenerator.writeString(sdf.format(value));  
  }  
} 
