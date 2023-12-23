package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.CategoryRequest;
import com.demirr.eticaret.dto.response.CategoryResponse;
import com.demirr.eticaret.entities.Category;
import com.demirr.eticaret.exception.categoryexception.CategoryNotFoundException;
import com.demirr.eticaret.repository.CategoryRepository;
import com.demirr.eticaret.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<CategoryResponse> getAllCategory() {
        List<Category> categories=categoryRepository.findAll();
        return categories.stream().
                map(CategoryResponse::new).collect(Collectors.toList());


    }

    public Category createCategory(CategoryRequest request) {
        Category category=new Category();
        category.setName(request.getName());

        return categoryRepository.save(category);
    }

    public Category getOneCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId).orElseThrow(()->
                new CategoryNotFoundException("Kategori bulunamadı kategori_id="+categoryId));
    }
}
