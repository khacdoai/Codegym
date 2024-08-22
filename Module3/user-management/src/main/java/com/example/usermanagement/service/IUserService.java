package com.example.usermanagement.service;

import com.example.usermanagement.model.User;

import java.util.List;

public interface IUserService {
    List<User> showList();
    void addNewUser(User user);
    void updateUser(User user);
    User selectUser(int id);
    void deleteUser(int id);
    List<User> searchUserByCountry(String country);
    List<User> sortByName();
    void insertUser(User user);
    void insertUserStore(User user);
    void addUserTransaction(User user, int[] permision);



}
