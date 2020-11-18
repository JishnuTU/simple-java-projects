package com.ceit.expensetrackerapi.resources;

import com.ceit.expensetrackerapi.domains.Transaction;
import com.ceit.expensetrackerapi.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/categories/{categoryId}/transactions")
public class TransactionResource {

    @Autowired
    TransactionService transactionService;

    @PostMapping("")
    public ResponseEntity<Transaction> addTransaction(
            HttpServletRequest request,
            @PathVariable("categoryId") Integer categoryId,
            @RequestBody Map<String,Object> transactionMap
            ){
        int userId = (Integer)request.getAttribute("userId");
        Double amount = Double.parseDouble(
                transactionMap.get("amount").toString()
        );
        String note = (String) transactionMap.get("note");
        Long transactionDate = (Long) transactionMap.get("transactionDate");
        Transaction transaction = transactionService.addTransaction(
                userId,categoryId,amount,note,transactionDate
        );

        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

}
