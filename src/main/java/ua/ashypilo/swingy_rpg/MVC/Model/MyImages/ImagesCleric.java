package ua.ashypilo.swingy_rpg.MVC.Model.MyImages;

import javax.swing.*;
import java.awt.*;

public class ImagesCleric extends ImagesHeroes {

    public static class Hero extends ImagesCleric {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Cleric/cleric.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level1 extends ImagesCleric {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Cleric/cleric1.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }
    public static class Level2 extends ImagesCleric {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Cleric/cleric2.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level3 extends ImagesCleric {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Cleric/cleric3.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level4 extends ImagesCleric {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Cleric/cleric4.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level5 extends ImagesCleric {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Cleric/cleric5.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level6 extends ImagesCleric {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Cleric/cleric6.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level7 extends ImagesCleric {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Cleric/cleric7.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }
}
