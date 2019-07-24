package com.bdqn.service;

import com.bdqn.pojo.Emp;

import java.util.List;

/**
 * @Author ldwjava
 * @Date 2019/5/7 14:41
 * @Desc TODO
 **/

public interface EmpService {
    List<Emp> findAll() throws Exception;
}
