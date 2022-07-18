package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDAOImp implements UserDAO {
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
