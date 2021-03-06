package ru.levelup.project.dao;

import ru.levelup.project.model.User;

import java.util.List;

public interface UsersDAO {
    User findByLogin(String login);
    List<User> showChart();
    void add(User user);
}
