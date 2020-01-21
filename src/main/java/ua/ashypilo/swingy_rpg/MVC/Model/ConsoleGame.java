package ua.ashypilo.swingy_rpg.MVC.Model;

import ua.ashypilo.swingy_rpg.MVC.Controller.Controller;
import ua.ashypilo.swingy_rpg.MVC.Model.Enemies.CreateEnemies;
import ua.ashypilo.swingy_rpg.MVC.Model.Enemies.Enemies;
import ua.ashypilo.swingy_rpg.MVC.Model.Heroes.Heroes;
import ua.ashypilo.swingy_rpg.MVC.View.MapGame;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleGame {
    Heroes hero;
    String dataInput;
    Scanner in;
    CreateEnemies createEnemies;
    ArrayList<Enemies> enemies = new ArrayList<Enemies>();
    Enemies enemy;
    Battle battleClass;
    String information_battle;
    boolean play;
    boolean battle;
    int heroesX;
    int heroesY;
    int squareX;
    int squareY;
    ArrayList<String> saveHeroes = new ArrayList<String>();

    public ConsoleGame(Heroes hero) {
        this.hero = hero;
        in = new Scanner(System.in);
        play = true;
        this.hero.setLevelGame(1);
        dataLevel();
    }

    public ConsoleGame(Heroes hero, ArrayList<Enemies> enemies) {
        this.hero = hero;
        in = new Scanner(System.in);
        play = true;
        this.hero.setLevelGame(hero.getLevel());
        heroesX = hero.getHeroesX();
        heroesY = hero.getHeroesY();
        squareX = hero.getSquareX();
        squareY = hero.getSquareY();
        this.enemies = new ArrayList<Enemies>(enemies);
    }

    public void dataLevel() {
        heroesX = hero.getHeroesX();
        heroesY = hero.getHeroesY();
        squareX = hero.getSquareX();
        squareY = hero.getSquareY();
        createEnemies = new CreateEnemies(hero.getLevel(), null, enemies);
        enemies = createEnemies.Create(false);
    }

    public void informationHero() {
        System.out.println("-----------SWING-RPG----------");
        System.out.println("Level Game: " + hero.getLevelGame());
        System.out.println("Hero: " + hero.getClassHeroes() + "-" + hero.getName());
        System.out.println("Level Hero: " + hero.getLevel());
        System.out.println("Experience: " + hero.getExperience() + "/" + hero.getNextLevel());
        System.out.println("Attack: " + hero.getAttack() + "(" + hero.getAttack_start() + ")");
        System.out.println("Defense: " + hero.getDefense() + "(" + hero.getDefense_start() + ")");
        System.out.println("Hit Points: " + hero.getHitPoints() + "/" + hero.getMaxHitPoints() +  "(" + hero.getHitPoints_start() + ")");
        System.out.println("------------------------------");
    }

    public void Game() {
        System.out.println("--------------Start Game----------------");
        while (play) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            informationHero();
            System.out.println("Set the direction: north(w), south(s), east(d), west(a).\nElse write 'exit' or go to 'gui' or 'save' heroes");
            writeMap();

            dataInput = in.next();
            if (dataInput.equals("w"))
                North();
            else if (dataInput.equals("s"))
                South();
            else if (dataInput.equals("d"))
                East();
            else if (dataInput.equals("a"))
                West();
            else if (dataInput.equals("save")) {

                try {
                    Controller.getSave().save(hero);
                }
                catch (ClassNotFoundException sqlEx) {
                    sqlEx.printStackTrace();
                }
            }
            else if (dataInput.equals("exit"))
                play = false;
            else if (dataInput.equals("gui")) {
                hero.getImageHero(hero.levelGame);
                hero.setSquareX(squareX);
                hero.setSquareY(squareY);
                hero.setHeroesX(heroesX);
                hero.setHeroesY(heroesY);
                MapGame gui = new MapGame(hero, false);
                gui.setEnemies(enemies);
                gui.changeDataMapHero(false);
                MoveHero move = new MoveHero(hero, gui);
                move.click();
                play = false;
            }
        }
        if (!dataInput.equals("gui"))
            java.lang.System.exit(0);
    }

    public void writeMap() {
        boolean enemyMap;
        for (int i = 0; i < hero.getSquare(); i++) {
            for (int j = 0; j < hero.getSquare(); j++) {
                enemyMap = false;
                for (int e = 0; e < enemies.size(); e++) {
                    if (j == enemies.get(e).getSquareX() && i == enemies.get(e).getSquareY()) {
                        if (enemies.get(e).getClassEnemies().equals("Zombie"))
                            System.out.print("|_Z_");
                        else
                            System.out.print("|_S_");
                        enemyMap = true;
                        break;
                    }
                }
                if (j == squareX && i == squareY)
                    System.out.print("|_H_");
                else if (!enemyMap)
                    System.out.print("|___");
            }
        System.out.print("|\n");
        }
    }

    public void North() {
        if ((squareY - 1) < 0) {
           nextLevel();
        }
        else {
            heroesY -= hero.getMove();
            squareY -= 1;
            questionBattle();
            if (!battle) {
                heroesY += hero.getMove();
                squareY += 1;
            }
        }

    }

    public void South() {
        if ((squareY + 1) >= hero.getSquare()) {
          nextLevel();
        }
        else {
            heroesY += hero.getMove();
            squareY += 1;
            questionBattle();
            if (!battle) {
                heroesY -= hero.getMove();
                squareY -= 1;
            }
        }

    }

    public void East() {
        if ((squareX + 1) >= hero.getSquare()) {
            nextLevel();
        }
        else {
            heroesX += hero.getMove();
            squareX += 1;
            questionBattle();
            if (!battle) {
                heroesX -= hero.getMove();
                squareX -= 1;
            }
        }

    }

    public void West() {
        if ((squareX - 1) < 0) {
          nextLevel();
        }
        else {
            heroesX -= hero.getMove();
            squareX -= 1;
            questionBattle();
            if (!battle) {
                heroesX += hero.getMove();
                squareX += 1;
            }
        }

    }


    public void questionBattle() {
        battle = true;
        for (int i = 0; i < enemies.size(); i++) {
            if (squareX == enemies.get(i).getSquareX() && squareY == enemies.get(i).getSquareY()) {
                int rand = 0;
                enemy = enemies.get(i);
                information_battle = "Enemies: " + enemy.getClassEnemies() + "\nAttack: " + enemy.getAttack() + "\nDefense: " + enemy.getDefense() + "\nHitPoints: " + enemy.getHitPoints();
                System.out.println("------------------------");
                System.out.println(information_battle);
                System.out.println("------------------------");
                if (hero.getAttack() >= enemy.getAttack()) {
                    System.out.println("battle(b) or run(r)?");
                    dataInput = in.next();
                    int j = 0;
                    while (j < 3) {
                        if (dataInput.equals("b") || dataInput.equals("r"))
                            break;
                        j++;
                        if (j == 3) {
                            System.out.println("Write the correct answer:");
                            dataInput = in.next();
                            j = 0;
                        }
                    }
                    if (dataInput.equals("run")) {
                        rand = (int)(Math.random()*100);
                        if (rand > 50)
                            battle = false;
                    }
                }
                if (rand < 50) {
                    System.out.println("Ha-ha no run. Battle.\nSay death(d).");
                    dataInput = in.next();
                    int j = 0;
                    while (j < 3) {
                        if (dataInput.equals("d"))
                            break;
                        j++;
                        if (j == 3) {
                            System.out.println("Write the correct answer:");
                            dataInput = in.next();
                            j = 0;
                        }
                    }
                    battleClass = new Battle(hero, enemy, false);
                    if (battleClass.resultBattle() == 1) {
                        enemies.remove(i);
                        System.out.println(enemies.size());
                    }
                    else if (battleClass.resultBattle() == 0)
                        losing();
                }
                break;
            }
        }
    }

    public void nextLevel() {
        if (hero.getLevel() == hero.getLevelGame()) {
            System.out.println("The hero cannot go to the next level of the game. \nRestart this level? yes(y)/no(n)");
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
        }
        if (dataInput.equals("y")) {
            enemies.clear();
            if (hero.getLevel() <= 7) {
                hero.setLevel(hero.getLevel());
                hero.setLevelGame(hero.getLevel());
                hero.Images(false);
                hero.HitPointsReturn();
                dataLevel();
            }
            else
            {
                System.out.println("You win game.");
                play = false;
            }
        }
    }

    public void losing() {
        enemies.clear();
        System.out.println("You losing.");
        play = false;
    }
}
