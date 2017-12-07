package view;

import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;

public class PlayerMenu extends State {

    @Override
    public void excute(View view) {
        while (view.getState().equals(this)) {
            view.setSize(view.getWidth(), view.getHeight());

            view.playersMenuButtons();

            if (view.onePlayerButton.isClicked()) {
                view.initialize(1);
                view.setState(new GameState());
            } else if (view.twoPlayersButton.isClicked()) {
                view.initialize(2);
                view.setState(new GameState());
            } else if (view.mainMenuButton.isClicked()) {
                view.setState(new StartMenu());
                view.init();
            }
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            view.repaint();
        }
    }

    @Override
    public void paintState(Graphics g, View view, URL url) {
        g.drawImage(view.backMenu, 0, 0, view.getWidth(), view.getHeight(), view);
        if (view.onePlayerButton.getY() != 0) {
            view.onePlayerButton.paint(g, view, url);
            view. twoPlayersButton.paint(g, view, url);
            view. mainMenuButton.paint(g, view, url);
        }
    }

    @Override
    public ArrayList<Button> stateButton(View view) {
        ArrayList<Button> buttons=new ArrayList<>();
        buttons.add(view.onePlayerButton);
        buttons.add(view.twoPlayersButton);
        buttons.add(view.mainMenuButton);


        return buttons;
    }

}
