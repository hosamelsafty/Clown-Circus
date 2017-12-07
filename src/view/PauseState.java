package view;

import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;

public class PauseState extends State{

    @Override
    public void excute(View view) {
        view.mainMenuButton.setClicked(false);
        view.mainMenuButton.setPosition(view.getWidth() / 2 - view.mainMenuButton.getWidth() / 2,
                view.getHeight() / 2 + view.mainMenuButton.getHeight() / 2 + 150);
        view.pauseButton.setClicked(true);
        while (view.getState().equals(this)) {
            view.setSize(view.getWidth(), view.getHeight());

            view.pauseMenuButtons();

            if (view.saveButton.isClicked())
                view.save();
            else if (view.mainMenuButton.isClicked()) {
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
        g.drawImage(view.backPause, 0, 0, view.getWidth(), view.getHeight(), view);
        if (view.saveButton.getY() != 0) {
            view.saveButton.paint(g, view, url);
            view.mainMenuButton.paint(g, view   , url);
        }
    }

    @Override
    public ArrayList<Button> stateButton(View view) {
        ArrayList<Button> buttons=new ArrayList<>();
        buttons.add(view.mainMenuButton);
        buttons.add(view.saveButton);



        return buttons;
    }

}
