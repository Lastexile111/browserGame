package ru.levelup.project.model;

import javax.persistence.*;

@Entity
@Table(name = "TACTICS")
public class Tactic {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private int Attack;

    @Column
    private int Defence;

    @OneToOne
    private User fighter;

    public Tactic() {
    }

    public Tactic(int attack, int defence) {
        Attack = attack;
        Defence = defence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getDefence() {
        return Defence;
    }

    public void setDefence(int defence) {
        Defence = defence;
    }

    public User getFighter() {
        return fighter;
    }

    public void setFighter(User fighter) {
        this.fighter = fighter;
    }
}
