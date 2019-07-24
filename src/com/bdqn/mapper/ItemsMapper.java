package com.bdqn.mapper;

import com.bdqn.pojo.Items;

import java.util.List;

/**
 * @Author ldwjava
 * @Date 2019/5/8 16:09
 * @Desc TODO
 **/

public interface ItemsMapper {

    List<Items> findAllItems(Items items) throws Exception;

    Items findItemById(Integer id) throws Exception;

    boolean updateItems(Items items) throws Exception;

    boolean insert(Items items);
}
