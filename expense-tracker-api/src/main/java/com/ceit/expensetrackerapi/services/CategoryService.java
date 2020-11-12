package com.ceit.expensetrackerapi.services;

import com.ceit.expensetrackerapi.domains.Category;
import com.ceit.expensetrackerapi.exceptions.EtBadRequestException;
import com.ceit.expensetrackerapi.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryService {

    List<Category>  fetchAllCategories(Integer userId)
            throws EtResourceNotFoundException;

    Category fetchCategoryById(Integer categoryId,Integer userId)
        throws EtResourceNotFoundException;

    Category addCategory(Integer userId,String title,
                         String description)
        throws EtBadRequestException;

    void updateCategory(Integer userId, Integer categoryId,
                        Category category)
            throws EtBadRequestException;
    void removeCategorywithAllTransactions(Integer userId,
                                           Integer categoryId)
        throws EtResourceNotFoundException;


}
