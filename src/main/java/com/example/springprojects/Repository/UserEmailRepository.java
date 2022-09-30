package com.example.springprojects.Repository;

import com.example.springprojects.Entities.Model.UserEmails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEmailRepository extends CrudRepository<UserEmails, Long> {

    @Query(value = "select * from user_emails", nativeQuery = true)
    List<UserEmails> findAllBy();

    @Query(value = "select * from user_emails where secret_code=:userCode", nativeQuery = true)
    UserEmails findAllByUserCode(String userCode);

    @Query(value = "select * from user_emails where id=:id", nativeQuery = true)
    UserEmails findAllById(Long id);
}
