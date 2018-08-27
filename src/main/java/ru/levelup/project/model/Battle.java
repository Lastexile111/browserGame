package ru.levelup.project.model;

public class Battle {

    private int battleId;
    private User firstFighter;
    private User secondFighter;
    private User winner;

    public Battle(int battleId, User firstFighter, User secondFighter) {
        this.battleId = battleId;
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
