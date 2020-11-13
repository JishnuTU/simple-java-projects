package com.ceit.expensetrackerapi.resources;


import com.ceit.expensetrackerapi.domains.Category;
import com.ceit.expensetrackerapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @Autowired
    CategoryService categoryService;


    @PostMapping("")
    public ResponseEntity<Category> addCategory(HttpServletRequest request,
                                                @RequestBody Map<String,Object> categoryMap
                                                ){

        int userId = (Integer) request.getAttribute("userId");

        String title = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");

        Category category = categoryService.addCategory(userId,
                title,description);

        return new ResponseEntity<>(category, HttpStatus.CREATED);

    }

    @GetMapping("/{category_id}")
    public ResponseEntity<Category> getCategoryById(
            HttpServletRequest request, @PathVariable("category_id")
            Integer category_Id){
        int userId = (Integer) request.getAttribute("userId");

        Category category = categoryService.fetchCategoryById(
                category_Id,userId);

        return new ResponseEntity<>(category,HttpStatus.OK);
    }
}
