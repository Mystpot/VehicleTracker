package com.Group3.services;

import com.Group3.domain.Category;

import java.util.Optional;

public interface CategoryService {
    Category create(Category category);
    Optional<Category> read(long id);
    Category update(Category category);
    void delete(Category id);
    Category findByName(String name);
    Iterable<Category> readAll();
}
