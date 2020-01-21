package ua.ashypilo.swingy_rpg.MVC.Controller;

import ua.ashypilo.swingy_rpg.MVC.Model.Model;
import ua.ashypilo.swingy_rpg.MVC.Model.SaveHeroes;
import ua.ashypilo.swingy_rpg.MVC.View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    static View view;
    static Model model;
    static boolean gui;
    static SaveHeroes save;

    public Controller(boolean gui) {
        save = new SaveHeroes();
        if (gui == true)
            this.gui = true;
        else
            this.gui = false;
    }

    public static void startGame() {
        model.startGameGui();
        model.playGame();
    }

    public static void createNewGame() {
        if (gui == true) {
            model = new Model(true);
            view = model.getView();
            click();
        }
        else {
            model = new Model(false);
            model.createConsoleHero();
            model.startConsoleGame();
        }
    }


    public static void download(int num) {
        model.createDownloadHero(num, true);
            startGame();
    }

    public static void click() {
        view.getNewGame().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.outHeroesMap();
                clickHeroes();
                }
            });
        view.getContinueGame().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.outContinueHero();
                }
            });
    }

    public static void clickHeroes() {
        view.getNameWarrior().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.notVisibleElseNameHeroes(view.getWarrior());
                clickCreateHeroes();
            }
        });

        view.getNameWizard().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.notVisibleElseNameHeroes(view.getWizard());
                clickCreateHeroes();
            }
        });

        view.getNameCleric().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.notVisibleElseNameHeroes(view.getCleric());
                clickCreateHeroes();
            }
        });
    }

    public static void clickCreateHeroes() {
        view.getWarrior().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.notVisibleElseHeroes();
                model.createHero(view.getNameWarrior().getText(),"Warrior", true);
                clickStartGame();
            }
        });

        view.getWizard().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.notVisibleElseHeroes();
                model.createHero(view.getNameWizard().getText(),"Wizard", true);
                clickStartGame();
            }
        });

        view.getCleric().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.notVisibleElseHeroes();
                model.createHero(view.getNameCleric().getText(),"Cleric", true);
                clickStartGame();
            }
        });
    }

    public static void clickStartGame() {
        view.getGame().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
    }

    public boolean getGui() {
        return gui;
    }

    public static SaveHeroes getSave() {
        return save;
    }


}
