package ru.levelup.project.dao;

import ru.levelup.project.model.Tactic;
import ru.levelup.project.model.User;

import java.util.List;

public interface TacticsDAO {
    Tactic findById (int id);
    List<Tactic> findByFighter(User fighter);
    void add(Tactic tactic);
}
