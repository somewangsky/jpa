package com.gdut.spring_jpa.service;


import com.gdut.spring_jpa.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void findByPhoneAndAddress() {
        List<User> users = userService.findByPhoneAndAddress("136", "路");

        System.out.println(users);
    }

    @Test
    public void findByPhoneAndAddressIdDesc() {

        List<User> users = userService.findByPhoneAndAddressIdDesc("136", "路");

        System.out.println(users);
    }

    @Test
    public void findByPhoneAndAddressSort() {

        List<User> users = userService.findByPhoneAndAddressSort("136", "路");

        System.out.println(users);
    }

    @Test
    public void findByPhoneAndAddressPageable() {
        List<User> users = userService.findByPhoneAndAddressPageable("136", "路", 0, 2);
    }

    @Test
    public void findByUserId() {
        User user = userService.findByUserId(1);
        System.out.println(user);
    }

    @Test
    public void findByUsersByPhone() {
        List<User> users = userService.findByUsersByPhone("136", "路");

        System.out.println(users);
    }

    @Test
    public void updateUser() {
        userService.updateUser("张三丰",1);
    }


    @Test
    public void deleteUserById() {
        userService.deleteUserById(5);
    }


/*
    @Test
    public void addUser() {
        User user1 = new User();
        user1.setName("张三");
        user1.setAddress("北京");
        user1.setPhone("13623246407");

        User user2 = new User();
        user2.setName("李四");
        user2.setAddress("上海");
        user2.setPhone("13223206407");

        User user3 = new User();
        user3.setName("王五");
        user3.setAddress("广州");
        user3.setPhone("13893206407");


        User user4 = new User();
        user4.setName("赵六");
        user4.setAddress("深圳");
        user4.setPhone("18710206407");

        User user5 = new User();
        user5.setName("万八");
        user5.setAddress("珠海");
        user5.setPhone("15683206407");

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        userService.addUser(user5);
    }
*/

}