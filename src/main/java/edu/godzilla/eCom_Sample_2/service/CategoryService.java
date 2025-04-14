package edu.godzilla.eCom_Sample_2.service;

import edu.godzilla.eCom_Sample_2.model.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    String createCategory(@RequestBody Category category);
    String deleteCategory(Long categoryId);
    String updateCategory(@PathVariable Long categoryId,
                          @RequestBody Category category);
}
