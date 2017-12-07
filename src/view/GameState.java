package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Timer;

import circuss.ShapePool;
import circuss.Shelf;
import mvc.model.CircusLogs;
import mvc.model.Clown;
import mvc.model.ClownStack;
import mvc.model.IClown;
import mvc.model.Plate;

public class GameState extends State implements Observer {

    private int level;
    private boolean observe;
    private boolean observed;

    public GameState() {
        observe = false;
        observed = true;
        level = 1;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void excute(final View view) {

        if (observed) {
            for (Clown c : view.getPlates().getPlayers())
                c.addObserver(this);
            observed = false;
        }
        if(!view.isCheck())view.gameStartTime=System.currentTimeMillis();
        if (view.pauseButton.isClicked())

           view.setState(new PauseState());
        if (System.currentTimeMillis() - view.gameStartTime >= 60 * 1000) {
            view.setState(new FinishGame());
        }
        view.getPlates().setTimer(new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < view.getPlates().getShapes().size(); ++i) {
                    Plate shape = view.getPlates().getShapes().get(i);
                    shape = view.getPlates().refactorAShape(i, shape);
                    shape.move();
                    shape.decreaseDelay();
                    for (Clown c : view.getPlates().getPlayers()) {

                        // System.out.println(c.getScore());
                        for (ClownStack s : c.getStacks())
                            if (s.checkShape(shape)) {
                                view.getPlates().getShapes().remove(shape);

                            }

                    }
                    shape.Setlevel(level);

                }

                view.repaint();
                for (int i = view.getPlates().getShapes().size(); i <= ShapePool.getInstance().getOnScreen(); i++) {
                    view.getPlates().getShapes().add(ShapePool.getInstance().getAShape());
                }
                if (view.getPlates().getPlayers().get(0).getScore() > 20 || (view.getPlates().getPlayers().size() > 1
                        && view.getPlates().getPlayers().get(1).getScore() > 20)) {
                    level = 3;

                    observe = true;
                } else if (view.getPlates().getPlayers().get(0).getScore() > 3
                        || (view.getPlates().getPlayers().size() > 3
                                &&view.getPlates().getPlayers().get(1).getScore() > 10)) {
                    level = 2;
                    observe = true;
                }

            }

        }));
        if (!view.isCheck()) {
            view.getPlates().getTimer().start();
            view.setCheck(true);
        }

    }

    @Override
    public void paintState(Graphics g, View view, URL url) {

        g.drawImage(view.getImage(), 0, 0, null);
        for (Shelf shelf : view.getPlates().getShelves()) {
            shelf.drawShelf(g);
        }
        for (Plate shape : view.getPlates().getShapes()) {
            shape.drawShape(g);
        }
        for (IClown c : view.getPlates().getPlayers())
            c.draw(g);

    }

    @Override
    public ArrayList<Button> stateButton(View view) {
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(view.pauseButton);

        return buttons;
    }

    @Override
    public void update(Observable o, Object score) {
        CircusLogs lg =new CircusLogs();
        
        if (score instanceof Integer) {
            lg.loggerHistoryInfo("score change "+Integer.toString((int)score));
            if ((int) score > 20) {
                level = 3;
                observe = true;
            } else if ((int) score > 10 && level < 3) {
                level = 2;
                observe = true;
            }
        }
    }

}
