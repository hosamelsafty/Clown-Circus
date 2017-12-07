package mvc.model;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.Random;

import Shapes.State;

public abstract class Plate {
    private int delayedStart;
    private StratgyIF level,level1,level2,level3 ;    
    public int maxLeftX;
    public int minRightX;
    private int MaxX,maxY;             
    boolean draw = false;
    public boolean down = false;    
    protected State state;
    protected int color;
    protected int height, width;
    protected Point position;
    protected int x, y;
    protected Image image;

    
  

    public Plate(int x, int y, int delayedStart, boolean isLower) {
        this.x = x;
        this.y = y;
        
        height=width=40;
        this.delayedStart = delayedStart;
        edit(isLower);
        level1=new Level1(this, maxLeftX, minRightX);
        level2=new Level2(this, maxLeftX, minRightX);
        level3=new Level3(this, maxLeftX, minRightX);
        level=level1;
        
    }

    public void Setlevel(int x) {
        if (x==1){
            level =level1;
        }
        if (x==2){
            level =level2;
        }
        if(x==3){            
            level=level3;
        }
    }
    
    
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

     public void move(int Dx,int Dy) {
     this.position.x+=Dx;
     this.position.y += Dy;
    
     }
    public void move() {
        level.move();
    }

    public void edit(boolean isLower) {
        if (isLower) {
            maxLeftX = 300;
            minRightX = 1020;
            
        } else {
            maxLeftX = 600;
            minRightX = 720;
        }
    }

    public void drawShape(Graphics g) {
        if (draw) {
            ImageObserver imageObserver = null;
            g.drawImage(image, x, y - 10, 40, 40, imageObserver);
        }
    }

    public void decreaseDelay() {
        if (delayedStart <= 0) {
            draw = true;
        } else {
            delayedStart -= 1;
        }
    }
    public abstract String SelectRandomImage();

    public abstract void draw(Graphics g);

   
}