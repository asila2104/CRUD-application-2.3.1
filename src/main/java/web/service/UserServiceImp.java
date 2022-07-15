package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDAOImp;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDAOImp dao;

    public UserServiceImp(UserDAOImp dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(User user) {
        dao.save(user);
    }

    @Override
    public void removeUser(int id) {
        dao.deleteById(id);
    }

    @Override
    public void updateUser(int id, User user) {
        User user1 = dao.findById(id).get();
        user1.setName(user.getName());
        user1.setAddress(user.getAddress());
        user1.setAge(user.getAge());
        dao.save(user1);
    }

    @Override
    public User findUserById(int id) {
        return dao.findById(id).get();
    }

    @Override
    public List<User> showUsers() {
        return dao.findAll();
    }
}
