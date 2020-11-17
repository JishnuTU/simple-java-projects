package com.ceit.expensetrackerapi.services;

import com.ceit.expensetrackerapi.domains.Transaction;
import com.ceit.expensetrackerapi.exceptions.EtBadRequestException;
import com.ceit.expensetrackerapi.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface TransactionService {

    List<Transaction> fetchAllTransactions(Integer userId,Integer categoryId);

    Transaction fetchTransactionById(Integer userId, Integer categoryId,
                                     Integer transactionId) throws EtResourceNotFoundException;

    Transaction addTransaction(Integer userId, Integer categoryId, Double amount,
                               String note, Long TransactionDate)
            throws EtBadRequestException;
    void updateTransaction(Integer userId, Integer categoryId, Integer transactionId,
                           Transaction transaction)
        throws  EtBadRequestException;
    void removeTransaction(Integer userId, Integer categoryId, Integer transactionId)
        throws  EtResourceNotFoundException;
}
