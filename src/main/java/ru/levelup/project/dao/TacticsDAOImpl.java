package ru.levelup.project.dao;

import ru.levelup.project.model.Tactic;
import ru.levelup.project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class TacticsDAOImpl implements TacticsDAO {


    private EntityManager em;

    public TacticsDAOImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Tactic findById(int id) {
        return em.find(Tactic.class, id);
    }

    @Override
    public List<Tactic> findByFighter(User fighter) {
        return em.createQuery("SELECT t FROM Tactic t WHERE t.fighter = :fighter")
                .setParameter("fighter", fighter)
                .getResultList();
    }

    @Override
    public void add(Tactic tactic) {
        em.getTransaction().begin();
        try {
            em.persist(tactic);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
