package ua.ashypilo.swingy_rpg.MVC.Model.Enemies;

import ua.ashypilo.swingy_rpg.MVC.Model.MyImages.ImagesEnemies;
import ua.ashypilo.swingy_rpg.MVC.Model.MyImages.ImagesZombie;

import javax.swing.*;

public class Zombie extends Enemies {

    public Zombie(JLayeredPane layers, int level) {
        super.layers = layers;
        super.classEnemies = "Zombie";
        super.attack = 60 + (level * 10);
        super.defense = 60 + (level * 10);
        super.hitPoints = 20 + (level * 10);
    }

    public void addEnemies() {
        super.images.setBounds(super.enemiesX, super.enemiesY, 100, 100);
        super.layers.add(super.images, JLayeredPane.DRAG_LAYER);
    }

    public void setLevel(int level) {
        super.level = level;
    }

    public void Coordinate() {
        switch (super.level) {
            case 1: {
                super.move = 1000 / 9;
                super.sizeSquare = super.move * 9;
                randomEnemies(8);
                super.enemiesX = 435 + ((int) move * super.squareX);
                super.enemiesY = 215 + ((int) move * super.squareY);
                break;
            }
            case 2: {
                super.move = 1000 / 15;
                super.sizeSquare = super.move * 15;
                randomEnemies(14);
                super.enemiesX = 420 + ((int) move * super.squareX);
                super.enemiesY = 200 + ((int) move * super.squareY);
                break;
            }
            case 3: {
                super.move = 1000 / 19;
                super.sizeSquare = move * 19;
                randomEnemies(18);
                super.enemiesX = 420 + ((int) move * super.squareX);
                super.enemiesY = 202 + ((int) move * super.squareY);
                break;
            }
            case 4: {
                super.move = 1000 / 25;
                super.sizeSquare = move * 25;
                randomEnemies(24);
                super.enemiesX = 420 + ((int) move * super.squareX);
                super.enemiesY = 202 + ((int) move * super.squareY);
                break;
            }
            case 5: {
                super.move = 1000 / 29;
                super.sizeSquare = move * 29;
                randomEnemies(28);
                super.enemiesX = 422 + ((int) move * super.squareX);
                super.enemiesY = 202 + ((int) move * super.squareY);
                break;
            }
            case 6: {
                super.move = 1000 / 35;
                super.sizeSquare = move * 35;
                randomEnemies(34);
                super.enemiesX = 422 + ((int) move * super.squareX);
                super.enemiesY = 202 + ((int) move * super.squareY);
                break;
            }
            case 7: {
                super.move = 1000 / 39;
                super.sizeSquare = move * 39;
                randomEnemies(38);
                super.enemiesX = 422 + ((int) move * super.squareX);
                super.enemiesY = 202 + ((int) move * super.squareY);
                break;
            }
        }
    }

    public void Images() {
        switch (super.level) {
            case 1: {
                super.images = new ImagesZombie.Level1();
                break;
            }
            case 2: {
                super.images = new ImagesZombie.Level2();
                break;
            }
            case 3: {
                super.images = new ImagesZombie.Level3();
                break;
            }
            case 4: {
                super.images = new ImagesZombie.Level4();
                break;
            }
            case 5: {
                super.images = new ImagesZombie.Level5();
                break;
            }
            case 6: {
                super.images = new ImagesZombie.Level6();
                break;
            }
            case 7: {
                super.images = new ImagesZombie.Level7();
                break;
            }
        }

    }

    public void randomEnemies(int square) {
        super.squareX = -1;
        super.squareY = -1;
        super.squareX = 0 + (int) (Math.random()* square);
        super.squareY = 0 + (int) (Math.random()* square);
        if (super.squareX == square/2 && super.squareY == square/2)
            randomEnemies(square);
    }

    public void setLayers(JLayeredPane layers) {
        super.layers = layers;
    }

    public void setHitPoints(int hit) {
        super.hitPoints -= hit;
    }

    public int getEnemiesX() {
        return super.getEnemiesX();
    }

    public int getEnemiesY() {
        return super.getEnemiesY();
    }

    public int getSquareX() {
        return super.getSquareX();
    }

    public int getSquareY() {
        return super.getSquareY();
    }

    public ImagesEnemies getImages() {
        return super.getImages();
    }

    public int getDefense() {
        return super.defense;
    }

    public int getAttack() {
        return super.attack;
    }

    public int getHitPoints() {
        return super.hitPoints;
    }
}
