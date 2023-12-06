package com.demirr.eticaret.dto.response;

import com.demirr.eticaret.entities.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {

    private Long id;
    private String name;

    public CategoryResponse(Category category) {
        this.id= category.getId();
        this.name=category.getName();
    }
}
