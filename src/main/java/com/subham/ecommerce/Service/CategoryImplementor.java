package com.subham.ecommerce.Service;

import com.subham.ecommerce.Model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public String deletCategory(Long categoryId) {
        Category category=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
         categories.remove(category);
         return "categoryid is deleted Succesfully"+categoryId;
    }
}
