package mvc.model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

public interface IClown {
    public void draw(Graphics g);

    /**
     * set the location of the shape
     * 
     * @param location
     */
    public void setLocation(Point location);

    /**
     * 
     * @return location of the shape
     */

    public Point getLocation();

    /**
     * 
     * @param x
     * @param y
     * @return true if the shape contain this point false otherwise
     */

    public boolean contain(int x, int y);
    
    /**
     * move the shape from old location (x2,y1) to new (x2,y2)
     * 
     * @param x1
     * 
     * @param x2
     */
    public void move(int x1,  int x2);
    
    
    public void moveLeft(int x);
    
    
    public void moveRight(int x);
    
    
    public List<ClownStack> getStacks() ; 
    public int getScore();
    
}
