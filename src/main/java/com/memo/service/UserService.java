package com.memo.service;

import com.memo.entity.User;
import com.memo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

//    public User getUserById(String id){
//        return  ur.readById(id);
//    }

    public List<User> getAll(){
        return ur.readAll();
    }
}
