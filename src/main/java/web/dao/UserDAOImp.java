package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class UserDAOImp implements UserDAO {
//    private List<User> users;
//    private int USERS_COUNT;

//    {
//        users = new ArrayList<>();
//
//        users.add(new User(++USERS_COUNT, "Petr Ivanov", 45, "Omsk"));
//        users.add(new User(++USERS_COUNT, "Mary Smith", 45, "London"));
//        users.add(new User(++USERS_COUNT, "Mihail Lomonosov", 45, "Moscow"));
//        users.add(new User(++USERS_COUNT, "Valery Jakov", 45, "St. Petersburg"));
//        users.add(new User(++USERS_COUNT, "Alan Daniels", 45, "New York"));
//    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(findUserById(id));

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }


}
