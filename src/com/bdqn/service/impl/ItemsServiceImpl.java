package com.bdqn.service.impl;

import com.bdqn.exception.CustomException;
import com.bdqn.mapper.ItemsMapper;
import com.bdqn.pojo.Items;
import com.bdqn.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ldwjava
 * @Date 2019/5/8 16:11
 * @Desc TODO
 **/

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> getAllItems(Items items) throws Exception {
        return itemsMapper.findAllItems(items);
    }

    @Override
    public Items getItemById(Integer id) throws Exception {
        return itemsMapper.findItemById(id);
    }

    @Override
    public boolean updateItems(Items items) throws Exception {
        boolean flag = itemsMapper.updateItems(items);
        if (flag) {
            throw new CustomException("修改失败");
        }
        return flag;
    }

    @Override
    public boolean add(Items items) {
        boolean flag = itemsMapper.insert(items);
        if (!flag) {
            throw new CustomException("添加失败");
        }
        return flag;
    }
}
