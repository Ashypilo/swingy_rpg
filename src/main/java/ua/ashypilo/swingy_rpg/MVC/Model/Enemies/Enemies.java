package ua.ashypilo.swingy_rpg.MVC.Model.Enemies;

import ua.ashypilo.swingy_rpg.MVC.Model.MyImages.ImagesEnemies;

import javax.swing.*;

public class Enemies {
    JLayeredPane layers;
    public String classEnemies;
    public int level;
    public int squareX;
    public int squareY;
    public int attack;
    public int defense;
    public int hitPoints;
    public int enemiesX;
    public int enemiesY;
    public double move;
    public double sizeSquare;
    public ImagesEnemies images;

    public ImagesEnemies getImages() {
        return images;
    }

    public void Images() {

    }

    public void setLayers(JLayeredPane layers) {
        this.layers = layers;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHitPoints(int hit) {
    }

    public void addEnemies() {

    }

    public void randomEnemies(int square) {

    }

    public int getEnemiesX() {
        return enemiesX;
    }

    public int getEnemiesY() {
        return enemiesY;
    }

    public int getSquareX() {
        return squareX;
    }

    public int getSquareY() {
        return squareY;
    }

    public void Coordinate() {

    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getClassEnemies() {
        return classEnemies;
    }
}
