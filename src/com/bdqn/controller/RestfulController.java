package com.bdqn.controller;

import com.bdqn.pojo.Items;
import com.bdqn.pojo.JsonResult;
import com.bdqn.service.ItemsService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author ldwjava
 * @Date 2019/5/14 16:11
 * @Desc TODO
 **/

@RestController  //@controller  @responsebody 合体，当前controller所有方法都是返回json
public class RestfulController {


    @Autowired
    private ItemsService itemsService;

    //get  http://items/1/zs
    @GetMapping("/items/{id}")//@pathVariable
    public Items items(@PathVariable("id") Integer id) throws Exception {
        System.out.println("handler");
        Items item = itemsService.getItemById(id);
        return item;
    }


    @GetMapping("/items")//@pathVariable
    public JsonResult allitems() throws Exception {
        List<Items> allItems = itemsService.getAllItems(null);
        JsonResult jsonResult = new JsonResult("10000", "查询成功", allItems);
        return jsonResult;
    }


    @DeleteMapping("/items/{id}")//@pathVariable
    public JsonResult delete(@PathVariable("id") Integer id) throws Exception {
        boolean b = itemsService.updateItems(new Items());
        JsonResult jsonResult = new JsonResult("10000", "查询成功", null);
        return jsonResult;
    }


    @PostMapping("/items")//@pathVariable
    public JsonResult add(Items items) throws Exception {
        items.setCreatetime(new Date());
        boolean b = itemsService.add(items);
        JsonResult jsonResult = new JsonResult("10000", "新增成功成功", null);
        return jsonResult;
    }

}
