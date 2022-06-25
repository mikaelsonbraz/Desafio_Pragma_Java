package com.mikaelsonbraz.desafiopragma.models;

import java.util.List;

public class Status {

    private int total_kills;
    private List<Player> players;

    public Status() {
    }

    public Status(int total_kills, List<Player> players) {
        this.total_kills = total_kills;
        this.players = players;
    }

    public int getTotal_kills() {
        return total_kills;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setTotal_kills(int total_kills) {
        this.total_kills = total_kills;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "{" +
                "total_kills: " + total_kills +
                ", players: " + players +
                '}';
    }
}
