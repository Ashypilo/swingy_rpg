package ua.ashypilo.swingy_rpg.MVC.Model.MyImages;

import javax.swing.*;
import java.awt.*;

public class ImagesWarrior extends ImagesHeroes {

    public static class Hero extends ImagesWarrior {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Warrior/warrior.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level1 extends ImagesWarrior {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Warrior/warrior1.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level2 extends ImagesWarrior {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Warrior/warrior2.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level3 extends ImagesWarrior {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Warrior/warrior3.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level4 extends ImagesWarrior {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Warrior/warrior4.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level5 extends ImagesWarrior {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Warrior/warrior5.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level6 extends ImagesWarrior {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Warrior/warrior6.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level7 extends ImagesWarrior {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Warrior/warrior7.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }
}
