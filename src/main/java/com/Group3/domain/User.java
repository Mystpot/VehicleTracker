package com.Group3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userID;
    private String name,surname,password,role;

    private User(){}

    public long getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public User(Builder builder)
    {
        this.userID = builder.userID;
        this.name = builder.name;
        this.surname = builder.surname;
        this.password=builder.password;
        this.role=builder.role;
    }


    public static class Builder {
        private long userID;
        private String name, surname, password, role;

        public Builder userID(long value) {
            this.userID = value;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder surname(String value) {
            this.surname = value;
            return this;
        }

        public Builder password(String value) {
            this.password = value;
            return this;
        }

        public Builder role(String value) {
            this.role = value;
            return this;
        }

        public User build() {
            return new User(this);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return userID == user.userID;
        }

        @Override
        public int hashCode() {
            return (int) (userID ^ (userID >>> 32));
        }
    }
}
