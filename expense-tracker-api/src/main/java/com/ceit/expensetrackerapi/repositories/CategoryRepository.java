package com.ceit.expensetrackerapi.repositories;

import com.ceit.expensetrackerapi.domains.Category;
import com.ceit.expensetrackerapi.exceptions.EtBadRequestException;

import java.util.List;

public interface CategoryRepository {

    Integer create (Integer userId, String title,
                    String description)
            throws EtBadRequestException;

    void update(Integer userId, Integer categoryId,
                Category category) throws EtBadRequestException;

    void removeById(Integer userId, Integer categoryId);

    Category findById(Integer userId, Integer categoryId)
            throws EtResourceNotFoundException;

    List<Category> findAll(Integer userId)
        throws EtResourceNotFoundException;

}
