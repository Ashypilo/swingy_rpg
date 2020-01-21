package ua.ashypilo.swingy_rpg.MVC.View;

import ua.ashypilo.swingy_rpg.MVC.Model.Enemies.CreateEnemies;
import ua.ashypilo.swingy_rpg.MVC.Model.Enemies.Enemies;
import ua.ashypilo.swingy_rpg.MVC.Model.Heroes.Heroes;
import ua.ashypilo.swingy_rpg.MVC.Model.MyImages.ImagesElse;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class MapGame extends View {
    ImagesElse.Arena arena;
    public ArrayList<Enemies> enemies = new ArrayList<Enemies>();
    JLabel labellevelGame;
    JLabel levelGame;
    Font fontBiglabel;
    CreateEnemies createEnemies;
    public JFrame panel;
    public JLayeredPane layers;
    public JButton north;
    public JButton south;
    public JButton west;
    public JButton east;
    Heroes heroes;
    DataHero dataHero;
    public MySquare square;
    MyMap map;
    String str;

    public MapGame(Heroes heroes, boolean gui) {
        this.heroes = heroes;
        square = new MySquare(this.heroes);
        map = new MyMap(this.heroes);
        consoleGame = new JButton("Console game");
        saveHero = new JButton("Save hero");
        quit = new JButton("Quit");
        panel = super.panel;
        layers = super.layers;
        super.newGame.setVisible(false);
        super.continueGame.setVisible(false);
        super.fon.setVisible(false);
        north = new JButton("North");
        south = new JButton("South");
        west = new JButton("West");
        east = new JButton("East");
        arena = new ImagesElse.Arena();
        dataHero = new DataHero(this);
        labellevelGame = new JLabel("Level");
        str = String.valueOf(heroes.getLevel());
        levelGame = new JLabel(str);
        fontBiglabel = new Font("Verdana", Font.BOLD, 23);
        labellevelGame.setFont(fontBiglabel);
        levelGame.setFont(fontBiglabel);
        panel.setSize(1800, 1340);
        panel.setVisible(true);
        panel.setResizable(false);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addImages();
        if (gui)
            changeDataMapHero(gui);
    }

    public void addImages() {
        dataHero.addInformationHeroes();
        labellevelGame.setBounds(900, 1210, 100, 25);
        levelGame.setBounds(925, 1250, 50, 25);
        quit.setBounds(10, 10, 100, 20);
        saveHero.setBounds(10,40,100,20);
        consoleGame.setBounds(10,70,100,20);
        arena.setBounds(0, 0, 1800, 1340);
        north.setBounds(1530, 635, 60, 40);
        south.setBounds(1530, 735, 60, 40);
        west.setBounds(1460, 685, 60, 40);
        east.setBounds(1595, 685, 60, 40);
        layers.add(arena, JLayeredPane.DEFAULT_LAYER);
        layers.add(levelGame, JLayeredPane.DRAG_LAYER);
        layers.add(labellevelGame, JLayeredPane.DRAG_LAYER);
        layers.add(north, JLayeredPane.PALETTE_LAYER);
        layers.add(south, JLayeredPane.PALETTE_LAYER);
        layers.add(west, JLayeredPane.PALETTE_LAYER);
        layers.add(east, JLayeredPane.PALETTE_LAYER);
        layers.add(saveHero, JLayeredPane.PALETTE_LAYER);
        layers.add(quit, JLayeredPane.PALETTE_LAYER);
        layers.add(consoleGame, JLayeredPane.PALETTE_LAYER);
    }

    public void changeDataMapHero(boolean gui) {
        heroes.setLevelGame(heroes.getLevel());
        str = String.valueOf(heroes.getLevelGame());
        levelGame.setText(str);
        map.setBounds(420, 200, 1001, 1001);
        layers.add(map, JLayeredPane.MODAL_LAYER);
        square.setBounds(420, 200, 1001, 1001);
        layers.add(square, JLayeredPane.POPUP_LAYER);
        heroes.getImages().setBounds(heroes.getHeroesX(), heroes.getHeroesY(), 70, 135);
        layers.add(heroes.getImages(), JLayeredPane.DRAG_LAYER);
        DataHero.changeHitPoints();
        if (gui) {
            createEnemies = new CreateEnemies(heroes.getLevel(), layers, enemies);
            enemies = createEnemies.Create(true);
        }
        else {
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).setLayers(layers);
                enemies.get(i).addEnemies();
            }
        }
    }

    static class MyMap extends JComponent {
        public Heroes heroes;

        public MyMap(Heroes heroes) {
                this.heroes = heroes;
            }
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                Line2D l1 = new Line2D.Double(1, 1, 1, heroes.getSizeSquare());
                Line2D l2 = new Line2D.Double(heroes.getSizeSquare(), 1, heroes.getSizeSquare(), heroes.getSizeSquare());
                Line2D l3 = new Line2D.Double(1, 1, heroes.getSizeSquare(), 1);
                Line2D l4 = new Line2D.Double(1, heroes.getSizeSquare(), heroes.getSizeSquare(), heroes.getSizeSquare());
                g2.draw(l1);
                g2.draw(l2);
                g2.draw(l3);
                g2.draw(l4);
        }
    }

    static class MySquare extends JComponent {
        public Heroes heroes;

        public MySquare(Heroes heroes) {
                this.heroes = heroes;
            }
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                double square = heroes.getMove();
                double move = heroes.getMove();
                while (square <= (heroes.getSizeSquare() - move)) {
                    Line2D horizon = new Line2D.Double(square, 1, square, heroes.getSizeSquare());
                    Line2D vertical = new Line2D.Double(1, square, heroes.getSizeSquare(), square);
                    g2.draw(horizon);
                    g2.draw(vertical);
                    square += move;
                }
        }
    }

    public void finishGame(String str) {
        square.setVisible(false);
        map.setVisible(false);
        levelGame.setVisible(false);
        labellevelGame.setVisible(false);
        Font font = new Font("Verdana",Font.BOLD, 30);
        JLabel win = new JLabel(str);
        win.setFont(font);
        win.setBounds(800,500,300,50);
        layers.add(win, JLayeredPane.DRAG_LAYER);
        super.NewGame(str);
    }

        public void setEnemies(ArrayList<Enemies> enemies) {
            this.enemies = new ArrayList<Enemies>(enemies);
        }
    }
