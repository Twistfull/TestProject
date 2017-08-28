package com.bms.reader.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.bms.reader.common.ContextHolder;
import com.bms.reader.common.JsonResult;
import com.bms.reader.constant.DescribableEnum;
import com.bms.reader.constant.ParamConstants;
import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BorrowInfo;
import com.bms.reader.model.DisallowInfo;
import com.bms.reader.model.PayforInfo;
import com.bms.reader.model.ReturnInfo;
import com.bms.reader.service.BookBorrowService;
import com.bms.reader.service.BookInfoService;
import com.bms.reader.service.BookReturnService;
import com.bms.reader.service.ExportInfoService;
@Controller
@RequestMapping("/reader")
public class ReaderController extends MultiActionController {

    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private BookBorrowService bookBorrowService;
    
    @Autowired
    private BookReturnService bookReturnService;
    
    @Autowired
    private ExportInfoService exportInfoService;
    
    
    /**
     * Ctrl+Shift+O(导入未添加的包)
     * @Title:selectbook
     * @Description:查询所有书籍
     * @author:TwistFate丶QK
     * @Date:2017年8月11日
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/bookinfo", method = RequestMethod.GET)
    public ModelAndView selectbook(HttpServletRequest request, HttpServletResponse response)
    {   
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("username",ContextHolder.getSessionReader().getReaderName());
    	
    	List<BookInfo> result=bookInfoService.selectByBookName("oracle",1);
        // JsonResult jsonResult = new JsonResult(DescribableEnum.SUCCESS, result);
    	mv.addObject("list",result);
    	//JsonResult jsonResult = new JsonResult(DescribableEnum.SUCCESS, result);
    	mv.setViewName("reader/bookinfo");
        return mv;
    }
    

    /**
     * @Title:获取图书列表分页信息
     * @Description:
     * @author:TwistFate丶QK
     * @Date:2017年8月13日
     * @param id
     * @return
     */
    @RequestMapping(value = "/bookinfo/pageid")
    public ModelAndView pageSelect(Integer id) {
        ModelAndView mav = new ModelAndView("reader/bookinfo");
        mav = bookInfoService.pageSelectInit(mav, id);
        mav.addObject("username",ContextHolder.getSessionReader().getReaderName());
        return mav;
    }
    
    
    /**
     * @Title:bookDetail
     * @Description:查询书籍详细信息
     * @author:TwistFate丶QK
     * @Date:2017年8月15日
     * @param bookInfo
     * @return
     */
    @RequestMapping(value = "/bookinfo/bookid")
    public ModelAndView bookDetail(String id) {
        ModelAndView mav = new ModelAndView("reader/bookdetail");
        BookInfo Detail= bookInfoService.selectByBookId(id);
        System.out.println(Detail.getPublDate());
        System.out.println(Detail.getStorageDate());
        mav.addObject("Detail",Detail);
        mav.addObject("username",ContextHolder.getSessionReader().getReaderName());
        return mav;
    }
    
    /**
     * @Title:bookInfoSelect
     * @Description:多条件查询书本信息
     * @author:TwistFate丶QK
     * @Date:2017年8月14日
     * @param bookInfo
     * @return
     */
    @RequestMapping(value = "/bookinfo/select")
    public ModelAndView bookInfoSelect(BookInfo bookInfo) {
    	HttpSession session = ContextHolder.getSession();
    	if(ContextHolder.getSessionBookTerm()!=null)
    	{
    		session.removeAttribute(ParamConstants.LOCAL_SELETCT_BOOKTERM);
    	}
        ContextHolder.getSession().setAttribute(ParamConstants.LOCAL_SELETCT_BOOKTERM,bookInfo);//存储查询条件
        ModelAndView mv = new ModelAndView();
        mv = bookInfoService.pageSelectInit(mv, 1);
        mv.addObject("username",ContextHolder.getSessionReader().getReaderName()); 
        if(ContextHolder.getErrorTip()!=null){
        	session.removeAttribute(ParamConstants.LOCAL_ERROR_TIP);
        	mv.setViewName("reader/selecterror");//查询结果为空错误页面显示
        }
        else{
            mv.setViewName("reader/bookinfo");
        }
        return mv;             
    }
    
    
    /**
     * @Title:addBorrow
     * @Description:后台生成借阅信息
     * @author:TwistFate丶QK
     * @Date:2017年8月15日
     * @param id
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value = "/productborrow/bookid")
    @ResponseBody
    public Object produceBorrow(HttpServletRequest request, HttpServletResponse response,BorrowInfo borrowinfo) throws ParseException{
       //ModelAndView mv = new ModelAndView();
        BorrowInfo borrowInfo= bookBorrowService.produceBorrow(borrowinfo);     
        ContextHolder.getSession().setAttribute(ParamConstants.LOCAL__ADDBORROW_INFO,borrowInfo);//存储生成的借阅信息
        
        Map<String, Object> borrowInfoPage= new HashMap<String,Object>();
        borrowInfoPage.put("borrow",borrowInfo);
        borrowInfoPage.put("username",ContextHolder.getSessionReader().getReaderName());
        return new JsonResult(DescribableEnum.SUCCESS,borrowInfoPage);//返回借阅信息的Map对象
        //mv.addObject("borrow",borrowInfo);
        //mv.addObject("username",ContextHolder.getSessionReader().getReaderName());
        //mv.setViewName("reader/addborrow");
        //return mv;
    }
    
    
    /**
     * @Title:addBorrow
     * @Description:添加借阅信息
     * @author:TwistFate丶QK
     * @Date:2017年8月16日
     * @param borrowinfo
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/addborrow")
    @ResponseBody
    public Object addBorrow(HttpServletRequest request, HttpServletResponse response,String operation){
    	HttpSession session = ContextHolder.getSession();
    	System.out.println(operation);
    	if(ContextHolder.getSessionBorrow()==null)
    	{
    		System.out.println("为空");
    		return false;    		
    	}else if(operation.equals("confirm")){ 
    		System.out.println("确认借阅");
    	    BorrowInfo  borrowInfo=ContextHolder.getSessionBorrow();
    	    Boolean status=bookBorrowService.addBorrow(borrowInfo);//将借阅信息写入数据库,并返回是否允许写入
	    	    if(status){//根据返回的status判断是否允许写入
	    	       //session.removeAttribute(ParamConstants.LOCAL__ADDBORROW_INFO);//移除借阅信息
	                return new JsonResult(DescribableEnum.SUCCESS);
	    	    }else{//不允许写入，返回相应提示信息
	    	    	DisallowInfo disallowInfo=ContextHolder.getSessionError();
	    	    	Map<String, Object> itemTypes = new HashMap<String,Object>();
	    	    	itemTypes.put("countborrow", disallowInfo.getCountborrow());  
	    	        itemTypes.put("countoverdue", disallowInfo.getCountoverdue());
	    	        return new JsonResult(DescribableEnum.MISS, itemTypes);
	    	    }
    	 }else if(operation.equals("cancel")){
    		 System.out.println("取消借阅");
    		 session.removeAttribute(ParamConstants.LOCAL__ADDBORROW_INFO);//用户取消借阅，移除借阅信息
    		 return new JsonResult(DescribableEnum.CANCEL);  
    	}else{
    		return false;
    	}
    }
    
    
    /**
     * @Title:disallowBorrow
     * @Description:不允许借阅，提示
     * @author:TwistFate丶QK
     * @Date:2017年8月16日
     * @param operation
     * @return
     */
    @RequestMapping(value = "/disallowborrow")
    @ResponseBody
    public ModelAndView disallowBorrow(String operation){
    	ModelAndView mv = new ModelAndView();
    	return mv;
    }
    

    /**
     * @Title:borrowpageSelect
     * @Description:获取借阅列表分页信息
     * @author:TwistFate丶QK
     * @Date:2017年8月16日
     * @param id
     * @return
     */
    @RequestMapping(value = "/borrowinfo/pageid")
    public ModelAndView borrowpageSelect(Integer id) {
        ModelAndView mav = new ModelAndView("reader/borrowinfo");
        mav = bookBorrowService.borrowpageSelectInit(mav, id);
        mav.addObject("username",ContextHolder.getSessionReader().getReaderName());
        return mav;
    }
    
    
    /**
     * @Title:bookInfoSelect
     * @Description:多条件查询借阅信息
     * @author:TwistFate丶QK
     * @Date:2017年8月14日
     * @param bookInfo
     * @return
     */
    @RequestMapping(value = "/borrowinfo/select")
    @ResponseBody
    public Object borrowInfoSelect(BorrowInfo borrowInfo) {
    	//System.out.println("开始时间"+borrowInfo.getStartDate());
    	//System.out.println("结束时间"+borrowInfo.getEndDate());
    	//System.out.println("borrow"+borrowInfo.getBookName());
    	//System.out.println("book"+borrowInfo.getBookInfo().getBookName());
    	HttpSession session = ContextHolder.getSession();
    	if(ContextHolder.getSessionBorrowTerm()!=null)
    	{
    		session.removeAttribute(ParamConstants.LOCAL_SELETCT_BORROWTERM);
    	}
    	//borrowInfo.getStartDate()!=null||borrowInfo.getEndDate()!=null||borrowInfo.getBookName()!=null
        ContextHolder.getSession().setAttribute(ParamConstants.LOCAL_SELETCT_BORROWTERM,borrowInfo);//存储查询条件
        ModelAndView mv = new ModelAndView();
        mv = bookBorrowService.borrowpageSelectInit(mv, 1);//初始化借阅页面
        mv.addObject("username",ContextHolder.getSessionReader().getReaderName()); 
        if(ContextHolder.getErrorTip()!=null){
        	session.removeAttribute(ParamConstants.LOCAL_ERROR_TIP);
        	mv.setViewName("reader/borrowselecterror");//查询结果为空错误页面显示
        }
        else{
            mv.setViewName("reader/borrowinfo");
        }
        return mv;             
    }
    
    /**
     * @Title:produceRrturn
     * @Description:后台生成归还信息
     * @author:TwistFate丶QK
     * @Date:2017年8月15日
     * @param id
     * @return
     * @throws ParseException 
     */ 
    @RequestMapping(value = "/productreturn/recordid")
    @ResponseBody
    public Object produceRrturn(ReturnInfo returninfo) throws ParseException{
        //ModelAndView mv = new ModelAndView();
        ReturnInfo returnInfo= bookReturnService.produceReturn(returninfo);     
        ContextHolder.getSession().setAttribute(ParamConstants.LOCAL__ADDRETURN_INFO,returnInfo);//存储生成的归还信息
       
        Map<String, Object> returnInfoPage= new HashMap<String,Object>();
        returnInfoPage.put("returns",returnInfo);
        returnInfoPage.put("username",ContextHolder.getSessionReader().getReaderName());
        return new JsonResult(DescribableEnum.SUCCESS,returnInfoPage);//返回借阅信息的Map对象
        //mv.addObject("returns",ReturnInfo);
       // mv.addObject("username",ContextHolder.getSessionReader().getReaderName());
       // mv.setViewName("reader/returnbook");
       // return mv;
    }
    
    
    /**
     * @Title:returnBook
     * @Description:归还书籍
     * @author:TwistFate丶QK
     * @Date:2017年8月18日
     * @param request
     * @param response
     * @param operation
     * @return
     */
    @RequestMapping(value = "/returnbook")
    @ResponseBody
    public Object returnBook(HttpServletRequest request, HttpServletResponse response,String operation){
    	HttpSession session = ContextHolder.getSession();
    	//System.out.println(operation);
    	if(ContextHolder.getSessionReturn()==null)
    	{
    		System.out.println("为空");
    		return false;    		
    	}else if(operation.equals("confirm")){ 
    		System.out.println("确认归还");
    	    ReturnInfo returnInfo=ContextHolder.getSessionReturn();
    	    bookReturnService.returnBook(returnInfo,"在架");//将归还信息写入数据库(有罚款的一起做了处理)  
    	    session.removeAttribute(ParamConstants.LOCAL__ADDRETURN_INFO);//移除归还信息
            return new JsonResult(DescribableEnum.SUCCESS);
    	}else if(operation.equals("cancel")){
    		System.out.println("取消归还");
    		session.removeAttribute(ParamConstants.LOCAL__ADDRETURN_INFO);//用户取消归还，移除归还信息
    		return new JsonResult(DescribableEnum.CANCEL);  
    	}else if(operation.equals("paycancel")){
   		   System.out.println("取消归还");
   		   session.removeAttribute(ParamConstants.LOCAL__ADDRETURN_INFO);//用户取消支付,直接返回
   		   return new JsonResult(DescribableEnum.CANCEL);  
     	}else if(operation.equals("paymoney")){
     	   ReturnInfo returnInfo=ContextHolder.getSessionReturn();
     	   returnInfo.setPayFor(returnInfo.getBorrowInfo().getBookInfo().getBookPrice());
   		   System.out.println("丢失赔偿"+returnInfo.getPayFor());
   		   //ReturnInfo returnInfo=ContextHolder.getSessionReturn();
 	       bookReturnService.returnBook(returnInfo,"丢失");//将丢失信息写入数据库
   		   session.removeAttribute(ParamConstants.LOCAL__ADDRETURN_INFO);//用户赔偿书籍丢失，移除归还信息
   		   return new JsonResult(DescribableEnum.MISS);  
   	    }else{
    		return false;
    	}
    }
    
    
    
    /**
     * @Title:borrowTip
     * @Description:获取逾期提醒
     * @author:TwistFate丶QK
     * @Date:2017年8月16日
     * @param id
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value = "/borrowtip")
    public ModelAndView borrowTip(Integer id) throws ParseException {
        ModelAndView mav = new ModelAndView("reader/borrowtip");
        mav = bookBorrowService.borrowtip(mav);
        mav.addObject("username",ContextHolder.getSessionReader().getReaderName());
        return mav;
    }
    
    
    /**
     * @Title:penaltyInfo
     * @Description:获取罚款(penalty)信息
     * @author:TwistFate丶QK
     * @Date:2017年8月16日
     * @param id
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value = "/penaltyinfo")
    public Object penaltyInfo(Integer id) throws ParseException {
        ModelAndView mav = new ModelAndView("reader/borrowinfo");
        mav = bookBorrowService.borrowtip(mav);
        mav.addObject("username",ContextHolder.getSessionReader().getReaderName());
        return mav;
    }
    
    
    
    /**
     * @Title:test
     * @Description:测试页面
     * @author:TwistFate丶QK
     * @Date:2017年8月21日
     * @param id
     * @return
     */
    @RequestMapping(value = "/tabletest")
    public ModelAndView test(Integer id) {
        ModelAndView mav = new ModelAndView("reader/tabletest");
        return mav;
    }
    
    
    /**
     * @Title:testinfo
     * @Description:bootstrap-table分页测试
     * @author:TwistFate丶QK
     * @Date:2017年8月22日
     * @param limit,offset
     * @return
     */
   @RequestMapping(value = "/testinfo/bookid")
   @ResponseBody
    public JsonResult testinfo(int limit, int offset){
	  // String offect=request.getParameter("offset");
	   System.out.println("行数:"+limit+"总数:"+offset);
	   ModelAndView mv = new ModelAndView();
	   List<BookInfo> rows=bookInfoService.selectByBookName("oracle",(offset/limit+1));    
    	//List<BorrowInfo> list=bookInfoService.listAll(bookInfo);
	   Integer total=10;
	   //Integer rows=10;
    	JsonResult jsonResult = new JsonResult(total,rows);
    	//mv.setViewName("reader/bookinfo");
    	//return Json(new { total = total, rows = rows }, JsonRequestBehavior.AllowGet);
        return jsonResult;
    }
   
   
   /**
    * @Title:test
    * @Description:罚款信息页面
    * @author:TwistFate丶QK
    * @Date:2017年8月21日
    * @param id
    * @return
    */
   @RequestMapping(value = "/payfor")
   public ModelAndView payfor(Integer id) {
       ModelAndView mav = new ModelAndView("reader/payforinfo");
       mav.addObject("username",ContextHolder.getSessionReader().getReaderName());
       return mav;
   }
   
   
   /**
    * @Title:testinfo
    * @Description:罚款信息分页显示
    * @author:TwistFate丶QK
    * @Date:2017年8月22日
    * @param limit,offset
    * @return
    */
  @RequestMapping(value = "/payfor/id")
  @ResponseBody
   public JsonResult payforinfo(int limit, int offset,int id){
	   System.out.println("行数:"+limit+"总数:"+offset+"查询:"+id);
	   List<PayforInfo> rows=bookReturnService.selectByreaderId(ContextHolder.getSessionReader().getId(),(offset/limit+1),limit,id,true);    
   	//List<BorrowInfo> list=bookInfoService.listAll(bookInfo);   
	   long total=9;
	  //System.out.println(rows);
	  for(PayforInfo str:rows){
		   total=str.getTotal();
		   System.out.println(total);
		   if (true) {
			   break;
		  }
	   }
	   //Integer rows=10;
   	JsonResult jsonResult = new JsonResult(total,rows);
   	//mv.setViewName("reader/bookinfo");
   	//return Json(new { total = total, rows = rows }, JsonRequestBehavior.AllowGet);
       return jsonResult;
   }
     /**
     * @Title:export
     * @Description:导出excel(罚款信息)
     * @author:TwistFate丶QK
     * @Date:2017年8月23日
     * @param response
     * @return
     */
    @RequestMapping("/export.do")
    @ResponseBody
       public String export(HttpServletResponse response){    
           response.setContentType("application/binary;charset=UTF-8");
           try{
               ServletOutputStream out=response.getOutputStream();
               String username=ContextHolder.getSessionReader().getReaderName();
               
               String fileName=new String((username+ new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"的借阅罚款总览表").getBytes("gb2312"), "iso8859-1");
               //导出文件名
               response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
               //表头
               String[] titles = { "借阅书籍 ", "借阅日期", "归还日期", "逾期天数(天)","罚款金额(元)","处理情况" }; 
               List<PayforInfo> payfor = bookReturnService.selectByreaderId(ContextHolder.getSessionReader().getId(),0,1,2,false);
               exportInfoService.export(titles, out,payfor);
               return "success";
          } catch(Exception e){
               e.printStackTrace();
               return "导出信息失败";
          }
     }

}
