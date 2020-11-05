package com.ceit.expensetrackerapi.repositories;

import com.ceit.expensetrackerapi.domains.User;
import com.ceit.expensetrackerapi.exceptions.EAuthException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public Integer create(String firstName, String lastName, String email, String password) throws EAuthException {
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws EAuthException {
        return null;
    }

    @Override
    public Integer getCountByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer userId) {
        return null;
    }
}
