package com.example.ecommercesystem;

public interface UserRepository {

    User getUserByID(int id);

    void save (User user);

    void updateUser(User user);

    void deleteUser(int id);
}
