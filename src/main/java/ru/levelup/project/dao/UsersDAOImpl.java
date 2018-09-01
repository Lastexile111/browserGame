package ru.levelup.project.dao;

import ru.levelup.project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {

    private EntityManager em;

    public UsersDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public User findByLogin(String login) {
        return em.find(User.class, login);
    }

    @Override
    public List<User> showChart() {

        return em.createQuery("SELECT u FROM User u ORDER BY u.exp DESC ")
                .getResultList();
    }

    @Override
    public void add(User user) {
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
