package com.zou.service.impl;

import com.zou.pojo.User;
import com.zou.repository.UserRepository;
import com.zou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository ur;
    @Override
    public List<User> findAll() {
        return ur.findAll();
    }

    @Override
    public void insert(User user) {
        ur.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        ur.deleteById(id);
    }

    @Override
    public void updateById(User user) {
        ur.saveAndFlush(user);
    }

    @Override
    public List<User> findByExample(User user) {
        ExampleMatcher matcher=ExampleMatcher.matchingAny().withMatcher("id",ExampleMatcher.GenericPropertyMatchers.exact())
                                                            .withMatcher("age",ExampleMatcher.GenericPropertyMatchers.exact());
        Example of=Example.of(user,matcher);
        Pageable page= PageRequest.of(0,2);
        Page<User> all=ur.findAll(of,page);
        List<User> content=all.getContent();

        long totalElements=all.getTotalElements();
        System.out.println("当前数据一共有======"+totalElements);
        return content;
    }
}
