package ua.ashypilo.swingy_rpg.MVC.Model.MyImages;

import javax.swing.*;
import java.awt.*;

public class ImagesElse extends JPanel {
    public static class StartFon extends ImagesElse {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/start.jpg").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }

    public static class Arena extends ImagesElse {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("../src/main/java/Image/Arena.jpg").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }
}
