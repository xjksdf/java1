package com.bdqn.service;

import com.bdqn.pojo.Items;

import java.util.List;

/**
 * @Author ldwjava
 * @Date 2019/5/8 16:10
 * @Desc TODO
 **/

public interface ItemsService {

    List<Items> getAllItems(Items items) throws Exception;

    Items getItemById(Integer id) throws Exception;

    boolean updateItems(Items items) throws Exception;

    boolean add(Items items);

}
