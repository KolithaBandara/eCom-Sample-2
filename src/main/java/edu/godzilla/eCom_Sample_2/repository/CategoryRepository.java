package edu.godzilla.eCom_Sample_2.repository;

import edu.godzilla.eCom_Sample_2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
