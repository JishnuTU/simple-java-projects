package com.ceit.expensetrackerapi.repositories;

import com.ceit.expensetrackerapi.domains.Transaction;
import com.ceit.expensetrackerapi.exceptions.EtBadRequestException;
import com.ceit.expensetrackerapi.exceptions.EtResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{

    @Override
    public List<Transaction> findAll(Integer userId, Integer categoryId) {
        return null;
    }

    @Override
    public Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException {
        return null;
    }

    @Override
    public void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EtBadRequestException {

    }

    @Override
    public void removeById(Integer userId, Integer categoryId, Integer trasnactionId) throws EtResourceNotFoundException {

    }
}
