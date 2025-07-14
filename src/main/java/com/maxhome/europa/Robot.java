package com.maxhome.europa;

public class Robot {
    private int x;
    private int y;
    private char direction;

    public Robot(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void rotateLeft() {
        direction = switch (direction) {
            case 'N' -> 'W';
            case 'W' -> 'S';
            case 'S' -> 'E';
            case 'E' -> 'N';
            default -> direction;
        };
    }

    public void rotateRight() {
        direction = switch (direction) {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> direction;
        };
    }

    public void moveForward(Plateau plateau) {
        int newX = x, newY = y;
        switch (direction) {
            case 'N' -> newY++;
            case 'E' -> newX++;
            case 'S' -> newY--;
            case 'W' -> newX--;
        }
        if (plateau.isWithinBounds(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}