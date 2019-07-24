package com.bdqn.controller;

import com.bdqn.pojo.Items;
import com.bdqn.service.ItemsService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author ldwjava
 * @Date 2019/5/11 13:57
 * @Desc TODO
 **/

@Controller
public class UploadController {

    @Autowired
    private ItemsService itemsService;

    //springmvc  MulpartFile
    // 名称需要
    //上传需要加上@RequestParam("pictureFile")
    @RequestMapping("/upload")
    public String upload(@RequestParam("pictureFile") MultipartFile pictureFil, Items items) throws Exception {
        String filename = pictureFil.getOriginalFilename();//文件名
        /*
        1.图片不会和当前应用存储
        2.有专门图片服务器
        3. fasdDFS   阿里云 oss
         */
        //1.指定图片服务器的地址
        if (filename != null && !"".equals(filename)) {
            String target = "d:/img/";
            String ext = filename.substring(filename.lastIndexOf("."));
            String newFileName = UUID.randomUUID() + ext;
            String pic = "/img/" + newFileName;
            System.out.println(target + newFileName + ext);
            File file = new File(target + newFileName);
            //2.把图片上传到指定目录位置
            pictureFil.transferTo(file);
            //把数据修改进数据库
            items.setPic(pic);
        }
        //更更改数据
        boolean flag = itemsService.updateItems(items);
        return "redirect:/item/findItems";
    }


    //异步上传图片
    @RequestMapping("/uploadAjax")
    @ResponseBody
    public Map uploadAjax(@RequestParam("pictureFile") MultipartFile pictureFil, Integer id) throws IOException {
        String filename = pictureFil.getOriginalFilename();//文件名
        /*
        1.图片不会和当前应用存储
        2.有专门图片服务器
        3. fasdDFS   阿里云 oss
         */
        //1.指定图片服务器的地址
        String target = "d:/img/";
        String ext = filename.substring(filename.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + ext;
        String pic = "/img/" + newFileName;
        System.out.println(target + newFileName + ext);
        File file = new File(target + newFileName);
        //2.把图片上传到指定目录位置
        pictureFil.transferTo(file);

        //把数据修改进数据库
        Items items = new Items();
        items.setId(id);
        items.setPic(pic);
        //更更改数据
        boolean flag = false;
        try {
            flag = itemsService.updateItems(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map map = new HashMap();
        if (flag) {
            map.put("code", 0);
            map.put("pic", pic);
        } else {
            map.put("code", 1);
            map.put("msg", "上传失败！");
        }
        return map;
    }


    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String filename) throws IOException {
        String source = "d:/img/";

        File file = new File(source + filename);
        //设置响应头
        HttpHeaders httpHeaders = new HttpHeaders();
        //设置响应个是为 流的形式
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");
        //弹出下载框
        httpHeaders.setContentDispositionFormData("attachment", filename);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
    }

}
