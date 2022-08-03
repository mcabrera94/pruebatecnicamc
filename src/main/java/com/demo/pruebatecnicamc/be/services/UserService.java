package com.demo.pruebatecnicamc.be.services;


import com.demo.pruebatecnicamc.be.controllers.constants.CommonConstant;
import com.demo.pruebatecnicamc.be.controllers.constants.UserConstant;
import com.demo.pruebatecnicamc.be.repositories.mysql.entities.User;
import com.demo.pruebatecnicamc.be.repositories.mysql.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserConstant, CommonConstant {

    @Autowired
    UserRepository userRepository;


    public Map<String, Object> createUser(String name,
                                          String username,
                                          String email,
                                          String phone) {
        Map<String, Object> response = new HashMap<>();
        User user;
        try {
            user = userRepository.findByEmail(email);
            if (user == null) {
                user = new User();
                user.setName(name);
                user.setUserName(username);
                user.setEmail(email);
                user.setPhone(phone);
                userRepository.save(user);

                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_TEXT, RESPONSE_CREATE_USER_SUCCESS);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_CREATE_USER_FAILED);
            }
        } catch (Exception e) {
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }
        return response;
    }

    public Map<String, Object> getUsers() {
        Map<String, Object> response = new HashMap<>();
        List<User> users;
        try {
            users = userRepository.findAll();
            if (users != null) {
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, users);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_USERS_FAILED);
            }
        } catch (Exception e) {
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }
        return response;
    }

    public Map<String, Object> getUserByEmail(String email) {
        Map<String, Object> response = new HashMap<>();
        User user;
        try {
            user = userRepository.findByEmail(email);
            if (user != null) {
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, user);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_USER_BY_EMAIL_FAILED);
            }
        } catch (Exception e) {
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }
        return response;
    }

    @Transactional
    public Map<String, Object> deleteUserByEmail(String email) {
        Map<String, Object> response = new HashMap<>();
        int result;
        try {
             result = userRepository.deleteByEmail(email);
            if (result != 0) {
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, RESPONSE_DELETE_USER_BY_EMAIL_SUCCESS);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_DELETE_USER_BY_EMAIL_FAILED);
            }
        } catch (Exception e) {
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }
        return response;
    }
}
