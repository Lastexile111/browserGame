package ru.levelup.project.model;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(length = 50,unique = true, nullable = false)
    private String login;

    @Column(length = 50, nullable = false)
    private String password;

    @Column
    private int exp;

    @OneToOne(mappedBy = "fighter", fetch = FetchType.LAZY)
    private Tactic firstTactic;
    @OneToOne(mappedBy = "fighter", fetch = FetchType.LAZY)
    private Tactic secondTactic;
    @OneToOne(mappedBy = "fighter", fetch = FetchType.LAZY)
    private Tactic thirdTactic;

    @ManyToMany
    @JoinTable(name = "user_battles",
            joinColumns =  @JoinColumn(name = "login"),
            inverseJoinColumns = @JoinColumn(name = "battleId")
    )
    private Battle battle;



    public User() {
    }

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


    public int getExp() {
        return exp;
    }

    public Tactic getFirstTactic() {
        return firstTactic;
    }

    public Tactic getSecondTactic() {
        return secondTactic;
    }

    public Tactic getThirdTactic() {
        return thirdTactic;
    }

    public Battle getBattle() {
        return battle;
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

    public void setFirstTactic(Tactic firstTactic) {
        this.firstTactic = firstTactic;
    }

    public void setSecondTactic(Tactic secondTactic) {
        this.secondTactic = secondTactic;
    }

    public void setThirdTactic(Tactic thirdTactic) {
        this.thirdTactic = thirdTactic;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }
}
