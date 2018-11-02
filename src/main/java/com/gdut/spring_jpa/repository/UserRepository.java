package com.gdut.spring_jpa.repository;

import com.gdut.spring_jpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface UserRepository extends JpaRepository<User, Integer> {

    //select * from user where phone like '136%' and address like '%路%'
    List<User> findByPhoneStartingWithAndAddressContaining(String phone, String address);

    //select * from user where phone like '136%' and address like '%路%' ORDER by id DESC LIMIT 0,2
    List<User> findTop2ByPhoneStartingWithAndAddressContainingOrderByIdDesc(String phone, String address);

    List<User> findTop2ByPhoneStartingWithAndAddressContaining(String phone, String address, Sort sort);

    Page<User> findByPhoneStartingWithAndAddressContaining(String phone, String address, Pageable pageable);


    @Query(value = "select * from user where id =:id", nativeQuery = true)
    User findUserById(@Param("id") Integer id);

    @Query(value = "select * from user where phone like :phone%",nativeQuery = true)
    List<User> findUsersByPhone(@Param("phone")String phone);


    @Query(value = "select * from user where phone like :phone% and address like %:address%",nativeQuery = true)
    List<User> findUsersByPhoneAndAddress(@Param("phone")String phone,
                                @Param("address")String address);

    @Modifying
    @Query(value = "update user set name=:name where id =:id",nativeQuery = true)
    void updateUserById(@Param(value = "name")String name, @Param(value = "id")Integer id);

    @Modifying
    @Query(value = "delete from user where id = :id",nativeQuery = true)
    void deleteUserById(@Param(value = "id")Integer id);
}
