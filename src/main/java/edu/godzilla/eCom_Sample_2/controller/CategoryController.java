package edu.godzilla.eCom_Sample_2.controller;

import edu.godzilla.eCom_Sample_2.model.Category;
import edu.godzilla.eCom_Sample_2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    private Long id = 0L;
    
    

    @GetMapping("/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/admin/category")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        ++id;
        category.setId(id);
        ResponseStatusException exception = categoryService.createCategory(category);
        return new ResponseEntity<>(exception.getReason(), exception.getStatusCode());
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try{
            ResponseStatusException responseStatusException =
                    categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(
                    responseStatusException.getReason(),
                    responseStatusException.getStatusCode());

        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/admin/category/update/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable Long categoryId,
                                                  @RequestBody Category category){
        try {
            categoryService.updateCategory(categoryId, category);
            ResponseStatusException responseStatusException = new ResponseStatusException(
                    HttpStatus.OK,
                    "Category updated!");
            return new ResponseEntity<>(
                    responseStatusException.getReason(),
                    responseStatusException.getStatusCode());
        }catch (ResponseStatusException exception){
            return new ResponseEntity<>(exception.getReason(), exception.getStatusCode());
        }
    }

}
