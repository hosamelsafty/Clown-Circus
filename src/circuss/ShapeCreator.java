package circuss;


import java.awt.Point;
import Shapes.OvalPlate;
import mvc.model.Plate;

public class ShapeCreator {

    private ShapeCreator() {

    }

    private static ShapeCreator istance;

    public static ShapeCreator getInstance() {
        if (istance == null) {
            istance = new ShapeCreator();
        }
        return istance;
    }

    int delay = 0;
    final int increment = 8;

    public Plate getShape(int shapeNum, Point pos, boolean delayFlag) {
        
        int randomDelayedStart;
        if (!delayFlag) {
            randomDelayedStart = -1;
        } else {
            randomDelayedStart = shapeNum * increment;
        }

        if (shapeNum % 2 == 0) {
            return new OvalPlate((int) pos.getX(), (int) pos.getY(), randomDelayedStart, false);
        } else {
            return new OvalPlate((int) pos.getX(), (int) pos.getY(), randomDelayedStart, true);
        }
    }
}
