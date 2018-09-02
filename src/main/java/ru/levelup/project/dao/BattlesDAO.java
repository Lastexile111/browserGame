package ru.levelup.project.dao;

import ru.levelup.project.model.Battle;
import ru.levelup.project.model.User;

import java.util.List;

public interface BattlesDAO {
    Battle findBattleId (int id);
    List<Battle> findMyBattles(User user);
    void add(Battle battle);
    User calculateBattle(Battle battle);
}
