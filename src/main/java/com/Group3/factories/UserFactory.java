package com.Group3.factories;

import com.Group3.domain.User;

public class UserFactory {
    public static User getUser(String name, String surname,String password, String role)
    {
        User user = new User.Builder()
                .name(name)
                .surname(surname)
                .password(password)
                .role(role)
                .build();
        return user;
    }

    public static User getUserByID(Long userID, String name, String surname,String password, String role)
    {
        User user =new User.Builder()
                .userID(userID)
                .name(name)
                .surname(surname)
                .password(password)
                .role(role)
                .build();
        return user;
    }


}
