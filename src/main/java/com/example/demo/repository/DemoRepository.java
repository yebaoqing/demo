package com.example.demo.repository;

import com.example.demo.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemoRepository extends JpaRepository<Demo,Integer> {

    //通过age查询
    public List<Demo> findByAge(Integer age);
}
