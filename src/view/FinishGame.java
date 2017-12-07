package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;

public class FinishGame extends State{

    @Override
    public void excute(View view) {
        view.mainMenuButton.setClicked(false);
        view.mainMenuButton.setPosition(view.getWidth() / 2 - view.mainMenuButton.getWidth() / 2,
                view.getHeight() / 2 + view.mainMenuButton.getHeight() / 2 + 150);
        while (view.getState().equals(this)) {
            view.setSize(view.getWidth(), view.getHeight());

            if (view.mainMenuButton.isClicked()) {
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

        g.drawImage(view.gameover, 0, 0, view.getWidth(), view.getHeight(), view);


            view.mainMenuButton.paint(g, view   , url);


        g.setColor(Color.getHSBColor(11, 11, 11));
        Font font = new Font("Serif", Font.BOLD, 40);
        g.setFont(font);

//        String s = Integer.toString(Players.get(0).getScore());
//        g.drawString(s, Width / 2 + 50, Height * 160 / 612);
//        if (Players.size() == 2) {
//            s = Integer.toString(Players.get(1).getScore());
//            g.drawString(s, Width / 2 + 50, Height * 320 / 612);
//        }



    }

    @Override
    public ArrayList<Button> stateButton(View view) {
        ArrayList<Button> buttons=new ArrayList<>();
        buttons.add(view.mainMenuButton);




        return buttons;
    }

}
