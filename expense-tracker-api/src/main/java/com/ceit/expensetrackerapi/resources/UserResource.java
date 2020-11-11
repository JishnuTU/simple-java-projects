package com.ceit.expensetrackerapi.resources;

import com.ceit.expensetrackerapi.Constants;
import com.ceit.expensetrackerapi.domains.User;
import com.ceit.expensetrackerapi.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

        User user = userService.validateUser(email,password);

        response.put("Status","success");
        response.put("Email",email);
        response.put("token",generateJWTToken(user));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    private String generateJWTToken(User user){
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256,
                Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date (timestamp+Constants.TOKEN_VALIDITY))
                .claim("userId",user.getUserId())
                .claim("email",user.getEmail())
                .claim("firstName",user.getFirstName())
                .claim("lastName",user.getLastName())
                .compact();

        return token;
    }

}
