package com.ceit.expensetrackerapi.resources;


import com.ceit.expensetrackerapi.domains.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @PostMapping("")
    public ResponseEntity<Category> addCategory(HttpServletRequest request,
                                                @RequestBody Map<String,Object> categoryMap
                                                ){

        int userId = (Integer) request.getAttribute("userId");

        String title = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");

        Category category = new Category(1,userId,title,description,0.0);

        return new ResponseEntity<>(category, HttpStatus.CREATED);

    }
}
