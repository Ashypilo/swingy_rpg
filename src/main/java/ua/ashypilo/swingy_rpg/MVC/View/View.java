package ua.ashypilo.swingy_rpg.MVC.View;

import ua.ashypilo.swingy_rpg.MVC.Controller.Controller;
import ua.ashypilo.swingy_rpg.MVC.Model.Heroes.Heroes;
import ua.ashypilo.swingy_rpg.MVC.Model.MyImages.ImagesElse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame {
    public JFrame panel;
    public JLayeredPane layers;
    ImagesElse.StartFon fon;
    JButton newGame;
    JButton continueGame;
    JTextField nameWarrior;
    JTextField nameWizard;
    JTextField nameCleric;
    JButton Warrior;
    JButton Wizard;
    JButton Cleric;
    JButton Game;
    JButton consoleGame;
    JButton saveHero;
    JButton quit;
    Font font;
    MapGame map;
    boolean finish;

    JButton download;
    ArrayList<Button> radio = new ArrayList<Button>();
    ArrayList<String> save = new ArrayList<String>();

    public View(){
        panel = new JFrame("Swingy RPG");
        layers = panel.getLayeredPane();
        fon = new ImagesElse.StartFon();
        newGame = new JButton("New Game");
        Game = new JButton("Start Game");
        continueGame = new JButton("Continue");
        fon.setBounds(0, 0, 800, 600);
        newGame.setBounds(200, 270, 100, 50);
        Game.setBounds(350, 50, 100, 50);
        continueGame.setBounds(500, 270, 100, 50);
        layers.add(fon, JLayeredPane.DEFAULT_LAYER);
        layers.add(newGame, JLayeredPane.PALETTE_LAYER);
        layers.add(Game, JLayeredPane.PALETTE_LAYER);
        layers.add(continueGame, JLayeredPane.PALETTE_LAYER);
        Game.setVisible(false);
        panel.setSize(800, 600);
        panel.setVisible(true);
        panel.setResizable(false);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (Controller.getSave().getId() == 0)
            continueGame.setEnabled(false);
        else
            continueGame.setEnabled(true);
    }

    public void outHeroesMap() {
        newGame.setVisible(false);
        continueGame.setVisible(false);
        nameWarrior = new JTextField("Write Name");
        nameWizard = new JTextField("Write Name");
        nameCleric = new JTextField("Write Name");
        Warrior = new JButton("Create Warrior");
        Wizard = new JButton("Create Wizard");
        Cleric = new JButton("Create Cleric");
        font = new Font("Verdana", Font.ITALIC, 13);

        nameWarrior.setBounds(100, 430, 100, 20);
        nameWarrior.getText();
        nameWizard.setBounds(350, 430, 100, 20);
        nameWizard.getText();
        nameCleric.setBounds(600, 430, 100, 20);
        nameCleric.getText();
        Warrior.setBounds(100, 500, 100, 50);
        Wizard.setBounds(350, 500, 100, 50);
        Cleric.setBounds(600, 500, 100, 50);

        layers.add(Warrior, JLayeredPane.PALETTE_LAYER);
        layers.add(Wizard, JLayeredPane.PALETTE_LAYER);
        layers.add(Cleric, JLayeredPane.PALETTE_LAYER);
        layers.add(nameWarrior, JLayeredPane.PALETTE_LAYER);
        layers.add(nameWizard, JLayeredPane.PALETTE_LAYER);
        layers.add(nameCleric, JLayeredPane.PALETTE_LAYER);
        Warrior.setEnabled(false);
        Wizard.setEnabled(false);
        Cleric.setEnabled(false);
    }

    public void outContinueHero() {
        newGame.setVisible(false);
        continueGame.setVisible(false);
        try {
            Controller.getSave().continueGame();
        }
        catch (ClassNotFoundException sqlEx) {
            sqlEx.printStackTrace();
        }
        download = new JButton("Download");
        layers.add(download,JLayeredPane.PALETTE_LAYER);
        download.setEnabled(false);
        save = Controller.getSave().getSaveHero();
        int y = 30;
        for (int i = 0; i < save.size(); i++) {
            radio.add(new Button(save.get(i)));
            radio.get(i).setBounds(275,y, 250,20);
            layers.add(radio.get(i),JLayeredPane.POPUP_LAYER);
            y += 30;
        }
        download.setBounds(350,y,100,20);
        for (int i = 0; i < radio.size(); i++) {
            final int fi = i;
            radio.get(fi).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    download.setEnabled(true);
                    for(int j = 0; j < radio.size(); j++) {
                        if (j != fi)
                            radio.get(j).setVisible(false);
                    }
                    download(fi);
                }
            });
        }
    }

    public void download(int i) {
        final int k = i;
        download.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.setVisible(true);
                Controller.download(k);
            }
        });
    }

    public void notVisibleElseNameHeroes(JButton hero) {
        nameWarrior.setEnabled(false);
        nameWizard.setEnabled(false);
        nameCleric.setEnabled(false);
        hero.setEnabled(true);
    }

    public void notVisibleElseHeroes() {
        Warrior.setVisible(false);
        Wizard.setVisible(false);
        Cleric.setVisible(false);
        nameWizard.setVisible(false);
        nameCleric.setVisible(false);
        nameWarrior.setVisible(false);
        Game.setVisible(true);
    }

    public void mapGame(Heroes heroes) {
        panel.setVisible(false);
        map = new MapGame(heroes, true);
    }

    public void NewGame(String str) {
        int newGame = JOptionPane.showConfirmDialog(layers, "New Game?", str,
                JOptionPane.YES_NO_OPTION);
        if (newGame == JOptionPane.NO_OPTION || newGame == JOptionPane.CLOSED_OPTION) {
            java.lang.System.exit(0);
        }
        else {
           Controller.createNewGame();
           panel.setVisible(false);
        }
    }

    public boolean getFinish() {
        return finish;
    }

    public View getView() {
        return this;
    }

    public JFrame getPanel() {
        return panel;
    }

    public JLayeredPane getLayers() {
        return layers;
    }

    public ImagesElse.StartFon getFon() {
        return fon;
    }

    public JButton getNewGame() {
        return newGame;
    }

    public JButton getContinueGame() {
        return continueGame;
    }

    public JButton getWarrior() {
        return Warrior;
    }

    public JButton getWizard() {
        return Wizard;
    }

    public JButton getCleric() {
        return Cleric;
    }

    public JButton getGame() { return Game; }

    public JTextField getNameWarrior() {
        return nameWarrior;
    }

    public JTextField getNameWizard() {
        return nameWizard;
    }

    public JTextField getNameCleric() {
        return nameCleric;
    }

    public MapGame getMap() {
        return map;
    }

    public JButton getConsoleGame() {
        return consoleGame;
    }

    public JButton getSaveHero() {
        return saveHero;
    }

    public JButton getQuit() {
        return quit;
    }

}
