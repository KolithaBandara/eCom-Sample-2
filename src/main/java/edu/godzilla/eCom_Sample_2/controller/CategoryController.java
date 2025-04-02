package edu.godzilla.eCom_Sample_2.controller;

import edu.godzilla.eCom_Sample_2.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private List<Category> allCategories = new ArrayList<>();

    @GetMapping("/public/categories")
    public List<Category> getAllCategories(){
        return allCategories;
    }

    @PostMapping("/admin/category")
    public String createCategory(@RequestBody Category category){
        allCategories.add(new Category(category.getId(), category.getName()));
        return "Category created successfully!";
    }

}
