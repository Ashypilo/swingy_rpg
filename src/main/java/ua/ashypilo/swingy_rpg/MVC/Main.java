package ua.ashypilo.swingy_rpg.MVC;

import ua.ashypilo.swingy_rpg.MVC.Controller.Controller;

import java.lang.*;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args){

        try {
            if (args[0].equals("gui")) {
                Controller Game = new Controller(true);
                Game.createNewGame();

            }
            else if (args[0].equals("console")) {
                Controller Game = new Controller(false);
                Game.createNewGame();

            }
            else {
                System.out.println("Write: \n'gui' - for start gui game.\n'console' - for start console game.");
            }
        }
        catch (NoSuchElementException e) {
            e.fillInStackTrace();
        }
        catch (Exception e) {
            System.out.println("Write: \n'gui' - for start gui game.\n'console' - for start console game.");
        }
    }
}
