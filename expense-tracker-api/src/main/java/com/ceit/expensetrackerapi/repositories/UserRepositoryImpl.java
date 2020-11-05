package com.ceit.expensetrackerapi.repositories;

import com.ceit.expensetrackerapi.domains.User;
import com.ceit.expensetrackerapi.exceptions.EAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String SQL_FIND_BY_ID = "SELECT user_id, first_name," +
            "last_name,email,password FROM et_users WHERE user_id = ?";

    private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM " +
            "ET_USERS WHERE EMAIL= ?";

    private static final String  SQL_FIND_BY_EMAIL = "SELECT USER_ID, FIRST_NAME,LAST_NAME," +
            "LAST_NAME,EMAIL, PASSWORD FROM ET_USERS WHERE EMAIL = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

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
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL,
                new Object[]{email},Integer.class);
    }

    @Override
    public User findById(Integer userId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID,new Object[]{userId},
                userRowMapper);

    }

    private RowMapper<User> userRowMapper = ((rs,rowNum)->{
        return new User (
                rs.getInt("USER_ID"),
                rs.getString("FIRST_NAME"),
                rs.getString("LASTNAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD")
                );
    });

}
