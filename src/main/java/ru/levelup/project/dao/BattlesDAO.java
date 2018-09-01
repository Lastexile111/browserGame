package ru.levelup.project.dao;

import ru.levelup.project.model.Battle;
import ru.levelup.project.model.User;

import java.util.List;

public interface BattlesDAO {
    Battle findBattleId (int id);
    List<Battle> findMyBattles(User user);
    User calculateBattle(Battle battle);
    void add(Battle battle);
}
