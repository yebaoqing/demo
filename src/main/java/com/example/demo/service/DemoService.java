package com.example.demo.service;

import com.example.demo.domain.Demo;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.DemoException;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    @Transactional
    public void insetTwo(){
        Demo demo1 = new Demo();
        demo1.setAge(111);
        demo1.setCupSize("aaa");
        demo1.setMoney(12.0);
        demoRepository.save(demo1);

        Demo demo2 = new Demo();
        demo2.setAge(222);
        demo2.setCupSize("bbb");
        demo2.setMoney(12.0);
        demoRepository.save(demo2);
    }

    public void getAge(Integer id) throws Exception{
        Demo demo = demoRepository.findOne(id);
        Integer age = demo.getAge();
        if (age < 10){
            //毛都没长齐
            throw new DemoException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age <16){
            //小嫩逼
            throw new DemoException(ResultEnum.MIDDLE_SCHOOL);
        }else {
            //加钱
            throw new DemoException(ResultEnum.HIGH_SCHOOL);
        }
    }

    /**
     *通过id查询信息
     * @param id
     * @return
     */
    public  Demo findOne(Integer id){
        return demoRepository.findOne(id);
    }
}
