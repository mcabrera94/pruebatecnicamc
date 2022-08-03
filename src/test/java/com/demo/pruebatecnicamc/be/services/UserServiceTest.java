package com.demo.pruebatecnicamc.be.services;


import com.demo.pruebatecnicamc.be.repositories.mysql.entities.User;
import com.demo.pruebatecnicamc.be.repositories.mysql.respositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    String name;
    String username;
    String email;
    String phone;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    public void init(){
        this.name = "José Ernesto Figuera Fuentes";
        this.username = "jfiguera";
        this.email = "jifiguera65@test.com";
        this.phone = "1234567";
    }

    @Test
    public void createUserTest(){
        Map<String, Object> response = new HashMap<>();
        response = userService.createUser(name, username, email, phone);
        assertNotNull(response);
    }

    @Test
    public void createUserExistTest(){
        Map<String, Object> response = new HashMap<>();

        User user = new User();
        user.setName(name);
        user.setUserName(username);
        user.setEmail(email);
        user.setPhone(phone);

        Mockito.when(userRepository.findByEmail(email)).thenReturn(user);
        response = userService.createUser(name, username, email, phone);
        assertNotNull(response);
    }

    @Test
    public void getUsersTest(){
        Map<String, Object> response = new HashMap<>();
        List<User> usersList = new ArrayList<>();

        User user = new User();
        user.setName(name);
        user.setUserName(username);
        user.setEmail(email);
        user.setPhone(phone);
        usersList.add(user);

        Mockito.when(userRepository.findAll()).thenReturn(usersList);
        response = userService.getUsers();
        assertNotNull(response);
    }

    @Test
    public void getUsersNotExistTest(){
        Map<String, Object> response = new HashMap<>();

        Mockito.when(userRepository.findAll()).thenReturn(null);
        response = userService.getUsers();
        assertNotNull(response);
    }

    @Test
    public void getUserByEmailTest() {
        Map<String, Object> response = new HashMap<>();

        User user = new User();
        user.setName(name);
        user.setUserName(username);
        user.setEmail(email);
        user.setPhone(phone);

        Mockito.when(userRepository.findByEmail(email)).thenReturn(user);
        response = userService.getUserByEmail(email);
        assertNotNull(response);
    }

    @Test
    public void getUserByEmailNotExistTest() {
        Map<String, Object> response = new HashMap<>();

        Mockito.when(userRepository.findByEmail(email)).thenReturn(null);
        response = userService.getUserByEmail(email);
        assertNotNull(response);
    }

    @Test
    public void deleteUserByEmailTest(){
        Map<String, Object> response = new HashMap<>();

        Mockito.when(userRepository.deleteByEmail(email)).thenReturn(1);
        response = userService.deleteUserByEmail(email);
        assertNotNull(response);

    }

    @Test
    public void deleteUserByEmailNotExistTest(){
        Map<String, Object> response = new HashMap<>();

        Mockito.when(userRepository.deleteByEmail(email)).thenReturn(0);
        response = userService.deleteUserByEmail(email);
        assertNotNull(response);
    }



}
