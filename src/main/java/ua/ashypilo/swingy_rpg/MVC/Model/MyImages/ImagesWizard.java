package ua.ashypilo.swingy_rpg.MVC.Model.MyImages;

import javax.swing.*;
import java.awt.*;

public class ImagesWizard extends ImagesHeroes {
    public static class Hero extends ImagesWizard {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Wizard/wizard.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level1 extends ImagesWizard {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Wizard/wizard1.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level2 extends ImagesWizard {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Wizard/wizard2.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level3 extends ImagesWizard {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Wizard/wizard3.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level4 extends ImagesWizard {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Wizard/wizard4.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level5 extends ImagesWizard {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Wizard/wizard5.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level6 extends ImagesWizard {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Wizard/wizard6.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Level7 extends ImagesWizard {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Wizard/wizard7.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

}
