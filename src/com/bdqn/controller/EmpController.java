package com.bdqn.controller;

import com.bdqn.pojo.Emp;
import com.bdqn.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author ldwjava
 * @Date 2019/5/8 15:48
 * @Desc TODO
 **/

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;



    @RequestMapping("/findEmps")
    public ModelAndView findEmps() {
        List<Emp> all = null;
        try {
            all = empService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("emps", all);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
