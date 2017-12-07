package view;

import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;

public abstract class State {

    public abstract void excute(View view);

    public abstract void paintState(Graphics g,View view,URL url);

    public abstract ArrayList<Button> stateButton(View view);


}
