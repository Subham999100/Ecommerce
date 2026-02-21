package com.subham.ecommerce.Service;

import com.subham.ecommerce.Model.Category;
import com.subham.ecommerce.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryImplementor implements  CategoryService{
    //private List<Category> categories=new ArrayList<>();

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();

    }

    @Override
    public String CreateCategories( Category category) {
         categoryRepository.save(category);
         return "Category added Succuesfully";
    }

    @Override
    public String deletCategory(Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Category category=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
         categoryRepository.delete(category);
         return "categoryid is deleted Succesfully"+categoryId;
    }


    @Override
    public Category updateCategory(Category category, Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Optional<Category> optionalCategory =categories.stream().filter(c->c.getCategoryId().equals(categoryId))
                .findFirst();
        if(optionalCategory.isPresent()){
            Category existingCategory=optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            Category savedCategory=categoryRepository.save(category);
            return savedCategory;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Not Found");
        }
    }
}
