package com.demirr.eticaret.dto.response;

import com.demirr.eticaret.entities.Category;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CategoryResponse {

    private Long id;
    private String name;

    public CategoryResponse(Category category) {
        this.id= category.getId();
        this.name=category.getName();
    }
}
