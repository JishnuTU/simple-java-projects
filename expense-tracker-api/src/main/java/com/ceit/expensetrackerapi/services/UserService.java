package com.ceit.expensetrackerapi.services;

import com.ceit.expensetrackerapi.domains.User;
import com.ceit.expensetrackerapi.exceptions.EAuthException;

public interface UserService {

    User validateUser(String email,String password) throws EAuthException;

    User registerUser(String firstName, String lastName, String email,String password) throws EAuthException;
}
