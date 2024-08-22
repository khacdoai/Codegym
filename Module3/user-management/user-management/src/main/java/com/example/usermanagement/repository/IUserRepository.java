package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> showList();
    void addNewUser(User user);
    boolean updateUser(User user);
    User selectUser(int id);
    boolean deleteUser(int id);
    List<User> searchUserByCountry(String country);
    List<User> sortByName();
    void addUserTransaction(User user, int[] permision);
    void insertUser(User user);
    void insertUserStore(User user);


}
