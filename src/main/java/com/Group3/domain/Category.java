package com.Group3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long catId;
    private String name;
    private double price;

    private Category(){

    }

    public static class Builder{
        private long catId;
        private String name;
        private double price;

        public Builder id(long value)
        {
            this.catId = value;
            return this;
        }
        public Builder name(String value)
        {
            this.name = value;
            return this;
        }
        public Builder price(double value)
        {
            this.price = value;
            return this;
        }
        public Category build()
        {
            return new Category(this);
        }
    }

    public Category(Builder builder) {
        this.catId = builder.catId;
        this.name = builder.name;
        this.price = builder.price;
    }


    public long getId() {
        return catId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return catId == category.catId;
    }

    @Override
    public int hashCode() {
        return (int) (catId ^ (catId >>> 32));
    }
}
