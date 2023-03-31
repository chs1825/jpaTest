package com.memo.service;

import com.memo.entity.User;
import com.memo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository ur;

//    public UserService(UserRepository ur) {
//        this.ur = ur;
//    }
    //
//    public User getUserById(String id){
//        return  ur.readById(id);
//    }

    public List<User> getAll(){
        return ur.readAll();
    }
}
