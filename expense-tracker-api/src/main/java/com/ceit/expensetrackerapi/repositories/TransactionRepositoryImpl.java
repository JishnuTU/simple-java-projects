package com.ceit.expensetrackerapi.repositories;

import com.ceit.expensetrackerapi.domains.Transaction;
import com.ceit.expensetrackerapi.exceptions.EtBadRequestException;
import com.ceit.expensetrackerapi.exceptions.EtResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
private static final String SQL_CREATE = "INSERT INTO " +
        "et_transactions(transaction_Id,category_Id,user_Id,amount" +
        ",note,transaction_date) " +
        "values(nextVal('et_transactions_seq'),?,?,?,?,?);";

private static final String SQL_FIND_BY_ID = "SELECT transaction_Id," +
        "category_Id,user_Id,amount,note,transaction_date FROM et_transactions" +
        " WHERE user_Id = ? AND category_Id = ? AND transaction_Id = ?;";
@Autowired
    JdbcTemplate jdbcTemplate;


@Override
    public List<Transaction> findAll(Integer userId, Integer categoryId) {
        return null;
    }

    @Override
    public Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException {
    try {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID,new Object[]{userId,
        categoryId,transactionId},transactionRowMapper);
    }
    catch (Exception e){
        throw new EtResourceNotFoundException("Transaction not found");
    }
}

    @Override
    public Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
              ps.setInt(1,categoryId);
              ps.setInt(2,userId);
              ps.setDouble(3,amount);
              ps.setString(4,note);
              ps.setLong(5,transactionDate);
              return ps;
            },keyHolder);
            return (Integer) keyHolder.getKeys().get("transaction_Id");
        }
        catch (Exception e){
            throw new EtBadRequestException("Invalid Request"+SQL_CREATE);
        }


    }

    @Override
    public void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EtBadRequestException {

    }

    @Override
    public void removeById(Integer userId, Integer categoryId, Integer trasnactionId) throws EtResourceNotFoundException {

    }
    private RowMapper<Transaction> transactionRowMapper = ((rs,rowNum)->{
       return new Transaction(
               rs.getInt("transaction_Id"),
               rs.getInt("category_Id"),
               rs.getInt("user_Id"),

               rs.getDouble("amount"),
               rs.getString("note"),
               rs.getLong("transaction_date")
       ) ;
    });
}
