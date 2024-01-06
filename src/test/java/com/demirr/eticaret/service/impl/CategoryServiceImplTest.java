package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.CategoryRequest;
import com.demirr.eticaret.dto.response.CategoryResponse;
import com.demirr.eticaret.entities.Category;
import com.demirr.eticaret.exception.categoryexception.CategoryNotFoundException;
import com.demirr.eticaret.repository.CategoryRepository;
import com.demirr.eticaret.service.CategoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceImplTest {

    private CategoryService categoryService;
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp(){
        categoryRepository= Mockito.mock(CategoryRepository.class);
        categoryService=new CategoryServiceImpl(categoryRepository);
    }

    @Test
    void whenShouldReturnAllCategory() {
        Category category1 = new Category();
        category1.setId(1L);
        category1.setName("Test-category-1");

        Category category2 = new Category();
        category2.setId(2L);
        category2.setName("Test-category-2");

        List<Category> categoryList=new ArrayList<>();
        categoryList.add(category1);
        categoryList.add(category2);

        CategoryResponse response1=new CategoryResponse(category1);
        CategoryResponse response2=new CategoryResponse(category2);

        List<CategoryResponse> list=new ArrayList<>();
        list.add(response1);
        list.add(response2);


        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
        List<CategoryResponse> result=categoryService.getAllCategory();

        Assertions.assertIterableEquals (result,list);
        Mockito.verify(categoryRepository).findAll();




    }

    @Test
    void whenGetOneCategoryById(){
        Category category=new Category();
        category.setId(1L);
        category.setName("Giyim");

        Mockito.when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));

        Category result=categoryService.getOneCategoryById(category.getId());

        Assertions.assertEquals(result,category);
        Mockito.verify(categoryRepository).findById(category.getId());
    }
    @Test
    void whenGetOneCategoryById_ThenCategoryNull(){

        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.empty());


        assertThrows(CategoryNotFoundException.class,()->categoryService.getOneCategoryById(1L));
        Mockito.verify(categoryRepository).findById(1L);
    }


    @AfterEach
    void tearDown() {

    }
}