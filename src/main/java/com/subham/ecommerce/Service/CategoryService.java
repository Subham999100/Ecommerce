package com.subham.ecommerce.Service;

import com.subham.ecommerce.Model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    String CreateCategories(Category category);
}
