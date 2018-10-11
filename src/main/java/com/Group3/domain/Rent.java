package com.Group3.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Rent implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int customerId;
    private String rentDate;
    private String returntDate;
    private BigDecimal totalPrice;
    private int rentalDays;
    private boolean outstanding;

    private Rent(){};

    public int getId() {
        return id;
    }
    public String getRentDate() {
        return rentDate;
    }
    public String getReturntDate() {
        return returntDate;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public int getCustomerId() {
        return customerId;
    }

    public boolean isOutstanding() {
        return outstanding;
    }

    public Rent(Builder builder)
    {
       this.customerId = builder.customerId;
        this.id = builder.id;
        this.rentDate = builder.rentDate;
        this.returntDate = builder.returntDate;
        this.totalPrice = builder.totalPrice;
        this.rentalDays = builder.rentalDays;
        this.outstanding = builder.outstanding;
    }

    public static  class Builder {
        private int id;
        private String rentDate;
        private String returntDate;
        private BigDecimal totalPrice;
        private int customerId;
        private int rentalDays;
        private boolean outstanding;

        public Builder outstanding(boolean value)
        {
            this.outstanding = value;
            return this;
        }
        public Builder rentalDays(int value)
        {
            this.rentalDays = value;
            return this;
        }
       public Builder customerId(int value)
       {
           this.customerId = value;
            return this;
        }
        public Builder id(int value) {
            this.id = value;
            return this;
        }

        public Builder rentDate(String value) {
            this.rentDate = value;
            return this;
        }

        public Builder returntDate(String value) {
            this.returntDate = value;
            return this;
        }

        public Builder totalPrice(BigDecimal value) {
            this.totalPrice = value;
            return this;
        }

        public Rent build() {
            return new Rent(this);
        }
    }

}