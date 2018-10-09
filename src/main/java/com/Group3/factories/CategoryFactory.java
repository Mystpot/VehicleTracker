package com.Group3.factories;

import com.Group3.domain.Category;

public class CategoryFactory {
    public static Category getCategory(String name, double price)
    {
        Category category = new Category.Builder()
                .name(name)
                .price(price)
                .build();
        return category;
    }
}
