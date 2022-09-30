package com.example.springprojects.Repository;

import com.example.springprojects.Entities.Model.UserEmails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEmailRepository extends CrudRepository<UserEmails, Long> {

    @Query(value = "select * from user_emails", nativeQuery = true)
    List<UserEmails> findAll();
}
