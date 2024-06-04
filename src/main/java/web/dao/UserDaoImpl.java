package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getUsersList() {
        return entityManager.createQuery(
                "select u from User u",
                User.class
        ).getResultList();
    }

    @Override
    public void delete(User user) {
        entityManager.remove(
                entityManager.merge(user)
        );
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
