package circuss;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import mvc.model.Clown;
import mvc.model.IClown;
import mvc.model.Plate;
import view.View;

public class Plates extends JPanel {


    private static final int D_WIDTH = 1450;
    private static final int INCREMENT = 2;
    private static final int maxHeight = 800;
    private Timer timer = null;
    View view=new View();
    // we will treat with pool directly after achieving state pattern.
    private List<Plate> shapes;
    private List<Shelf> shelves;

    private Image image;
//---------------------------------------------------------
    /**
     * @author said
     */
    public List<Clown> players;

    public List<Clown> getPlayers() {
        return players;
    }

    public void inti(int i) {
        switch (i) {
        case 1:
            players.add(new Clown());
            break;
        case 2:
            players.add(new Clown(1));
            players.add(new Clown(2));
            break;

        default:
            break;
        }

    }

    public void setPlayers(List<Clown> players) {
        this.players = players;
    }
  //----------------------------------------------------
    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public List<Plate> getShapes() {
        return shapes;
    }

    public void setShapes(List<Plate> shapes) {
        this.shapes = shapes;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public static int getdWidth() {
        return D_WIDTH;
    }

    public static int getIncrement() {
        return INCREMENT;
    }

    public Plates() {
        players = new ArrayList<>();
        initialize();
       // speedOfPlates();
        JPanel panel = new JPanel();
        setLayout(new BorderLayout());
        add(panel, BorderLayout.PAGE_START);
    }

    private void initialize() {
        image = new ImageIcon(
                this.getClass().getResource("/components/stage.jpg"))
                        .getImage();
        ArrayList<Plate> shapesList = new ArrayList<>();
        for (int i = 0; i < ShapePool.getInstance().getOnScreen(); i++) {
            shapesList.add(ShapePool.getInstance().getAShape());
        }
        setShapes(shapesList);
        int upperY = 80, lowerY = 180;
        int upperLeftX = 600, lowerLeftX = 300, upperRightX = 760,
                lowerRightX = 1060;
        setShelves(ShelfCreator.getInstance().createShelvesList(upperY,
                lowerY, upperLeftX, lowerLeftX, upperRightX, lowerRightX));
    }

    public Plate refactorAShape(int i,Plate shape){
        if(shape.getY()>maxHeight){
            ShapePool.getInstance().addToPool(shape);

            shapes.remove(shape);
        }
        return shape;
    }
}
