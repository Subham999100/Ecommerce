package com.subham.ecommerce.Service;

import com.subham.ecommerce.Model.Category;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryImplementor implements  CategoryService{
    private List<Category> categories=new ArrayList<>();
    private Long id=1L;
    @Override
    public List<Category> getAllCategories() {
        return categories;

    }

    @Override
    public String CreateCategories( Category category) {
         category.setCategoryId(id++);
         categories.add(category);
         return "Category added Succuesfully";
    }
}
