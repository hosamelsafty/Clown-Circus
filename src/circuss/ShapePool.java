package circuss;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

import mvc.model.Plate;

public class ShapePool {

    private static ShapePool instance = null;

    private ShapePool() {
        super();
        initialize();
    }

    public static ShapePool getInstance() {
        if (instance == null) {
            instance = new ShapePool();
        }
        return instance;
    }

    private final int onScreen = 20;

    public int getOnScreen() {
        return onScreen;
    }

    private int allObj = 100;
    boolean delay = true;

    Queue<Plate> pool;

    private void initialize() {
     //   ArrayList<String> names = ImageFile.getInstance().getNames();
     //   Random random = new Random();
       // String name = new String();
        pool = new LinkedList<>();
        for (int i = 0; i < allObj; i++) {
            if (delay && i >= onScreen) {
                delay = false;
            }
         //   name = new String(names.get(random.nextInt(names.size())));
           // Image image = ShapeFlyweight.getInstance().getImage(name);
            pool.add(ShapeCreator.getInstance().getShape(i,ShapePosition.getInstance().getPosition(i), delay));
        }
    }

    public Plate getAShape() {
        return pool.poll();
    }

    public void addToPool(Plate shape) {
        if (allObj%2==0) {
            shape.edit(false);
        }else {
            shape.edit(true);
        }
        Point point = new Point();
        point = ShapePosition.getInstance().getPosition(allObj++);
        shape.setX((int) point.getX());
        shape.setY((int) point.getY());
        shape.down = false;
        pool.add(shape);
    }
}