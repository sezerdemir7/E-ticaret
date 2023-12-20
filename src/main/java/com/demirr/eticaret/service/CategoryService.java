package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.request.CategoryRequest;
import com.demirr.eticaret.dto.response.CategoryResponse;
import com.demirr.eticaret.entities.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> getAllCategory();

    Category createCategory(CategoryRequest request);

    Category getOneCategoryById(Long id);

}
