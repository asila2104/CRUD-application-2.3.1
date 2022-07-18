package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.dao.UserDAOImp;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDAO dao;

    public UserServiceImp(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void removeUser(int id) {
        dao.removeUser(id);
    }

    @Override
    public void updateUser(int id, User user) {
        User user1 = dao.findUserById(id);
        user1.setName(user.getName());
        user1.setAddress(user.getAddress());
        user1.setAge(user.getAge());
        dao.addUser(user1);
    }

    @Override
    public User findUserById(int id) {
        return dao.findUserById(id);
    }

    @Override
    public List<User> showUsers() {
        return dao.showUsers();
    }
}
