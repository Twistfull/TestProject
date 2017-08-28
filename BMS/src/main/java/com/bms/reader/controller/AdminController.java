package com.bms.reader.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.reader.common.JsonResult;
import com.bms.reader.model.BookInfo;
import com.bms.reader.model.BookInfoQueryVo;
import com.bms.reader.model.BorrowQueryVo;
import com.bms.reader.model.ReaderQueryVo;
import com.bms.reader.model.ReaderReader;
import com.bms.reader.model.ReturnQueryVo;
import com.bms.reader.service.BookInfoService;
import com.bms.reader.service.ReaderAdminService;

@Controller
@RequestMapping(value = "/admin") // 解决easyui的form提交数据乱码问题
public class AdminController {

	@Autowired
	private ReaderAdminService readerAdminService;

	@Autowired
	private BookInfoService bookInfoService;
	// 跳转到查看读者界面
	@RequestMapping("/showReaders")
	public String showReaders() {
		return "admin/users_back";
	}
	
	// 查看读者信息
	@ResponseBody
	@RequestMapping("/findReaderList")
	public Map findReaderList(ReaderQueryVo readerQueryVo) throws Exception {
		return readerAdminService.findReaderList(readerQueryVo);
	}

	// 跳转到添加图书界面
	@RequestMapping("/addBook")
	public String addBook() {
		return "admin/bookAdd";
	}

	// 保存添加的图书
	@ResponseBody
	@RequestMapping(value = "/addBookAction", produces = "application/json;charset=UTF-8")
	public JsonResult addBookAction(BookInfo bookInfo, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// response.setCharacterEncoding("UTF-8");
		// response.setContentType("application/json;charset=UTF-8");// 传输json数据
		// PrintWriter pw = response.getWriter();
		int result = bookInfoService.addBook(bookInfo);
		if (result != 0) {
			// return "{\"success\"" + ":true," + "\"msg\":" + "\"" + "添加成功" + "\"" + "}";
			return new JsonResult(1, "成功");
		} else
			// pw.write("{\"success\"" + ":false," + "\"msg\":" + "\"" + "添加失败" + "\"" +
			// "}");
			// return "{\"success\"" + ":false," + "\"msg\":" + "\"" + "添加失败" + "\"" + "}";
			return new JsonResult(0, "失败");
	}

	// 跳转查看图书界面
	@RequestMapping("listAll")
	public String listAll() {
		return "admin/listAll";
	}

	// 查看图书信息
	@ResponseBody
	@RequestMapping(value = "/listAllAction")
	public Map listAll(BookInfoQueryVo bookInfoQueryVo) {
		return bookInfoService.listAll(bookInfoQueryVo);
	}

	// 跳转到查看借书记录页面
	@RequestMapping("/listBorrow")
	public String listBorrow() {
		return "admin/listBorrow";
	}
	// 查看借书记录页面
	@ResponseBody
	@RequestMapping("/listBorrowAction")
	public Map listBorrowAction(BorrowQueryVo borrowQueryVo) {
		return readerAdminService.findBorrowReaderBook(borrowQueryVo);
	}

	// 跳转到查看借书记录页面
	@RequestMapping("/listReturn")
	public String listReturn() {
		return "admin/listReturn";
	}
	// 查看借书记录页面
	@ResponseBody
	@RequestMapping("/listReturnAction")
	public Map listReturnAction(ReturnQueryVo returnQueryVo) {
		return readerAdminService.findReturnInfo(returnQueryVo);
	}
	
	@ResponseBody
	@RequestMapping("/listReturnByReaderId")
	public Map listReturnByReaderId(@RequestParam(value="id",required=true) String reader_id) {
		return readerAdminService.listReturnByReaderId(reader_id);
	}

	// 删除图书
	@ResponseBody
	@RequestMapping(value = "/deleteBook", produces = "application/json;charset=UTF-8")
	public String deleteBook(@RequestParam(value = "id", required = true) String book_id) {
		int result = bookInfoService.deleteByBookId(book_id);
		if (result != 1)
			return "{\"success\"" + ":false," + "\"msg\":" + "\"" + "删除失败" + "\"" + "}";
		else {
			return "{\"success\"" + ":true," + "\"msg\":" + "\"" + "删除成功" + "\"" + "}";
		}
	}
	
	//在借阅表中获取图书详情
	@RequestMapping("/selectByBookId")
	public ModelAndView selectByBookId(@RequestParam(value="bookId",required=true) String book_id){
		BookInfo bookInfo=bookInfoService.selectByBookId(book_id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("bookInfo",bookInfo);
		mv.setViewName("admin/bookDetail");
		return mv;
	}
	@RequestMapping("/showInAndOut")
	public String showChart()
	{
		return "admin/showInAndOut";
	}
	@ResponseBody
	@RequestMapping(value="/findInAndOut", produces = "application/json;charset=UTF-8")
	public String findInAndOut()
	{
		int day0Out=readerAdminService.findOutNum(0);
		int day1Out=readerAdminService.findOutNum(1);
		int day2Out=readerAdminService.findOutNum(2);
		int day3Out=readerAdminService.findOutNum(3);
		int day0In=readerAdminService.findInNum(0);
		int day1In=readerAdminService.findInNum(1);
		int day2In=readerAdminService.findInNum(2);
		int day3In=readerAdminService.findInNum(3);
		String result="{\"success\"" + ":true," + "\"day0\":" + "\"" + "今天" + "\"" + ",";
		result+="\"day1\":" + "\"" + "昨天" + "\"" + ",";
		result+="\"day2\":" + "\"" + "前天" + "\"" + ",";
		result+="\"day3\":" + "\"" + "3天前" + "\"" + ",";
		result+="\"day0In\":" + day0In + ",";
		result+="\"day1In\":" + day1In + ",";
		result+="\"day2In\":" + day2In + ",";
		result+="\"day3In\":" + day3In + ",";
		result+="\"day0Out\":" +day0Out + ",";
		result+="\"day1Out\":" + day1Out + ",";
		result+="\"day2Out\":" + day2Out + ",";
		result+="\"day3Out\":" + day3Out + "}";
		System.out.println(new Date());
		System.out.println(result);
		return result;
	}
	//修改读者信息
	@ResponseBody
	//@RequestMapping(value="/updateReader", produces = "application/json;charset=UTF-8")
	@RequestMapping(value="/updateReader")
	public String updateReader(ReaderReader readerReader) {
		System.out.println(readerReader.getReaderName());
		if((readerAdminService.updateReader(readerReader))==1)
			 //return "{\"success\"" + ":true," + "\"msg\":" + "\"" + "操作成功" + "\"" + "}";
			return "111";
		//return "{\"success\"" + ":false," + "\"msg\":" + "\"" + "操作失败" + "\"" + "}";
		return "0";
				
	}
}
