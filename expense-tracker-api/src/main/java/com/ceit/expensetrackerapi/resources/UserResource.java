package com.ceit.expensetrackerapi.resources;

import com.ceit.expensetrackerapi.domains.User;
import com.ceit.expensetrackerapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String,String> userMap){
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.registerUser(firstName,lastName,email,password);
        Map<String,String> response = new HashMap<>();
        response.put("Status","1");
        response.put("Message","User Created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>>  loginUser(
            @RequestBody Map<String,Object> userMap){
        String email =  (String) userMap.get("email");
        String password = (String) userMap.get("password");

        Map<String,String> response = new HashMap<>();

        response.put("Status","success");
        response.put("Email",email);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
