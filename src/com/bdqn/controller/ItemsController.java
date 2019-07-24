package com.bdqn.controller;

import com.bdqn.exception.CustomException;
import com.bdqn.pojo.ItemCus;
import com.bdqn.pojo.Items;
import com.bdqn.pojo.QueryVo;
import com.bdqn.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @Author ldwjava
 * @Date 2019/5/8 16:11
 * @Desc TODO
 **/

@Controller
@RequestMapping("/item")  //窄化请求范围
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    /**
     * 查询商品列表
     *
     * @return
     */
    @RequestMapping("/findItems")   //  /items/findItems
    public ModelAndView findItems() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Items> items = itemsService.getAllItems(null);
        modelAndView.setViewName("index");
        modelAndView.addObject("itemList", items);
        return modelAndView;
    }

    //springmvc 允许直接在参数列表：request,response
    //method 指定该方法能够接受何种请求方式的请求
    //@RequestMapping(value = "/toEdit", method = RequestMethod.POST)
   /* @GetMapping("/toEdit") //简写方式  说明支持get请求方式的请求
    public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response) {
        String strid = request.getParameter("id");
        int id = Integer.parseInt(strid);
        Items items = new Items();
        items.setId(id);
        List<Items> allItems = itemsService.getAllItems(items);
        if (allItems.size() > 0) {
            items = allItems.get(0);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editItem");
        modelAndView.addObject("item", items);
        return modelAndView;
    }*/

    //重定向
    //方法返回字符串  --- 逻辑视图名
    @GetMapping("/toEdit") //简写方式  说明支持get请求方式的请求
    public String toEdit(@RequestParam(value = "id", required = false, defaultValue = "2") Integer uid, Model model) {
        // String strid = request.getParameter("id");
        //int id = Integer.parseInt(strid);
        try {
            Items items = itemsService.getItemById(uid);
            model.addAttribute("item", items);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return "editItem"; //逻辑视图名 视图解析器会自动拼接 前缀和后缀
        return "editItemModel"; //逻辑视图名 视图解析器会自动拼接 前缀和后缀
//        return "redirect:http://www.baidu.com"; //
        //return "redirect:/item/findItems";
        // return "redirect:/index.jsp";
        //return "forward:/item/findItems";
    }


    //方法返回
    @GetMapping("/getItemJson") //简写方式  说明支持get请求方式的请求
    public void getItemJson(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String strid = request.getParameter("id");
        int id = Integer.parseInt(strid);
        Items items = new Items();
        items.setId(id);
        List<Items> allItems = null;
        try {
            allItems = itemsService.getAllItems(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (allItems.size() > 0) {
            items = allItems.get(0);
        }
        PrintWriter writer = response.getWriter();
        writer.write("hello");
        writer.close();
    }
    //单个参数接收
    // public String edit(Integer id, String name, Float price,String detail)
    //public String edit(Items items, ItemCus itemCus)
   /* @RequestMapping("/edit")
    public String edit(QueryVo queryVo,Model model) {
        System.out.println("aaa");
        System.out.println(111);
        if (queryVo.getItem().getId() != 100) {
            //数据回显
            model.addAttribute("item", queryVo.getItem());
            return "editItem";
        }
        Items itemById = itemsService.getItemById(queryVo.getItem().getId());
        return "redirect:/item/findItems";
    }*/

    //@ModelAttribute("item") request作用域
    @RequestMapping("/edit")
    public String edit(@ModelAttribute("item") Items items, Model model) throws Exception {
        System.out.println(111);
        if (items.getId() != 100) {
            return "editItemModel";
        }
        boolean b = itemsService.updateItems(items);
        return "redirect:/item/findItems";
    }


    //把方法的返回值放入model
    @ModelAttribute("map")
    public Map getItemType() {
        System.out.println("modeattribute----");
        Map map = new HashMap();
        map.put("1", "体育");
        map.put("2", "教育");
        return map;
    }


    //批量删除
    //public String bachDelete(Integer[] id)
    @RequestMapping("/bachDelete")
    public String bachDelete(@RequestParam("id") ArrayList<Integer> id) {
        System.out.println(id);
        return "redirect:/item/findItems";
    }

    //批量修改
    @RequestMapping("/bachUpdate")
    public String bachUpdate(QueryVo queryVo) {
        System.out.println("");
        return "redirect:/item/findItems";
    }
}
