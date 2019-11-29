package com.zou;

import com.zou.controller.JunitController;
import com.zou.pojo.User;
import com.zou.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJunitApplication.class)
public class JunitTest {
    @Autowired
    private JunitController junitController;
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        String all=junitController.selectAll();
        System.out.println(all);
    }
    @Test
    public void test2(){
        User user=new User();
        user.setName("小凡");
        user.setAge(25);
        user.setPass("654321");
        userService.insert(user);
    }
    @Test
    public void test3(){
        userService.deleteById(6);
    }
    @Test
    public void test4(){
        User user=new User();
        user.setId(7);
        user.setName("李四");
        user.setAge(32);
        user.setPass("65223");
        userService.updateById(user);
    }
    @Test
    public void findByExample(){
        User user=new User();
        List<User>byExample=userService.findByExample(user);
        System.out.println(byExample);
    }
}
