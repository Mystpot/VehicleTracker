package com.Group3.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Invoices implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private  Customer customer;

    private Invoices(){}
    public long getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }

    public Invoices(Builder builder)
    {
        this.id = builder.id;
        this.customer = builder.customer;
    }

    public static  class Builder
    {
        private long id;
        private  Customer customer;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }

        public Builder customer(Customer value)
        {
            this.customer = value;
            return this;
        }

        public Invoices build()
        {
            return new Invoices(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoices invoices = (Invoices) o;

        return id == invoices.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}