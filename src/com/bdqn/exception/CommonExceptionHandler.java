package com.bdqn.exception;

import com.bdqn.pojo.JsonResult;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ldwjava
 * @Date 2019/5/14 14:12
 * @Desc TODO
 **/

@Component
public class CommonExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        //返回json的情况
       /* Map map = new HashMap<>();
        map.put("flag", false);
        JsonResult jsonResult = null;
        if (e instanceof CustomException) {
            jsonResult = new JsonResult("1001", e.getMessage(), map);
        } else {
            jsonResult = new JsonResult("1001", "未知错误", map);
        }
        try {
            //序列化jsonResutl对象   String xxxx=JSonObj.jsonObje(jsonResut)
            response.getWriter().write("xxxx");
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/

        //返回页面的情况
        JsonResult jsonResult = null;
        if (e instanceof CustomException) {//判断是否是自己的异常
            jsonResult = new JsonResult("1001", e.getMessage(), null);
        } else {
            //代码bug，抛出系统性的异常，这个异常需要我们解决
            jsonResult = new JsonResult("1001", "未知错误", null);
        }
        try {
            request.setAttribute("jsonResult", jsonResult);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } catch (ServletException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
