package mvc.model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.awt.Point;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Clown extends Observable implements IClown {

    Image clownImage;
    /**
     * location of the shape
     */
    private Point location;
    /**
     * Dimensions of the shape
     */
    private Dimension dimensions;
    private int score;
    private List<ClownStack>stacks ;
    private int maxX,minX ; 

    /**
     * shape color default is black
     */
    public Clown() {
        // TODO AddStacksLocation         
        try {
            clownImage = ImageIO.read(getClass().getResource("/resources/clownImage1.png"));
        } catch (IOException e) {
           
            throw new RuntimeException("photo of clown not found");
        }
        
        location = new Point(400,600 );
        intialize(); 
        
    }

    public Clown(int player) {
        switch (player) {
        case 1:
            try {
                clownImage = ImageIO.read(getClass().getResource("/resources/clownImage1.png"));
            } catch (IOException e) {
                throw new RuntimeException("photo of clown not found");
            }
            location = new Point(400,500 );
            break;
        case 2:
            try {
                clownImage = ImageIO.read(getClass().getResource("/resources/clownImage2.png"));
            } catch (IOException e) {
                throw new RuntimeException("photo of clown not found");
            }
            location = new Point(800,500 );
            break;

        default:
            break;
        }
        intialize();
    }

    private void  intialize() {
        dimensions = new Dimension(clownImage.getWidth(null), clownImage.getHeight(null));
        score = 0;
        //this and all dimantions will be change to be valid to any fram
        maxX =1365-(int )dimensions.getWidth();
        minX =0 ;
        
        stacks=new ArrayList<>();
        stacks.add(new ClownStack(location.x+20,location.y, this));
        stacks.add(new ClownStack(location.x+clownImage.getWidth(null)-20,location.y, this));
           
    }
    @Override
    public void draw(Graphics g) {

        g.drawImage(clownImage, location.x, location.y, null);
        for(ClownStack s :stacks)
            s.draw(g);
    }

    @Override
    public boolean contain(int x, int y) {
        if (x >= location.x && x <= (location.x + dimensions.width) && y >= location.y
                && y <= (location.y + dimensions.height)) {
            return true;
        }
        return false;
    }

    @Override
    public void setLocation(Point location) {
        this.location = location;
        checkLocation();
    }

   
   
    @Override
    public void moveRight(int x) {
        
        location.x +=x;
        for(ClownStack s :stacks)
            s.moveHorizontal(x);
        
        checkLocation();
    }

    @Override
    public void moveLeft(int x) {
         location.x -=x;
         
         for(ClownStack s :stacks)
             s.moveHorizontal(-x);
         
         checkLocation();
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public void move(int x1, int x2) {
        location.x += x2 - x1;
        for(ClownStack s : stacks)
            s.moveHorizontal(x2-x1);
        checkLocation();
    }

    public void setScore(int newScore) {
        this.score = newScore;
        setChanged();
        //notifyAll();
    }

    public int getScore() {
        return score;
        
        
    }

    @Override
    public List<ClownStack> getStacks() {
        return stacks ;
        
    }
    private void  checkLocation() {
        if (location.x>maxX)
            move(location.x,maxX);
        if(location.x<minX)
            move(location.x,minX);
        
    }

}
