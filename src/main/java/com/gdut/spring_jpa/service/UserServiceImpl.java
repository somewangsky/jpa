package com.gdut.spring_jpa.service;

import com.gdut.spring_jpa.repository.UserRepository;
import com.gdut.spring_jpa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;


    public List<User> findByPhoneAndAddress(String phone, String address) {
        List<User> users = userRepository.findByPhoneStartingWithAndAddressContaining(phone, address);
        return users;
    }


    public List<User> findByPhoneAndAddressIdDesc(String phone, String address) {
        List<User> users = userRepository.findTop2ByPhoneStartingWithAndAddressContainingOrderByIdDesc(phone, address);
        return users;
    }

    public List<User> findByPhoneAndAddressSort(String phone, String address) {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        List<User> users = userRepository.findTop2ByPhoneStartingWithAndAddressContaining(phone, address,sort);
        return users;
    }

    public List<User> findByPhoneAndAddressPageable(String phone,String address,int page,int pageSize){
        Page<User> pageUser = userRepository.findByPhoneStartingWithAndAddressContaining(phone, address, PageRequest.of(page, pageSize,new Sort(Sort.Direction.DESC,"id")));

        long totalElements = pageUser.getTotalElements();
        int totalPages = pageUser.getTotalPages();
        int size = pageUser.getSize();
        int numberOfElements = pageUser.getNumberOfElements();
        List<User> users = pageUser.getContent();

        System.out.println();
        return users;
    }


    public User findByUserId(Integer id){
        User user = userRepository.findUserById(id);
        return user;
    }


    public List<User> findByUsersByPhone(String phone,String address){
        List<User> users = userRepository.findUsersByPhoneAndAddress(phone, address);
        return users;
    }


    @Transactional
    public void updateUser(String name,Integer id){
        userRepository.updateUserById(name,id);
    }

    @Transactional
    public void deleteUserById(Integer id){
        userRepository.deleteUserById(id);
    }
}
