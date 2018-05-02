package com.example.demo;

import com.example.demo.domain.Demo;
import com.example.demo.service.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServicrTest {

    @Autowired
    private DemoService demoService;

    @Test
    public  void findOneTest(){
        Demo demo = demoService.findOne(1);
        Assert.assertEquals(new Integer(15),demo.getAge());
    }
}
