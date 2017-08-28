package com.bms.reader.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.bms.reader.common.ContextHolder;
import com.bms.reader.common.JsonResult;
import com.bms.reader.constant.DescribableEnum;
import com.bms.reader.service.ReaderReaderService;
import com.bms.reader.service.ReaderUserService;
import com.bms.reader.util.ImgEditor;


@Controller
@RequestMapping("/file") 
public class FileEditorController extends MultiActionController {
        
    @Autowired   
    private ReaderReaderService readerReaderService;
	    
    ImgEditor imgEditor = new ImgEditor(); 	  	  
	  /**
	     * 图片文件上传
	     */
	    @ResponseBody
	    @RequestMapping(value = "/photoUpload",method = RequestMethod.POST)
	    public ModelAndView photoUpload(MultipartFile image,int x1,int y1,int w,int h,double ratio,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IllegalStateException, IOException{    	
	    	ModelAndView mav = new ModelAndView("content/member-info");
	    	MultipartFile file=image;
	        if (file!=null) {// 判断上传的文件是否为空
	            String path=null;// 文件路径
	            String type=null;// 文件类型
	            String fileName=file.getOriginalFilename();// 文件原名称
	            System.out.println("上传的文件原名称:"+fileName);
	            // 判断文件类型
	            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
	            if (type!=null) {// 判断文件类型是否为空
	                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
	                    // 项目在容器中实际发布运行的根路径
	                    //String realPath=request.getSession().getServletContext().getRealPath("/");
	                	//指定存放的url路径
	                	//String realPath="D:/workspace/image/img";
	                	String realPath="D:/workspace/BMS/src/main/webapp/static/images/avatar/";
	                    // 自定义的文件名称
	                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
	                    // 设置存放图片文件的路径
	                    path=realPath+/*System.getProperty("file.separator")+*/trueFileName;
	                    System.out.println("存放图片文件的路径:"+path);
	                    // 转存文件到指定的路径
	                    file.transferTo(new File(path));
	                    System.out.println("文件成功上传到指定目录下");
	                    //进行缩放
	                    boolean flag=imgEditor.zoomOut(path,path,ratio);
                      
	                    //进行剪裁  
	                    if(flag){
	                       imgEditor.cut(path,path,x1,y1,w,h); 
	                    }	                    
	                    readerReaderService.updataavatar(trueFileName,ContextHolder.getSessionReader().getId());
	                    ContextHolder.getSessionReader().setAvatar(trueFileName);
	                }else {
	                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
	                    return null;
	                }
	            }else {
	                System.out.println("文件类型为空");
	                return null;
	            }
	        }else {
	            System.out.println("没有找到相对应的文件");
	            return null;
	        }
	        mav.addObject("user", ContextHolder.getSessionUser());
	        mav.addObject("reader", ContextHolder.getSessionReader());      
	        return mav;
	        
	    }
}
	  
	  

