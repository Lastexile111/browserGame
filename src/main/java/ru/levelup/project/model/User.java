package ru.levelup.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public  class User {
    @Id
    @Column(length = 50,unique = true, nullable = false)
    private String login;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(nullable = false)
    private int exp;

    @OneToMany(mappedBy = "fighter", fetch = FetchType.LAZY)
    private List<Tactic> tactics;

    @OneToMany(mappedBy = "provoker", fetch = FetchType.LAZY)
    private List<Battle> attacks;

    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY)
    private List<Battle> defences;

    @OneToMany(mappedBy = "winner", fetch = FetchType.LAZY)
    private List<Battle> victories;



    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.exp = 0;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getExp() {
        return exp;
    }

    public List<Tactic> getTactics() {
        return tactics;
    }

    public void setTactics(List<Tactic> tactics) {
        this.tactics = tactics;
    }

    public List<Battle> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Battle> attacks) {
        this.attacks = attacks;
    }

    public List<Battle> getDefences() {
        return defences;
    }

    public void setDefences(List<Battle> defences) {
        this.defences = defences;
    }

    public List<Battle> getVictories() {
        return victories;
    }

    public void setVictories(List<Battle> victories) {
        this.victories = victories;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }


}
