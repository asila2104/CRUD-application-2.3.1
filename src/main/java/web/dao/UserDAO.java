package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void removeUser(int id);
    void updateUser(User user);
    User findUserById(int id);
    List<User> showUsers();
}
