package com.spring.thymeleaf.thymeleafcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.thymeleaf.thymeleafcrud.entity.User;
import com.spring.thymeleaf.thymeleafcrud.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //READ DATA
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    //CREATE DATA
    public void addUser(User user)
    {
        userRepository.save(user);
    }

    //UPDATE DATA
    public User updateById(int id)
    {
        User user = userRepository.findById(id).get();
        userRepository.save(user);
        return user;
    }

    public void deleteUserById(int id)
    {
        userRepository.deleteById(id);
    }
    
}
