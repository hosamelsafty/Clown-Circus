package view;

import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;

import mvc.model.CircusLogs;

public class StartMenu extends State {
    CircusLogs lg;

    public StartMenu() {
       
    }

    @Override
    public void excute(View view) {
        lg = new CircusLogs();
        while (view.getState().equals(this)) {
            view.setSize(view.getWidth(), view.getHeight());

            view.mainMenuButtons();

            if (view.newGameButton.isClicked()) {
                lg.loggerHistoryInfo("New Game choosen");
                view.setState(new PlayerMenu());
                view.newGameButton.setClicked(false);
                // Control.generate();
            } else if (view.loadGameButton.isClicked()) {
                // Control.generate();
                // PlateIterator a = PlateIterator.getPlateIterator();
                // loadGame();
                lg.loggerHistoryInfo("load Game choosen");
                view.setState(new GameState());
            }
            // else if (importButton.isClicked())
            // importShape();
            else if (view.exitButton.isClicked()) {
                lg.loggerHistoryInfo("exited");
                System.exit(0);
            }
            // try {
            // //Thread.sleep(17);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
            view.repaint();
        }

    }

    @Override
    public void paintState(Graphics g, View view, URL url) {
        g.drawImage(view.backMenu, 0, 0, view.getWidth(), view.getHeight(), view);
        if (view.newGameButton.getY() != 0) {
            view.newGameButton.paint(g, view, url);
            view.loadGameButton.paint(g, view, url);
            view.importButton.paint(g, view, url);
            view.exitButton.paint(g, view, url);
        }
    }

    @Override
    public ArrayList<Button> stateButton(View view) {
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(view.newGameButton);
        buttons.add(view.loadGameButton);
        buttons.add(view.importButton);
        buttons.add(view.exitButton);

        return buttons;
    }
public static void main(String[] args) {
    CircusLogs lg =new CircusLogs();
    lg.loggerHistoryInfo("New Game choosen");
    lg.loggerHistoryInfo("Double Player");
    
}
}
