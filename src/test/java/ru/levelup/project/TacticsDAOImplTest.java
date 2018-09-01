package ru.levelup.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.levelup.project.dao.TacticsDAO;
import ru.levelup.project.dao.TacticsDAOImpl;
import ru.levelup.project.dao.UsersDAO;
import ru.levelup.project.dao.UsersDAOImpl;
import ru.levelup.project.model.Tactic;
import ru.levelup.project.model.User;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TacticsDAOImplTest {
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
    public void tacticFindByIdTest(){
        TacticsDAO usersDAO = new TacticsDAOImpl(em);
        Tactic tactic = new Tactic(1,2);
        usersDAO.add(tactic);

        assertEquals(tactic, usersDAO.findById(0));
    }

    @Test
    public void tacticAddTest() {
        TacticsDAO usersDAO = new TacticsDAOImpl(em);
        Tactic tactic = new Tactic(1,2);
        usersDAO.add(tactic);

        assertEquals(tactic, em.find(Tactic.class, 1));
    }



    @Test
    public void findByFighter() {


    }
}
