package com.example.springprojects.Controller;

import com.example.springprojects.Entities.Model.Email;
import com.example.springprojects.Entities.Model.UserEmails;
import com.example.springprojects.Service.EmailService;
import com.example.springprojects.Utils.Constants;
import com.example.springprojects.Utils.Response;
import com.example.springprojects.Utils.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

//    @Autowired
    EmailService emailService;

    @RequestMapping(value = Constants.EMAIL, method = RequestMethod.POST)
    public ResponseEntity<String> sendEmail() {
        Response<Email> response = emailService.sendEmail();
        return ResponseManager.sendSuccessResponse(response);
    }

    @RequestMapping(value = Constants.EMAIL_RECIEVE, method = RequestMethod.GET)
    public ResponseEntity<String> getResponse(@PathVariable("userCode") String userCode) {
        Response<UserEmails> response = emailService.unsubscribe(userCode);
        return ResponseManager.sendSuccessResponse(response);
    }

}
