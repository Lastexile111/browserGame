package ru.levelup.project.dao;

import ru.levelup.project.model.Battle;
import ru.levelup.project.model.Tactic;
import ru.levelup.project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

import static java.lang.Math.abs;

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

        return em.createQuery("SELECT b FROM Battle b WHERE b.provoker = :user OR b.participant = :user")
                .setParameter("user", user)
                .getResultList();

    }

    @Override
    public void add(Battle battle) {
        em.getTransaction().begin();
        try {
            em.persist(battle);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public User calculateBattle(Battle battle) {
        List<Tactic> player1Tactics = battle.getProvoker().getTactics();
        List<Tactic> player2Tactics = battle.getParticipant().getTactics();

        if((player2Tactics == null)||(player1Tactics == null)){
            throw new IllegalArgumentException("Player don't have a tactic");
        }

        int score = 0;
//Считаем очки
        for(int i = 0; i < player1Tactics.size(); i++) {
            if (player1Tactics.get(i).getAttack() != player2Tactics.get(i).getDefence()) {
                score++;
            } else if (player1Tactics.get(i).getAttack() == player2Tactics.get(i).getDefence()) {
                score--;
            }

            if (player2Tactics.get(i).getAttack() != player1Tactics.get(i).getDefence()) {
                score--;
            } else if (player2Tactics.get(i).getAttack() == player1Tactics.get(i).getDefence()) {
                score++;
            }
        }

//распределяем опыт в зависимости от победы или поражения, назначаем победителя
        if(score > 0){
            battle.getProvoker().setExp(battle.getProvoker().getExp() + 2 * abs(score));
            battle.getParticipant().setExp(battle.getParticipant().getExp() + 1 * abs(score));

            battle.setWinner(battle.getProvoker());

            return battle.getProvoker();
        }else if(score < 0){
            battle.getProvoker().setExp(battle.getProvoker().getExp() + 1 * abs(score));
            battle.getParticipant().setExp(battle.getParticipant().getExp() + 2 * abs(score));

            battle.setWinner(battle.getParticipant());

            return battle.getParticipant();
        }else{
            battle.getProvoker().setExp(battle.getProvoker().getExp() + 1 * abs(score));
            battle.getParticipant().setExp(battle.getParticipant().getExp() + 1 * abs(score));
            return null;
        }


    }
}
