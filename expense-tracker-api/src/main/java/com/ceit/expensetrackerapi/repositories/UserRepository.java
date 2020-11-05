package com.ceit.expensetrackerapi.repositories;

import com.ceit.expensetrackerapi.domains.User;
import com.ceit.expensetrackerapi.exceptions.EAuthException;

public interface UserRepository {

    Integer create (String firstName,String lastName, String email, String password)
            throws EAuthException;

    User findByEmailAndPassword(String email, String password) throws EAuthException;

    Integer getCountByEmail(String email);

    User findById (Integer userId);

}
