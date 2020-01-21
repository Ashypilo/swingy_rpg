package ua.ashypilo.swingy_rpg.MVC.Model.MyImages;

import javax.swing.*;
import java.awt.*;

public class ImagesZombie extends ImagesEnemies {

    public static class Level1 extends ImagesZombie {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Zombie/zombie1.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level2 extends ImagesZombie {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Zombie/zombie2.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level3 extends ImagesZombie {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Zombie/zombie3.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level4 extends ImagesZombie {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Zombie/zombie4.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level5 extends ImagesZombie {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Zombie/zombie5.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level6 extends ImagesZombie {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Zombie/zombie6.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level7 extends ImagesZombie {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Zombie/zombie7.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }
}
