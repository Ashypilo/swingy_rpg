package ua.ashypilo.swingy_rpg.MVC.Model;

import ua.ashypilo.swingy_rpg.MVC.Controller.Controller;
import ua.ashypilo.swingy_rpg.MVC.View.MapGame;
import ua.ashypilo.swingy_rpg.MVC.Model.Enemies.Enemies;
import ua.ashypilo.swingy_rpg.MVC.Model.Heroes.Heroes;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveHero{

    public Heroes heroes;
    public MapGame map;
    int heroesX;
    int heroesY;
    int squareX;
    int squareY;
    int confirmation;
    int battle;
    Enemies enemy;
    Battle battleClass;
    String information_battle;
    int enemyNum;
    boolean finish = false;

    public MoveHero() {}

    public MoveHero(Heroes heroes, MapGame map) {
        this.heroes = heroes;
        this.map = map;
        heroesX = this.heroes.getHeroesX();
        heroesY = this.heroes.getHeroesY();
        squareX = this.heroes.getSquareX();
        squareY = this.heroes.getSquareY();
    }

    public int click() {
        map.north.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((squareY - 1) < 0) {
                    questionNextLevel();
                    if (confirmation == JOptionPane.YES_OPTION)
                        nextLevel();
                }
                else {
                    heroesY -= heroes.getMove();
                    squareY -= 1;
                    battle = -2;
                    questionBattle();
                    if (battle == JOptionPane.YES_OPTION) {
                        battleClass = new Battle(heroes, enemy, map);
                        if (battleClass.resultBattle() == 1) {
                            map.enemies.get(enemyNum).getImages().setVisible(false);
                            map.enemies.remove(enemyNum);
                        }
                        else if (battleClass.resultBattle() == 0)
                            losing();
                        else {
                            heroesY += heroes.getMove();
                            squareY += 1;
                        }
                    }
                    else if (battle == JOptionPane.NO_OPTION || battle == JOptionPane.CLOSED_OPTION) {
                        heroesY += heroes.getMove();
                        squareY += 1;
                    }
                    heroes.getImages().setBounds(heroesX, heroesY,70,135);
                }
            }
        });
        map.south.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((squareY + 1) >= (int)heroes.getSquare()) {
                    questionNextLevel();
                    if (confirmation == JOptionPane.YES_OPTION)
                        nextLevel();
                }
                else {
                    heroesY += heroes.getMove();
                    squareY += 1;
                    battle = -2;
                    questionBattle();
                    if (battle == JOptionPane.YES_OPTION) {
                        battleClass = new Battle(heroes, enemy, map);
                        if (battleClass.resultBattle() == 1) {
                            map.enemies.get(enemyNum).getImages().setVisible(false);
                            map.enemies.remove(enemyNum);
                        }
                        else if (battleClass.resultBattle() == 0)
                            losing();
                        else {
                            heroesY -= heroes.getMove();
                            squareY -= 1;
                        }
                    }
                    else if (battle == JOptionPane.NO_OPTION || battle == JOptionPane.CLOSED_OPTION) {
                        heroesY -= heroes.getMove();
                        squareY -= 1;
                    }
                    heroes.getImages().setBounds(heroesX, heroesY,70,135);
                }
            }
        });
        map.west.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((squareX - 1) < 0) {
                    questionNextLevel();
                    if (confirmation == JOptionPane.YES_OPTION)
                        nextLevel();
                }
                else {
                    heroesX -= heroes.getMove();
                    squareX -= 1;
                    battle = -2;
                    questionBattle();
                    if (battle == JOptionPane.YES_OPTION) {
                        battleClass = new Battle(heroes, enemy, map);
                        if (battleClass.resultBattle() == 1) {
                            map.enemies.get(enemyNum).getImages().setVisible(false);
                            map.enemies.remove(enemyNum);
                        }
                        else if (battleClass.resultBattle() == 0)
                            losing();
                        else {
                            heroesX += heroes.getMove();
                            squareX += 1;
                        }
                    }
                    else if (battle == JOptionPane.NO_OPTION || battle == JOptionPane.CLOSED_OPTION) {
                        heroesX += heroes.getMove();
                        squareX += 1;
                    }
                    heroes.getImages().setBounds(heroesX, heroesY,70,135);
                }
            }
        });
        map.east.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((squareX + 1) >= (int)heroes.getSquare())  {
                    questionNextLevel();
                    if (confirmation == JOptionPane.YES_OPTION)
                        nextLevel();
                }
                else {
                    heroesX += heroes.getMove();
                    squareX += 1;
                    battle = -2;
                    questionBattle();
                    if (battle == JOptionPane.YES_OPTION) {
                        battleClass = new Battle(heroes, enemy, map);
                        if (battleClass.resultBattle() == 1) {
                            map.enemies.get(enemyNum).getImages().setVisible(false);
                            map.enemies.remove(enemyNum);
                        }
                        else if (battleClass.resultBattle() == 0) {
                            losing();
                        }
                        else {
                            heroesX -= heroes.getMove();
                            squareX -= 1;
                        }
                    }
                    else if (battle == JOptionPane.NO_OPTION || battle == JOptionPane.CLOSED_OPTION) {
                        heroesX -= heroes.getMove();
                        squareX -= 1;
                    }
                    heroes.getImages().setBounds(heroesX, heroesY,70,135);
                }
            }
        });

        map.getConsoleGame().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                map.panel.setVisible(false);
                heroes.setSquareX(squareX);
                heroes.setSquareY(squareY);
                heroes.setHeroesX(heroesX);
                heroes.setHeroesY(heroesY);
                ConsoleGame consoleGame = new ConsoleGame(heroes, map.enemies);
                consoleGame.Game();
            }
        });
        map.getQuit().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmation = JOptionPane.showConfirmDialog(map.layers, "Do you have quit?", "Quit",
                        JOptionPane.YES_NO_OPTION );
                if (confirmation == JOptionPane.YES_OPTION) {
                    java.lang.System.exit(0);
                }
            }
        });
        map.getSaveHero().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmation = JOptionPane.showConfirmDialog(map.layers, "Do you have save hero?", "Save",
                        JOptionPane.YES_NO_OPTION );
                if (confirmation == JOptionPane.YES_OPTION) {

                    try {
                        Controller.getSave().save(heroes);
                    }
                    catch (ClassNotFoundException sqlEx) {
                        sqlEx.printStackTrace();
                    }
                }
            }
        });
        if (finish == true)
            return 0;
        return 1;
    }

    public void questionBattle() {
        for (int i = 0; i < map.enemies.size(); i++) {
            if (squareX == map.enemies.get(i).getSquareX() && squareY == map.enemies.get(i).getSquareY()) {
                int rand = 0;
                enemy = map.enemies.get(i);
                information_battle = "Enemies: " + enemy.getClassEnemies() + "\nAttack: " + enemy.getAttack() + "\nDefense: " + enemy.getDefense() + "\nHitPoints: " + enemy.getHitPoints();
                if (heroes.getAttack() >= enemy.getAttack()) {
                    battle = JOptionPane.showConfirmDialog(map.layers, information_battle, "Battle or run?",
                            JOptionPane.YES_NO_OPTION);
                    if (battle == JOptionPane.NO_OPTION) {
                        rand = (int)(Math.random()*100);
                    }
                    else
                        rand = 100;
                }
                if (rand < 50) {
                    JOptionPane.showMessageDialog(map.layers, information_battle + "\nYou are weak, ha-ha-ha", "Battle",
                            JOptionPane.ERROR_MESSAGE);
                    battle = JOptionPane.YES_OPTION;
                }
                enemyNum = i;
                break;
            }
        }
    }

    public void questionNextLevel() {
        confirmation = JOptionPane.showConfirmDialog(map.layers, "You go to next level?", "Next",
                JOptionPane.YES_NO_OPTION );
    }

    public void losing() {
        finish = true;
        for (int i = 0; i < map.enemies.size(); i++) {
            map.enemies.get(i).getImages().setVisible(false);
        }
        map.enemies.clear();
        heroes.getImages().setVisible(false);
        map.finishGame("You losing");
    }

    public void nextLevel() {
        for (int i = 0; i < map.enemies.size(); i++) {
            map.enemies.get(i).getImages().setVisible(false);
        }
        map.enemies.clear();
        heroes.getImages().setVisible(false);
        if (heroes.getLevel() <= 7) {
            heroes.setLevel(heroes.getLevel());
            heroes.setLevelGame(heroes.getLevel());
            heroes.Images(true);
            heroes.HitPointsReturn();
            heroesY = heroes.getHeroesY();
            heroesX = heroes.getHeroesX();
            squareX = heroes.getSquareX();
            squareY = heroes.getSquareY();
            map.changeDataMapHero(true);
        }
        else
        {
           map.finishGame("You win.");
        }
    }
}
