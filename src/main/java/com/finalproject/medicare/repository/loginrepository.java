package com.finalproject.medicare.repository;

import com.finalproject.medicare.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface loginrepository extends JpaRepository<Users, Integer> {

   //@Query("select l.isadmin from users l where l.email_id =?1 and l.password=?2")
    Users findByUsernameAndPassword(String username, String password);

    @Override
    Users save(Users users);

//    @Modifying
//    @Transactional
//    @Query("update LoginUser log set log.password=:password where log.id=:id")
//    void changePassword(@Param(value = "password") String password, @Param(value = "id") Long id);
}
