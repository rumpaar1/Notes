package com.example.rumpaar1.notes;

/**
 * Created by rumpaar1 on 7/3/16.
 */
public class Note {
    private String text;
    private String name;

    public Note(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
