package com.example.demo.controller;

import com.example.demo.domain.Demo;
import com.example.demo.repository.DemoRepository;
import com.example.demo.service.Demoservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DemoController {

    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);


    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private Demoservice demoservice;

    /**
     * 查询所有列表
     * @return
     */
    @GetMapping(value = "/demo")
    public List<Demo> getDemo(){
        logger.info("getDemo");
        return demoRepository.findAll();
    }

    /**
     * 添加一个demo
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/demo2")
    public Demo demoAdd(@Valid Demo demo, BindingResult bindingResult
                        // @RequestParam("cupSize") String cupSize,
                        //  @RequestParam("age") Integer age
    ){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return  null;
        }
        //Demo demo = new Demo();
       // demo.setCupSize(cupSize);
        //demo.setAge(age);
        demo.setAge(demo.getAge());
        demo.setCupSize(demo.getCupSize());

        return demoRepository.save(demo);
    }

    //查询一个demo
    @GetMapping(value = "/demo/{id}")
    public Demo getDemo(@PathVariable("id")Integer id){
        return  demoRepository.findOne(id);
    }

    //更新
    @PutMapping(value = "/putdemo/{id}")
    public  Demo  updateDemo(@PathVariable("id") Integer id,
                             @RequestParam("cupSize") String cupSize,
                             @RequestParam("age") Integer age){
        Demo demo = new Demo();
        demo.setId(id);
        demo.setCupSize(cupSize);
        demo.setAge(age);

        return demoRepository.save(demo);
    }

    //删除
    @DeleteMapping(value = "/delete/{id}")
    public void deleteDemo(@PathVariable("id") Integer id){
        demoRepository.delete(id);
    }

    //通过age查询
    @GetMapping(value = "/demo/age/{age}")
    public List<Demo> getDemoByAge(@PathVariable("age") Integer age){
        return  demoRepository.findByAge(age);
    }

    //通过sql查询age
    @GetMapping(value = "/demo/a/{age}")
    public List<Demo> getCupSize( @PathVariable("age") Integer age){
        return  demoRepository.getDemoByAge(age);
    }

    //插入demo
    @PostMapping(value = "/demo3")
    public void demoAddTwo(){
       demoservice.insetTwo();
    }
}


