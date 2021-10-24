package com.example.mlesson4;

public class Musics implements Listener {
    private String name, minutes, number, author;
    private int id;

    public String getName() {
        return name;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getNumber() {
        return number;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public Musics(String name, String minutes, String number, String author, int id) {
        this.name = name;
        this.minutes = minutes;
        this.number = number;
        this.author = author;
        this.id = id;
    }

    @Override
    public void onClick(Musics musics) {
    }
}