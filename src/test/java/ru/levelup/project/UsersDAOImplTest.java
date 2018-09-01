package ru.levelup.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.levelup.project.dao.UsersDAO;
import ru.levelup.project.dao.UsersDAOImpl;
import ru.levelup.project.model.User;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UsersDAOImplTest {
    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setup() {
        emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = emf.createEntityManager();
    }

    @After
    public void after() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    @Test
    public void userAdd() {
        UsersDAO usersDAO = new UsersDAOImpl(em);

        User user = new User("tester", "qwee");
        usersDAO.add(user);

        assertEquals(user, em.find(User.class, "tester"));
    }

    @Test(expected = EntityExistsException.class)
    public void userAddConstraintViolation() {
        UsersDAO usersDAO = new UsersDAOImpl(em);

        usersDAO.add(new User("tester", "Qwe"));
        usersDAO.add(new User("tester", "Qwe"));
    }

    @Test
    public void chartCreates() {

        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user1 = new User("tester1", "Qwe");
        user1.setExp(20);
        usersDAO.add(user1);
        User user2 = new User("tester2", "Qwe");
        user2.setExp(400);
        usersDAO.add(user2);

        List<User> chart = usersDAO.showChart();
        assertEquals(2, chart.size());
        assertEquals(user2, chart.get(0));
    }
}
