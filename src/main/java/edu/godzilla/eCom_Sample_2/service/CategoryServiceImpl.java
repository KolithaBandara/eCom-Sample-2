package edu.godzilla.eCom_Sample_2.service;

import edu.godzilla.eCom_Sample_2.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private List<Category> allCategories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return allCategories;
    }

    @Override
    public String createCategory(Category category) {
        allCategories.add(category);
        return "Category Created Successfully!";
    }
}
