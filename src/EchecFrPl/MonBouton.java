package EchecFrPl;

import javax.swing.*;
import java.awt.*;

public class MonBouton extends JButton {
    private Color bg;
    Image img;

    public MonBouton(Image i) {
        super();
        img = i;
    }

    public void setBackground(Color background){
        bg = background;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(bg);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(img, 0, 0, null);
    }
}
