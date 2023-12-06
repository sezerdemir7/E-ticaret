package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.CategoryRequest;
import com.demirr.eticaret.dto.response.CategoryResponse;
import com.demirr.eticaret.entities.Category;
import com.demirr.eticaret.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<CategoryResponse> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @PostMapping()
    public Category createCategory(@RequestBody CategoryRequest request){
        return categoryService.createCategory(request);
    }



}
