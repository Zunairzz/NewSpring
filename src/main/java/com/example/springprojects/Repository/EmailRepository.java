package com.example.springprojects.Repository;

import com.example.springprojects.Entities.Model.UserEmails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<UserEmails, Long> {

    @Query(value = "select * from user_emails where secret_code=:userCode", nativeQuery = true)
    UserEmails findAllByUserCode(String userCode);
}
