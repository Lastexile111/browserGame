package ru.levelup.project.model;

import java.util.ArrayList;

public class User {
    private String login;
    private String password;
    private int exp;
    private int firstAtk;
    private int firstDef;
    private int secondAtk;
    private int secondDef;
    private int thirdAtk;
    private int thirdDef;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getFirstAtk() {
        return firstAtk;
    }

    public int getFirstDef() {
        return firstDef;
    }

    public int getSecondAtk() {
        return secondAtk;
    }

    public int getSecondDef() {
        return secondDef;
    }

    public int getThirdAtk() {
        return thirdAtk;
    }

    public int getThirdDef() {
        return thirdDef;
    }

    public int getExp() {
        return exp;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstAtk(int firstAtk) {
        this.firstAtk = firstAtk;
    }

    public void setFirstDef(int firstDef) {
        this.firstDef = firstDef;
    }

    public void setSecondAtk(int secondAtk) {
        this.secondAtk = secondAtk;
    }

    public void setSecondDef(int secondDef) {
        this.secondDef = secondDef;
    }

    public void setThirdAtk(int thirdAtk) {
        this.thirdAtk = thirdAtk;
    }

    public void setThirdDef(int thirdDef) {
        this.thirdDef = thirdDef;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
