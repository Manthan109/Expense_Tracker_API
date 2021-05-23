package com.manthan.expensetracker.resources;

import java.util.HashMap;
import java.util.Map;

import com.manthan.expensetracker.domain.User;
import com.manthan.expensetracker.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody Map<String, Object> userMap){
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.validatUser(email, password);
        Map<String,String> map = new HashMap<>();
        map.put("message","Login Successfull");
        return new ResponseEntity<>(map, HttpStatus.OK);        
    }
    
    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String, Object> userMap){
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.registeUser(firstName, lastName, email, password);
        Map<String,String> map = new HashMap<>();
        map.put("messgae","Registered Successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
