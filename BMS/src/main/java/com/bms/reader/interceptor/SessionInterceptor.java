package com.bms.reader.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bms.reader.constant.ParamConstants;
import com.bms.reader.model.ReaderUser;


/*
        对Web服务应用进行拦截
 */

public class SessionInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(SessionInterceptor.class);

    /**
     * 完成页面的render后调用
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object object, Exception exception)
            throws Exception {

    }

    /**
     * 在调用controller具体方法后拦截
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object object,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在调用controller具体方法前拦截 这边添加验证是否登录的代码
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object object) throws Exception {
    	ReaderUser u = (ReaderUser) request.getSession().getAttribute(ParamConstants.LOCAL_CLINET_USER);
        if (u == null) {
            response.sendRedirect(request.getContextPath());
        } else {
            //SessionHolder.set(ConfigConstants.LOCAL_CLINET_USER, u);
        }
        String uri = request.getRequestURI();
        System.out.println("uri=============拦截器已拦截==================:     " + uri);
        return true;
    }
}
