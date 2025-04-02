package edu.godzilla.eCom_Sample_2.controller;

import edu.godzilla.eCom_Sample_2.model.Category;
import edu.godzilla.eCom_Sample_2.service.CategoryService;
import edu.godzilla.eCom_Sample_2.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    Long id = 0L;

    @GetMapping("/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/admin/category")
    public String createCategory(@RequestBody Category category){
        ++id;
        category.setId(id);
        return categoryService.createCategory(category);
    }

}
