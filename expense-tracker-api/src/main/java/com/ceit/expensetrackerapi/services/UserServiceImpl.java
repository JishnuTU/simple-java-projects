package com.ceit.expensetrackerapi.services;

import com.ceit.expensetrackerapi.domains.User;
import com.ceit.expensetrackerapi.exceptions.EAuthException;
import com.ceit.expensetrackerapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements  UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EAuthException {
        return null;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email!= null)
            email = email.toLowerCase();
        // Checking the email is in correct pattern
        if(!pattern.matcher(email).matches())
            throw new EAuthException("Invalid Email Format");
        // Checking email already exists
        Integer count = userRepository.getCountByEmail(email);

        if(count>0)
            throw new EAuthException("Email Already in Use");

        // We can register the user using the create api

        Integer userId = userRepository.create(firstName,lastName,email,password);
        // Return the User object from the database;
        return userRepository.findById(userId);
    }
}
