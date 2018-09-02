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
import java.util.ArrayList;
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
        TacticsDAO tacticsDAO = new TacticsDAOImpl(em);
        Tactic tactic = new Tactic(1,2);
        tacticsDAO.add(tactic);

        assertEquals(tactic, tacticsDAO.findById(1));
    }

    @Test
    public void tacticAddTest() {
        TacticsDAO tacticsDAO = new TacticsDAOImpl(em);
        Tactic tactic = new Tactic(1,2);
        tacticsDAO.add(tactic);

        assertEquals(tactic, em.find(Tactic.class, 1));
    }



    @Test
    public void findByFighterTest() {
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user = new User("Tester", "Qwe");
        usersDAO.add(user);
        TacticsDAO tacticsDAO = new TacticsDAOImpl(em);

        Tactic tactic1 = new Tactic(1,2);

        tacticsDAO.add(tactic1);
        tactic1.setFighter(user);
        Tactic tactic2 = new Tactic(2,3);

        tacticsDAO.add(tactic2);
        tactic2.setFighter(user);
        Tactic tactic3 = new Tactic(3,1);
        tactic3.setFighter(user);
        tacticsDAO.add(tactic3);

        List<Tactic> tacticList = new ArrayList<>();
        tacticList.add(tactic1);
        tacticList.add(tactic2);
        tacticList.add(tactic3);


        user.setTactics(tacticList);


        List<Tactic> result = tacticsDAO.findByFighter(user);
        assertEquals(3, result.size());
        assertEquals(tacticList.get(0), result.get(0) );

    }
}
