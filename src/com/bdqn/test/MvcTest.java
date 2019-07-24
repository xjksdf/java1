package com.bdqn.test;

import com.bdqn.pojo.Emp;
import com.bdqn.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author ldwjava
 * @Date 2019/5/7 15:06
 * @Desc TODO
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class MvcTest {

    @Autowired
    private EmpService empService;

    @Test
    public void testselect() {
        List<Emp> emps = null;
        try {
            emps = empService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(emps);
    }

}
