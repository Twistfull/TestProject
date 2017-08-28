package testcase;

import java.math.BigDecimal;

import org.junit.Assert;  
import org.junit.Before;  
import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTestCase;
import base.BaseTransactionTestCase;

import com.bms.reader.model.BookInfo;
import com.bms.reader.service.BookInfoService;

  
public class ProductIndexTestCase extends BaseTestCase{  
	
	@Autowired
	private BookInfoService bookInfoService;
  
    @Before  
    public void setUp() throws Exception {  
          
    }

//书籍插入单例
    
    @Test  
    public void testInsertBookInfo() throws Exception{ 
    	
    	BookInfo bookinfo=new BookInfo();
    	bookinfo.setBookName("oracle 开发实践教程2");
    	bookinfo.setBookAuthor("金花花");
    	bookinfo.setBookKind("科学技术");
    	double price=108.09;
    	BigDecimal Price= new BigDecimal(price);
    	bookinfo.setBookPrice( Price);
    	bookinfo.setBookStatus("在架");
    	int i=bookInfoService.addBook(bookinfo);
    	Assert.assertEquals(1, i);//断言
    	System.out.println(bookinfo.getBookId());
//        Assert.assertEquals(1, i);  
    }  
} 