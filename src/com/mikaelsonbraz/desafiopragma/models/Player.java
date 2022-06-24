package com.mikaelsonbraz.desafiopragma.models;

import java.util.List;

public class Player {

    private int id;
    private String name;
    private int kills;
    private List<String> old_names;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kills=" + kills +
                ", old_names=" + old_names +
                '}';
    }

    public Player() {
    }

    public Player(int id, String name, int kills, List<String> old_names) {
        this.id = id;
        this.name = name;
        this.kills = kills;
        this.old_names = old_names;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getKills() {
        return kills;
    }

    public List<String> getOld_names() {
        return old_names;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setOld_names(List<String> old_names) {
        this.old_names = old_names;
    }
}
