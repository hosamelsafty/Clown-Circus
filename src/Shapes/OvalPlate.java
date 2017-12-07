package Shapes;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

import mvc.model.Plate;

public class OvalPlate extends Plate{
    String path;
   
    public OvalPlate(int x, int y, int delayedStart, boolean isLower) {
        super(x, y, delayedStart, isLower);
        
        SelectRandomImage();
    }

    
    public String SelectRandomImage() {
        path=new String();
        this.color = new Random().nextInt(3);
        try{
        switch (color) {
       
        case 0:
            this.image=ImageIO.read(getClass().getResource("/Image/redoval50-25.png"));
            path="Image/redoval50-25.png" ;
            break;
        case 1:
            this.image=ImageIO.read(getClass().getResource("/Image/greenoval50-25.png"));
            path="Image/greenoval50-25.png" ;
            break;
        case 2:
            this.image=ImageIO.read(getClass().getResource("/Image/blueoval50-25.png"));
            path="Image/blueoval50-25.png" ;
            break;

        default:
            path="Image/blueoval50-25.png" ;
            break;
        }
        } catch (IOException e){e.printStackTrace();} ;
        return path;

    }

   

    @Override
    public void draw(Graphics g) {
        g.drawImage(image,position.x, position.y, width, height, null);
       // g.drawOval(position.x, position.y, width, height);
        
    }



}