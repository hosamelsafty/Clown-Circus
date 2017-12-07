package circuss;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Shelf{

    int x;
    int y;
    int width;
    int height;
    
    public Shelf(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void drawShelf(Graphics g) {
//        g.setColor(Color.WHITE);
        g.drawImage(new ImageIcon(this.getClass().getResource("/components/shelf.JPG")).getImage(), x, y,width,height, null);
//        g.fillRoundRect(x, y, width, height, 20, 20);
    }
}
