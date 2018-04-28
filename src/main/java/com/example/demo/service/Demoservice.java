package com.example.demo.service;

import com.example.demo.domain.Demo;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Demoservice {
    @Autowired
    private DemoRepository demoRepository;

    @Transactional
    public void insetTwo(){
        Demo demo1 = new Demo();
        demo1.setAge(111);
        demo1.setCupSize("aaa");
        demoRepository.save(demo1);

        Demo demo2 = new Demo();
        demo2.setAge(222);
        demo2.setCupSize("bbb");
        demoRepository.save(demo2);

    }
}
