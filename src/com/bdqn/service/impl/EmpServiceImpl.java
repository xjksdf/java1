package com.bdqn.service.impl;

import com.bdqn.mapper.EmpMapper;
import com.bdqn.pojo.Emp;
import com.bdqn.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ldwjava
 * @Date 2019/5/7 14:41
 * @Desc TODO
 **/

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public List<Emp> findAll() throws Exception{
        return empMapper.findEmps();
    }
}
