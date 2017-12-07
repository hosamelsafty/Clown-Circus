package circuss;

import java.util.ArrayList;
import java.util.List;

public class ShelfCreator {
    
    private static ShelfCreator istance;

    public static ShelfCreator getInstance() {
        if (istance == null) {
            istance = new ShelfCreator();
        }
        return istance;
    }
    
    public List<Shelf> createShelvesList(int yUp, int yDown,
            int maxLeftXUp, int maxLeftXDown, int maxRightXUp,
            int maxRightXDown) {
        int shifting = 50;
        int height = 15;
        List<Shelf> shelves = new ArrayList<>();
        shelves.add(
                new Shelf(-shifting, yUp, maxLeftXUp + shifting, height));
        shelves.add(new Shelf(-shifting, yDown, maxLeftXDown + shifting,
                height));
        shelves.add(new Shelf(maxRightXUp, yUp, 1450 - maxRightXUp,
                height));
        shelves.add(new Shelf(maxRightXDown, yDown,
                1450 - maxRightXDown, height));
        return shelves;
    }
}
