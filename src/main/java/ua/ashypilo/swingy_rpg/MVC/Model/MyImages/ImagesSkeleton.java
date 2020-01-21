package ua.ashypilo.swingy_rpg.MVC.Model.MyImages;

import javax.swing.*;
import java.awt.*;

public class ImagesSkeleton extends ImagesEnemies {

    public static class Level1 extends ImagesSkeleton {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Skeleton/skeleton1.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level2 extends ImagesSkeleton {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Skeleton/skeleton2.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level3 extends ImagesSkeleton {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Skeleton/skeleton3.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level4 extends ImagesSkeleton {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Skeleton/skeleton4.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level5 extends ImagesSkeleton {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Skeleton/skeleton5.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level6 extends ImagesSkeleton {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Skeleton/skeleton6.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level7 extends ImagesSkeleton {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Skeleton/skeleton7.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }
}
