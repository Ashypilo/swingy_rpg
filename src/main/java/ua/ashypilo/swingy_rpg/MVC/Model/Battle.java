package ua.ashypilo.swingy_rpg.MVC.Model;

import ua.ashypilo.swingy_rpg.MVC.View.DataHero;
import ua.ashypilo.swingy_rpg.MVC.View.MapGame;
import ua.ashypilo.swingy_rpg.MVC.Model.Enemies.Enemies;
import ua.ashypilo.swingy_rpg.MVC.Model.Heroes.Heroes;
import javax.swing.*;
import java.lang.String;
import java.util.Scanner;

public class Battle extends MoveHero{
    String[] artifacts = {"Weapon", "Armor", "Helm"};
    int art;
    String rand_artifact;
    int rand_hero;
    int rand_enemy;
    int value;
    String message;
    Heroes hero;
    Enemies enemy;
    MapGame map;
    boolean gui;
    String dataInput;
    Scanner in;

    public Battle() {}
    public Battle(Heroes heroes, Enemies enemy, MapGame map) {
        this.hero = heroes;
        this.enemy = enemy;
        this.map = map;
        gui = true;
    }

    public Battle(Heroes heroes, Enemies enemy, boolean gui) {
        this.hero = heroes;
        this.enemy = enemy;
        this.gui = gui;
        in = new Scanner(System.in);
    }

    public int resultBattle() {
        BattleHeroEnemies();
        if (hero.getHitPoints() <= 0) {
            if (gui)
                DataHero.changeHitPoints();
            return 0;
        }
        hero.setExperience(enemy.getAttack());
        rand_artifact = artifacts[random(3)];
        value = (1 + (int)(Math.random()*(hero.getLevel() + 1))) * 5;
        message = "Artifact: " + rand_artifact + " + " + value + ".\n" + "Take?";
        if (gui) {
            art = JOptionPane.showConfirmDialog(map.layers, message, "You win.",
                    JOptionPane.YES_NO_OPTION);
            DataHero.changeLevelHero();
            DataHero.changeExperience();
            DataHero.changeHitPoints();
            if (art == JOptionPane.YES_OPTION) {
                if (rand_artifact == "Weapon") {
                    hero.setAttack(value);
                    DataHero.changeAttack();
                }
                else if (rand_artifact == "Armor") {
                    hero.setDefense(value);
                    DataHero.changeDefense();
                }
                else if (rand_artifact == "Helm") {
                    hero.setMaxHitPoints(value);
                    DataHero.changeHitPoints();
                }
            }
        }
        else
            consoleGame();
        return 1;
    }

    public void consoleGame() {
        System.out.println("------------------------");
        System.out.println("You win. \n" + message + " - yes(y)/no(n)");
        dataInput = in.next();
        int j = 0;
        while (j < 3) {
            if (dataInput.equals("y") || dataInput.equals("n"))
                break;
            j++;
            if (j == 3) {
                System.out.println("Write the correct answer:");
                dataInput = in.next();
                j = 0;
            }
        }
        System.out.println("------------------------");
        if (dataInput.equals("y")) {
            if (rand_artifact == "Weapon") {
                hero.setAttack(value);
            }
            else if (rand_artifact == "Armor") {
                hero.setDefense(value);
            }
            else if (rand_artifact == "Helm") {
                hero.setMaxHitPoints(value);
            }
        }
    }

    public int random(int attack) {
        return (int)(Math.random()*attack);
    }

    public void BattleHeroEnemies() {
        while (hero.getHitPoints() > 0 && enemy.getHitPoints() > 0) {
            rand_hero = random(hero.getAttack());
            rand_enemy = random(enemy.getAttack());
            if (rand_enemy > hero.getDefense()) {
                hero.setHitPoints(rand_enemy - hero.getDefense());
            }
            if (rand_hero > enemy.getDefense()) {
                enemy.setHitPoints(rand_hero - enemy.getDefense());
            }
        }
    }

}