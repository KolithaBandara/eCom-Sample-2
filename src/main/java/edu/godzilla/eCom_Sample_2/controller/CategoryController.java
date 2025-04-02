package edu.godzilla.eCom_Sample_2.controller;

import edu.godzilla.eCom_Sample_2.model.Category;
import edu.godzilla.eCom_Sample_2.service.CategoryService;
import edu.godzilla.eCom_Sample_2.service.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    CategoryService categoryService = new CategoryServiceImpl();

    @GetMapping("/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/admin/category")
    public String createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

}
