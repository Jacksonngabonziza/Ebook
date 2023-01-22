package com.Ebook.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// import com.Ebook.api.controller.UserController;
import com.Ebook.api.model.Logs;
import com.Ebook.api.model.User;
import com.Ebook.api.repository.LogsRepository;

import java.util.Date;

@Service
@Transactional
public class LogsService {
    @Autowired
    LogsRepository logsRepository;
    // @Autowired
    // UserController usercontroller;

    // public void savelogs(@Lazy User user, String activity) {
    //     // String tok = usercontroller.token;
    //     // System.out.println(" my tok value is :" + tok);
    //     Logs logs = new Logs();
    //     logs.setEmail(user.getEmail());
    //     logs.setActivity(activity);
    //     logs.settime(new Date());

    //     logsRepository.save(logs);
    // }

    // public void savelog(String email, String activity) {
    //     // String tok = usercontroller.token;
    //     // System.out.println(" my tok value is :" + tok);
    //     Logs logs = new Logs();
    //     logs.setEmail(email);
    //     logs.setActivity(activity);
    //     logs.settime(new Date());

    //     logsRepository.save(logs);
    // }

    // public void logout(User user) {
    // Logs logs = new Logs();
    // // User users=new User();
    // String token = "expired";
    // logs.setFirstName(user.getFirstName());
    // logs.setLastName(user.getLastName());
    // logs.setRole(user.getRole());
    // logs.setEmail(user.getEmail());
    // logs.setlogout(new Date().toString());
    // logs.settoken(token);
    // logs.settokenstatus(0);
    // logsRepository.save(logs);
    // }
}