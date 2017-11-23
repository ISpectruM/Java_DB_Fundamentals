package application.services.category;

import application.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void save(Category category);
}
