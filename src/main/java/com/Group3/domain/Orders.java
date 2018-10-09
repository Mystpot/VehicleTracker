package com.Group3.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String orderDate;

    @ManyToOne
    private Customer customer;

    private Orders(){}

    public Orders(Builder builder) {
        this.id = builder.id;
        this.orderDate = builder.orderDate;
        this.customer = builder.customer;
    }

    public static class Builder{
        private long id;
        private Customer customer;
        private String orderDate;

        public Builder customer(Customer value)
        {
            this.customer = value;
            return this;
        }

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder orderDate(String value)
        {
            this.orderDate = value;
            return this;
        }


        public Orders build()
        {
            return new Orders(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        return id == orders.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
