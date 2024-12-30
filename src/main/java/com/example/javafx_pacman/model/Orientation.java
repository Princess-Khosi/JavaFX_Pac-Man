package com.example.javafx_pacman.model;

public class Orientation {
    private final int X,Y;

    public Orientation(int x, int y){
        this.X = x;
        this.Y = y;
    }


    public int getX() {
        return this.X;
    }


    public int getY() {
        return this.Y;
    }


    @Override
    public String toString() {
        return "Orientation{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
