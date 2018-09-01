package ru.levelup.project.dao;

import ru.levelup.project.model.Battle;
import ru.levelup.project.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class BattlesDAOImpl implements BattlesDAO {


    private EntityManager em;

    public BattlesDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Battle findBattleId(int id) {
        return em.find(Battle.class, id);
    }

    @Override
    public List<Battle> findMyBattles(User user) {
        return null;
    }

    @Override
    public User calculateBattle(Battle battle) {
        return null;
    }

    @Override
    public void add(Battle battle) {

    }
}
