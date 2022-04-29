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
        int wI = img.getWidth(null);
        System.out.println(wI);
    }

    public void setBackground(Color background){
        bg = background;
    }

    public void setIcon(Image ic){
        img = ic;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(bg);
        g.fillRect(0, 0, getWidth(), getHeight());
        if(img!=null){
            Dimension dim = getPreferredSize();
            int wI = img.getWidth(null);
            int hI = img.getHeight(null);
            System.out.println(dim + " " + wI);
            g.drawImage(img, (dim.width-wI)/2, (dim.height-hI)/2, null);
        }
    }
}
