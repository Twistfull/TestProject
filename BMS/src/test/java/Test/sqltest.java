package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.reader.model.BookInfo;
import com.bms.reader.service.BookInfoService;

public class sqltest {
	@Test
	public void test() throws ParseException
	{
		  Date now=new Date();
		  SimpleDateFormat datemodel=new SimpleDateFormat("yyyy-MM-dd");
		  String date = datemodel.format(now);//Date转String转换为yyyy-MM-dd类型
		  Date  start = datemodel.parse(date);//将String类型转会Date
		
		  Calendar rightNow = Calendar.getInstance();
		  rightNow.setTime(start);
		  //rightNow.add(Calendar.YEAR,-1);//日期减1年
		  //rightNow.add(Calendar.MONTH,1);//日期加1个月
		  rightNow.add(Calendar.DAY_OF_YEAR,+31);//日期加31天
		  Date end=rightNow.getTime();
		  System.out.println(start);
		  System.out.println(end);

	}

}
