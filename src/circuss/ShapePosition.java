package circuss;

import java.awt.Point;

import javax.management.RuntimeErrorException;

public class ShapePosition {
    
    private ShapePosition(){
        
    }
    
    private static ShapePosition instance;
    
    public static ShapePosition getInstance(){
        if(instance==null){
            instance = new ShapePosition();
        }
        return instance;
    }
        
    private final int leftX = -50;
    private final int rightX = 1350;
    private final int upY = 50;
    private final int downY = 150;
    
    public Point getPosition(int shapeTurn){
        if (shapeTurn % 2 == 0) {
            if (shapeTurn % 4 == 0) {
                return new Point(leftX, upY);
            } else if (shapeTurn % 4 == 2) {
                return new Point(rightX, upY);
            }
        } else {
            if (shapeTurn % 4 == 1) {
                return new Point(rightX, downY);
            } else if (shapeTurn % 4 == 3) {
                return new Point(leftX, downY);
            }
        }
        throw new RuntimeErrorException(null);
    }
}
