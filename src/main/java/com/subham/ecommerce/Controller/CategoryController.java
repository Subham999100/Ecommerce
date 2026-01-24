package com.subham.ecommerce.Controller;

import com.subham.ecommerce.Model.Category;
import com.subham.ecommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @PostMapping("/api/public/categories")
    public String CreateCategories(@RequestBody Category category){
        return categoryService.CreateCategories(category);
    }


}
