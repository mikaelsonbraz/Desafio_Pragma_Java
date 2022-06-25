package com.mikaelsonbraz.desafiopragma.models;

public class Game {

    private int id;
    private Status status;

    public Game() {
    }

    public Game(int id, Status status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "game: " + id +
                ", status: " + status +
                '}';
    }
}