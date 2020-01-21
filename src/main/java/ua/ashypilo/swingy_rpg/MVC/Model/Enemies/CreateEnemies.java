package ua.ashypilo.swingy_rpg.MVC.Model.Enemies;

import javax.swing.*;
import java.util.ArrayList;

public class CreateEnemies {
    int level;
    JLayeredPane layers;
    ArrayList<Enemies> enemies;
    Enemies enemy;

    public CreateEnemies(int level, JLayeredPane layers, ArrayList<Enemies> enemies) {
        this.level = level;
        this.layers = layers;
        this.enemies = enemies;
    }

    public ArrayList<Enemies> Create(boolean gui){
        for (int i = 0; i < level * 20; i++) {
            if (i < (level * 20)/2)
                enemy = new Skeleton(layers, level);
            else
                enemy = new Zombie(layers, level);
            Enemy();
            enemies.add(enemy);
        }
        if (gui) {
            for (int i = 0; i < enemies.size(); i++)
                enemies.get(i).addEnemies();
        }
        return enemies;
    }

    public void Enemy() {
        enemy.setLevel(level);
        enemy.Images();
        enemy.Coordinate();
        while (checkSameCoordinateEnemies(enemy) == 1)
            enemy.Coordinate();
    }

    public int checkSameCoordinateEnemies(Enemies skeletonAdd) {
        for (int i = 0; i < enemies.size(); i++) {
            if (skeletonAdd.getSquareX() == enemies.get(i).getSquareX() && skeletonAdd.getSquareY() == enemies.get(i).getSquareY()) {
                return 1;
            }
        }
        return 0;
    }
}
