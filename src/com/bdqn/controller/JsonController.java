package com.bdqn.controller;

import com.bdqn.pojo.AA;
import com.bdqn.pojo.Items;
import com.bdqn.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @Author ldwjava
 * @Date 2019/5/10 14:54
 * @Desc TODO
 **/

@Controller
public class JsonController {

    @Autowired
    private ItemsService itemsService;


    /*
    前端数据：1.标准url   xxx=xxx&aa=bb&&aa=cc          //aaaa(String xxx,String[] aa)  // vo{ private String xxx,String[] aa}

            2.json数据   {"name":"zs","age":20}

     */

    //方法返回
    @GetMapping("/getItemJson") //简写方式  说明支持get请求方式的请求
    public void getItemJson(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        try {
            Items item = itemsService.getItemById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //json转换的工具类  --- jackson
        //我们手动转换
        //JsonObject  ojb= JSON.xxxx(item)
        PrintWriter writer = response.getWriter();
        //writer.write(obj.tostring());
        writer.close();
    }


    //springmvc
    @RequestMapping("/getItem")
    @ResponseBody
    public Items getItem(Integer id) {
        Items item = null;
        try {
            item = itemsService.getItemById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }


    @RequestMapping("/getItemList")
    @ResponseBody
    public List<Items> getItem() {
        List<Items> allItems = null;
        try {
            allItems = itemsService.getAllItems(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allItems;
    }


    //前端传递的是json格式的数据，非标准的key-value形式

  /*  @RequestMapping("/getItemJson")
    @ResponseBody
    public List<Items> getItemJson(@RequestBody Items items) {
        List<Items> allItems = itemsService.getAllItems(null);
        return allItems;
    }*/

    @RequestMapping("/getItemJson3")
    @ResponseBody
    public List<Items> getItemJson2(@RequestBody Map map) {
        List<Items> allItems = null;
        try {
            allItems = itemsService.getAllItems(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allItems;
    }
}
