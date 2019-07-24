package com.bdqn.mapper;

import com.bdqn.pojo.Emp;

import java.util.List;

/**
 * @Author ldwjava
 * @Date 2019/5/7 14:42
 * @Desc TODO
 **/

public interface EmpMapper {
    List<Emp> findEmps() throws Exception;
}
