package ru.levelup.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.levelup.project.dao.*;
import ru.levelup.project.model.Battle;
import ru.levelup.project.model.Tactic;
import ru.levelup.project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BattleDAOImplTest {

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
    public void findBattleIdTest(){
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user1 = new User("Tester1", "Qwe");
        usersDAO.add(user1);
        User user2 = new User("Tester2", "Qwe");
        usersDAO.add(user2);

        BattlesDAO battlesDAO = new BattlesDAOImpl(em);
        Battle battle = new Battle(user1,user2);
        battlesDAO.add(battle);

        assertEquals(battle, battlesDAO.findBattleId(1));
    }

    @Test
    public void battleAddTest() {
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user1 = new User("Tester1", "Qwe");
        usersDAO.add(user1);
        User user2 = new User("Tester2", "Qwe");
        usersDAO.add(user2);

        BattlesDAO battlesDAO = new BattlesDAOImpl(em);
        Battle battle = new Battle(user1,user2);
        battlesDAO.add(battle);

        assertEquals(battle, em.find(Battle.class, 1));
    }

    @Test
    public void findMyBattlesTest() {
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user1 = new User("Tester1", "Qwe");
        usersDAO.add(user1);
        User user2 = new User("Tester2", "Qwe");
        usersDAO.add(user2);
        User user3 = new User("Tester3", "Qwe");
        usersDAO.add(user3);

        BattlesDAO battlesDAO = new BattlesDAOImpl(em);
        Battle battle1 = new Battle(user1,user2);
        battlesDAO.add(battle1);
        Battle battle2 = new Battle(user2,user3);
        battlesDAO.add(battle2);
        Battle battle3 = new Battle(user3,user1);
        battlesDAO.add(battle3);

        assertEquals(2, battlesDAO.findMyBattles(user1).size());
        assertEquals(battle1, battlesDAO.findMyBattles(user1).get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateBattleTest_Exception() {
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user1 = new User("Tester1", "Qwe");
        usersDAO.add(user1);
        User user2 = new User("Tester2", "Qwe");
        usersDAO.add(user2);
        User user3 = new User("Tester3", "Qwe");
        usersDAO.add(user3);

        BattlesDAO battlesDAO = new BattlesDAOImpl(em);
        Battle battle1 = new Battle(user1,user2);
        battlesDAO.add(battle1);
        Battle battle2 = new Battle(user2,user3);
        battlesDAO.add(battle2);
        Battle battle3 = new Battle(user3,user1);
        battlesDAO.add(battle3);

        battlesDAO.calculateBattle(battle1);

    }

    @Test
    public void calculateBattleTest() {
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user1 = new User("Tester1", "Qwe");
        usersDAO.add(user1);
        User user2 = new User("Tester2", "Qwe");
        usersDAO.add(user2);


        TacticsDAO tacticsDAO = new TacticsDAOImpl(em);

        Tactic tactic1 = new Tactic(1, 2);
        tacticsDAO.add(tactic1);
        tactic1.setFighter(user1);

        Tactic tactic2 = new Tactic(2, 3);
        tacticsDAO.add(tactic2);
        tactic2.setFighter(user1);

        Tactic tactic3 = new Tactic(3, 1);
        tactic3.setFighter(user1);
        tacticsDAO.add(tactic3);

        Tactic tactic4 = new Tactic(1, 1);
        tacticsDAO.add(tactic4);
        tactic1.setFighter(user2);

        Tactic tactic5 = new Tactic(2, 3);
        tacticsDAO.add(tactic5);
        tactic2.setFighter(user2);

        Tactic tactic6 = new Tactic(3, 1);
        tactic3.setFighter(user2);
        tacticsDAO.add(tactic6);

        List<Tactic> tacticList1 = new ArrayList<>();
        tacticList1.add(tactic1);
        tacticList1.add(tactic2);
        tacticList1.add(tactic3);

        List<Tactic> tacticList2 = new ArrayList<>();
        tacticList2.add(tactic4);
        tacticList2.add(tactic5);
        tacticList2.add(tactic6);

        user1.setTactics(tacticList1);
        user2.setTactics(tacticList2);

        BattlesDAO battlesDAO = new BattlesDAOImpl(em);
        Battle battle1 = new Battle(user1, user2);

        battlesDAO.add(battle1);

        assertEquals(user2,battlesDAO.calculateBattle(battle1));
        assertEquals(user2,battle1.getWinner());
    }
}
