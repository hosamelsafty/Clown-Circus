package mvc.model;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import Shapes.Ball;
import Shapes.OvalPlate;

import java.awt.Point;

public class ClownStack {
    private Point location, oldLocation;
    private List<Plate> plates;
    private Clown ownClown;

    public ClownStack(int x, int y, Clown cl) {
        location = new Point(x, y);
        oldLocation = new Point(x, y);
        plates = new ArrayList<>();
        ownClown = cl;
        //just for test 
        
    }

    public Point getLocation() {
        return location;
    }

    public void draw(Graphics g) {
        // g.drawLine(location.x, location.y, location.x, location.y-50);
        for (Plate p : plates)
            p.draw(g);
    }

    public void addShape(Plate plate) {
        plates.add(plate);
        location.y -= plate.getHeight();
        plate.setPosition(new Point(location.x - (plate.getWidth() / 2), location.y));
         checkMatch();
    }

    private void checkMatch() {
        if (plates.size() >= 3 && plates.get(plates.size() - 1).getColor() == plates.get(plates.size() - 2).getColor())
            if (plates.get(plates.size() - 1).getColor() == plates.get(plates.size() - 3).getColor()) {
                ownClown.setScore(ownClown.getScore() + 1);
                for (int i = 0; i < 3; i++) {
                    location.y += plates.get(plates.size()-1).getHeight();
                    circuss.ShapePool.getInstance().addToPool(plates.get(plates.size()-1));
                    plates.remove(plates.size() - 1);
                    
                }
            }
    }

    public void moveHorizontal(int x) {
        location.x += x;
        oldLocation.x += x;
        for (Plate p : plates)
            p.move(x, 0);
    }
    public boolean checkShape(Plate p) {
        int dy =location.y-p.getY() ;
        int dx =location.x-p.getX();
        if(dy>0&&dy<p.getHeight()&&dx>0&&dx<p.getWidth()){
            addShape(p);
            return true ;
        }
        return false ;
        
    }

}