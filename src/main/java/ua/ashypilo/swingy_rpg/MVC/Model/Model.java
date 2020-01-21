package ua.ashypilo.swingy_rpg.MVC.Model;

import ua.ashypilo.swingy_rpg.MVC.Controller.Controller;
import ua.ashypilo.swingy_rpg.MVC.View.View;
import ua.ashypilo.swingy_rpg.MVC.Model.Heroes.Cleric;
import ua.ashypilo.swingy_rpg.MVC.Model.Heroes.Heroes;
import ua.ashypilo.swingy_rpg.MVC.Model.Heroes.Warrior;
import ua.ashypilo.swingy_rpg.MVC.Model.Heroes.Wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {

    View view;
    View map;
    Heroes hero;
    String nameHero;
    MoveHero click;
    int level;
    boolean gui;
    ArrayList<String> saveHeroes = new ArrayList<String>();
    String classHero;
    Scanner in;
    SaveHeroes save;

    public Model(boolean gui) {
        if (gui == true) {
            this.gui = true;
            view = new View();
        }
        else
            this.gui = false;
    }

    public void startGameGui() {
        view.mapGame(hero);
    }

    public void startConsoleGame() {
        ConsoleGame console = new ConsoleGame(hero);
        console.Game();
    }

    public void playGame() {
        click = new MoveHero(hero, view.getMap());
        click.click();
    }

    public void createHero(String name, String heroes, boolean gui) {
        nameHero = name;
        if (nameHero.length() > 11)
            nameHero = nameHero.substring(0, 10);
        if (heroes == "Warrior")
            hero = new Warrior(nameHero);
        else if (heroes == "Wizard")
            hero = new Wizard(nameHero);
        else
            hero = new Cleric(nameHero);
        hero.setLevel(1);
        hero.Images(gui);
    }

    public void createDownloadHero(int num, boolean gui){
        save = Controller.getSave();
        if (save.getClassHero().get(num).equals("Warrior"))
            hero = new Warrior(save.getNameHero().get(num));
        else if (save.getClassHero().get(num).equals("Wizard"))
            hero = new Wizard(save.getNameHero().get(num));
        else
            hero = new Cleric(save.getNameHero().get(num));
        hero.setLevel(save.getLevel().get(num));
        hero.setAttackDownload(save.getAttack().get(num));
        hero.setDefenseDownload(save.getDefence().get(num));
        hero.setExperience(save.getExp().get(num));
        hero.setHitPointsDownload(save.getHitPoints().get(num));
        hero.Images(gui);
    }

    public void createConsoleHero() {
        in = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("New game(n) or Continue(c)");
        System.out.println("------------------------------");
        classHero = in.next();
        int i = 0;
        while (i < 2) {
            if (classHero.equals("n") || classHero.equals("c"))
                break;
            i++;
            if (i == 3) {
                System.out.println("Write correct class:" + i);
                classHero = in.next();
                i = 0;
            }
        }
        if (classHero.equals("n")) {
            newGame();
        }
        else {
            save();
        }
    }

    public void newGame() {
        String [] classHeroes = {"Warrior", "Wizard", "Cleric"};
        System.out.println("------------------------------");
        System.out.println("Choose and write class hero:\nWarrior\nWizard\nCleric");
        System.out.println("------------------------------");
        classHero = in.next();
        int i = 0;
        while (i < 3) {
            if (classHeroes[i].equals(classHero))
                break;
            i++;
            if (i == 3) {
                System.out.println("Write correct class:" + i);
                classHero = in.next();
                i = 0;
            }
        }
        System.out.println("Write name hero:");
        nameHero = in.next();
        createHero(nameHero, classHero, false);
    }

    public void save() {
        try {
            Controller.getSave().continueGame();
        }
        catch (ClassNotFoundException sqlEx) {
            sqlEx.printStackTrace();
        }
        save = Controller.getSave();
        if (save.getId() == 0) {
            System.out.println("------------------------------");
            System.out.println("Not save heroes, create hero.");
            System.out.println("------------------------------");
            newGame();
        }
        else {
            saveHeroes = save.getSaveHero();
            for (int i = 0; i < saveHeroes.size(); i++) {
                System.out.println(saveHeroes.get(i));
            }
            saveHeroes = save.getNameHero();
            System.out.println("------------------------------");
            System.out.println("Choose and write name hero");
            System.out.println("------------------------------");
            nameHero = in.next();
            int i = 0;
            while (i < saveHeroes.size()) {
                if (saveHeroes.get(i).equals(nameHero))
                    break;
                i++;
                if (i == 3) {
                    System.out.println("Write correct name:" + i);
                    nameHero = in.next();
                    i = 0;
                }
            }
            saveHeroes = save.getClassHero();
            classHero = saveHeroes.get(i);
            createDownloadHero(i, false);
        }
    }

    public Heroes getHero() {
        return hero;
    }

    public View getView() {
        return view;
    }

    public int getLevel() {
        level = hero.getLevel();
        return level;
    }

    public void consoleGameOfGui() {
        view.getConsoleGame().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.lang.System.exit(0);
            }
        });
    }
}
