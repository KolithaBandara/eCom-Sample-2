package edu.godzilla.eCom_Sample_2.service;

import edu.godzilla.eCom_Sample_2.model.Category;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    String createCategory(@RequestBody Category category);
}
