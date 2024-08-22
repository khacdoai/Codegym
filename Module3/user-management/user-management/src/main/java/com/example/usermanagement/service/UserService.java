package com.example.usermanagement.service;

import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.IUserRepository;
import com.example.usermanagement.repository.UserRepository;

import java.util.List;

public class UserService implements IUserService{
    IUserRepository userRepository = new UserRepository();
    @Override
    public List<User> showList() {
        return userRepository.showList();
    }

    @Override
    public void addNewUser(User user) {
        userRepository.addNewUser(user);

    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public void deleteUser(int id) {

        userRepository.deleteUser(id);
    }

    @Override
    public List<User> searchUserByCountry(String country) {
        return userRepository.searchUserByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public void insertUserStore(User user) {
        userRepository.insertUserStore(user);

    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        userRepository.addUserTransaction(user,permision);
    }
}
