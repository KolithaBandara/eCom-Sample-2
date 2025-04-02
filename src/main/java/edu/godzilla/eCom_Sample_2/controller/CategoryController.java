package edu.godzilla.eCom_Sample_2.controller;

import edu.godzilla.eCom_Sample_2.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    List<Category> allCategories = new ArrayList<>();

    @GetMapping("/public/categories")
    public List<Category> getAllCategories(){
        return allCategories;
    }

}
