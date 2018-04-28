package com.example.demo.repository;

import com.example.demo.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DemoRepository extends JpaRepository<Demo,Integer> {

    //通过age查询
    public List<Demo> findByAge(Integer age);

    //自定义sql 持久化query 修改注解
   // @Modifying
    @Query(value = "select * from demo d where d.age < ?1" , nativeQuery = true)
    public List<Demo> getDemoByAge(Integer age);


}
