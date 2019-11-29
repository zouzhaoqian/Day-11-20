package com.zou.repository;

import com.zou.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository <User,Integer>{
//泛型是实体类名字和主键的类型
}
