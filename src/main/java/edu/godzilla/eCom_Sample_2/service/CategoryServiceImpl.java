package edu.godzilla.eCom_Sample_2.service;

import edu.godzilla.eCom_Sample_2.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
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


    @Override
    public ResponseStatusException deleteCategory(Long categoryId) {
        Category category = allCategories.stream()
                .filter(category1 -> category1.getId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category not found!"));
        allCategories.remove(category);
        return new ResponseStatusException(
                HttpStatus.OK,
                "Category '"+ category.getName() +"', deleted!");
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {
        Category updateCategory = allCategories.stream()
                .filter(category1 -> category1.getId().equals(categoryId))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category not found!"));
        updateCategory.setId(categoryId);
        updateCategory.setName(category.getName());
        return updateCategory;
    }
}
