package com.bms.reader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.bms.reader.common.JsonResult;
import com.bms.reader.constant.DescribableEnum;
import com.bms.reader.constant.ParamConstants;
import com.bms.reader.model.ReaderUser;
import com.bms.reader.service.LoginService;
import com.bms.reader.service.ReaderReaderService;
import com.bms.reader.service.ReaderUserService;
import com.bms.reader.common.ContextHolder;

@Controller
@RequestMapping("/login")
public class LoginController extends MultiActionController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ReaderUserService readerUserService;

    
    /**
     * 跳转到个人中心
     *
     * @return
     */
    @RequestMapping(value = "/gotoMember", method = RequestMethod.GET)
    public ModelAndView gotoMember() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", ContextHolder.getSessionUser());
        mv.addObject("reader",ContextHolder.getSessionReader());
       // System.out.println(ContextHolder.getSessionReader().getAvatar());
        mv.addObject("admin",ContextHolder.getSessionAdmin());
        mv.setViewName("content/member-info");
        return mv;
    }
    
    
    /**
     * 跳转到主页面
     *
     * @return
     */
    @RequestMapping(value = "/gotoMain", method = RequestMethod.GET)
    public ModelAndView gotoMain() {
        ModelAndView mv = new ModelAndView();
		try {
			ReaderUser u = ContextHolder.getSessionUser();
			if (u == null)
			{
				mv.addObject("username","");
				mv.setViewName("main/index");
			}
			else if (u.getUserType().equals(ParamConstants.USER_TYPE_0)) {
				mv.addObject("username",ContextHolder.getSessionReader().getReaderName());
				 mv.setViewName("main/index");
			} else if (u.getUserType().equals(ParamConstants.USER_TYPE_1)) {
				mv.addObject("username",ContextHolder.getSessionAdmin().getAdminName());
				mv.setViewName("admin/admindex");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("username","error");
			mv.setViewName("main/index");
		}
		return mv;
      //  mv.addObject("username", loginService.getLoginName());
        /*try {
        if (StringUtils.equals(ContextHolder.getSessionUser().getUserType(), ParamConstants.USER_TYPE_0))
        {
        mv.setViewName("main/index");
        }
        else{*/
       // mv.setViewName("admin/admindex");	
       /* }
        return mv;
        }
        catch (Exception e) {
		/	e.printStackTrace();*/
	//		return mv;
		/*}*/
    }

    /**
     * @param request
     * @param response
     * @param studyUser
     * @return
     * @Title: doLogin
     * @Description: 用户登录
     * @author: shenlx
     * @return: Object
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin(HttpServletRequest request, HttpServletResponse response, ReaderUser readerUser) {
        
        return new JsonResult(loginService.doLogin(readerUser));
    }

/*    *//**
     * @param request
     * @return
     * @Title: register
     * @Description: 打开注册页面
     * @author: shenlx
     * @return: ModelAndView
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/register");
        return mv;
    }
    
   /**
    * @param request
    * @return
    * @Title: login
    * @Description: 打开登录页面
    * @author: shenlx
    * @return: ModelAndView
    */
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView login(HttpServletRequest request) {
       ModelAndView mv = new ModelAndView();
          mv.setViewName("login/login");
          return mv;
   }
    /**
     * @param request
     * @param response
     * @param username
     * @return
     * @Title: remoteUsername
     * @Description: 校验用户名唯一性
     * @author: shenlx
     * @return: Object
     */
    @RequestMapping("/remoteUsername")
    @ResponseBody
    public Object remoteUsername(HttpServletRequest request, HttpServletResponse response, String username) {
        return readerUserService.remoteUsername(username);
    }

    /**
     * @param request
     * @param response
     * @param studyUser
     * @param readerName
     * @return
     * @Title: addRegister
     * @Description: 用户注册
     * @author: shenlx
     * @return: Object
     */
    
    @RequestMapping("/addRegister")
    @ResponseBody
    public Object addRegister(HttpServletRequest request, HttpServletResponse response,ReaderUser readerUser, String readerName){
        readerUserService.addRegister(readerUser, readerName);
        return new JsonResult(DescribableEnum.SUCCESS);
    }
    
    /**
     * @param request
     * @return
     * @Title: doLogout
     * @Description: 登出
     * @return: ModelAndView
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView doLogout(HttpServletRequest request) {
        try {
            loginService.doLogout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/");
    }

    /**
     * 获取菜单
     * @return
     * @author jerry.pan
     * @date 2017-04-12 10:04:33
     *//*
    @RequestMapping(value = "/menu")
    @ResponseBody
    public JsonResult menu() {
        List list = loginService.menu();
        return new JsonResult(DescribableEnum.SUCCESS, list);
    }*/

}
