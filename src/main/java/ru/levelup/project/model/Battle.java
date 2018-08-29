package ru.levelup.project.model;

import javax.persistence.*;

@Entity
@Table(name = "BATTLES")
public class Battle {
    @Id
    @GeneratedValue
    private int battleId;

    @ManyToMany(mappedBy = "battle", fetch = FetchType.LAZY)
    private User firstFighter;

    @ManyToMany(mappedBy = "battle", fetch = FetchType.LAZY)
    private User secondFighter;

    @ManyToMany(mappedBy = "battle", fetch = FetchType.LAZY)
    private User winner;

    public Battle() {
    }

    public Battle(User firstFighter, User secondFighter) {
        if (firstFighter == null) throw new IllegalArgumentException("firstFighter shouldn't be null");
        if (secondFighter == null) throw new IllegalArgumentException("secondFighter shouldn't be null");
        this.firstFighter = firstFighter;
        this.secondFighter = secondFighter;
    }

    public int getBattleId() {
        return battleId;
    }

    public void setBattleId(int battleId) {
        this.battleId = battleId;
    }

    public User getFirstFighter() {
        return firstFighter;
    }

    public void setFirstFighter(User firstFighter) {
        this.firstFighter = firstFighter;
    }

    public User getSecondFighter() {
        return secondFighter;
    }

    public void setSecondFighter(User secondFighter) {
        this.secondFighter = secondFighter;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }


}
