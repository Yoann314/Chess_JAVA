package echecFrPl;

import javax.swing.*;
import java.awt.*;

public class MonBouton extends JButton {
    private Color bg;
    Image img;

    public MonBouton() {
        super();
        img = null;
    }
    
    public MonBouton(Image i) {
        super();
        img = i;
    }

    public void setBackground(Color background){
        bg = background;
    }

    public void setIcon(Image ic){
        this.img = ic;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(bg);
        g.fillRect(0, 0, getWidth(), getHeight());
        if(img!=null)
            g.drawImage(img, 0, 0, null);
    }
}
