package ru.levelup.project.model;

import javax.persistence.*;

@Entity
@Table(name = "BATTLES")
public class Battle {
    @Id
    @GeneratedValue
    private int battleId;

    @ManyToOne
    private User provoker;

    @ManyToOne
    private User participant;

    @ManyToOne
    private User winner;


    public Battle() {
    }

    public Battle(User firstFighter, User secondFighter) {
        if (firstFighter == null) throw new IllegalArgumentException("firstFighter shouldn't be null");
        if (secondFighter == null) throw new IllegalArgumentException("secondFighter shouldn't be null");
        this.provoker = firstFighter;
        this.participant = secondFighter;
    }

    public int getBattleId() {
        return battleId;
    }

    public void setBattleId(int battleId) {
        this.battleId = battleId;
    }

    public User getProvoker() {
        return provoker;
    }

    public void setProvoker(User provoker) {
        this.provoker = provoker;
    }

    public User getParticipant() {
        return participant;
    }

    public void setParticipant(User participant) {
        this.participant = participant;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }


}
