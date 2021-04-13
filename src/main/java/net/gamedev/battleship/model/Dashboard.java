package net.gamedev.battleship.model;

import java.sql.Time;
import java.util.Timer;

public class Dashboard {
    private int id;
    private String playerName;
    private String winOrLose;
    private Time score;



    public int getId() {
        return id;

    }

    public Dashboard(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getWinOrLose() {
        return winOrLose;
    }

    public void setWinOrLose(String winOrLose) {
        this.winOrLose = winOrLose;
    }

    public Time getScore() {
        return score;
    }

    public void setScore(Time score) {
        this.score = score;
    }
}
