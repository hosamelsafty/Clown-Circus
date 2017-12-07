package mvc.controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

import circuss.Plates;
import mvc.model.IClown;

public class ClownControlle implements Runnable, MouseListener, MouseMotionListener, KeyListener {

   // private JLabel label;
    private Plates mainGui;
    HashMap<Character, Boolean> pushedKeys;
    Thread player1, player2, controller;

    private Point currentLocation, oldLocation;
    private IClown SelectedPlayer;

    public ClownControlle(Plates p,int numOfPlayer) {

        mainGui = p;
        mainGui.inti(numOfPlayer);
        pushedKeys = new HashMap<>();
        intializeKeyBoardHashMap();
        controller = new Thread(this, "ClownControlle");
        controller.start();

    }
    public void intializeKeyBoardHashMap() {

        pushedKeys.put('l', false);
        pushedKeys.put('r', false);
        pushedKeys.put('a', false);
        pushedKeys.put('d', false);
    }

    @Override
    public void run() {
        Player1Motion();
        Player2Motion();

    }

    private void Player1Motion() {
        player1 = new Thread("player1") {
            @Override
            public void run() {
                while (true) {
                    if (pushedKeys.get('l'))
                        mainGui.getPlayers().get(0).moveLeft(5);
                    if (pushedKeys.get('r'))
                        mainGui.getPlayers().get(0).moveRight(5);
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block

                    }
                }
            }
        };
        player1.start();
    }

    private void Player2Motion() {
        player2 = new Thread("player2") {
            @Override
            public void run() {
                while (true) {
                    if (mainGui.getPlayers().size() > 1) {
                        if (pushedKeys.get('a'))
                            mainGui.getPlayers().get(1).moveLeft(5);
                        if (pushedKeys.get('d'))
                            mainGui.getPlayers().get(1).moveRight(5);
                    }
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block

                    }
                }
            }
        };
        player2.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pushedKeys.put('l', true);

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pushedKeys.put('r', true);
           // mainGui.getPlayers().get(0).moveRight(15);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            if (mainGui.getPlayers().size() > 1)
                pushedKeys.put('a', true);
            // mainGui.getPlayers().get(1).moveLeft(15);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            if (mainGui.getPlayers().size() > 1)
                pushedKeys.put('d', true);
            // mainGui.getPlayers().get(1).moveRight(15);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pushedKeys.put('l', false);
            // mainGui.getPlayers().get(0).moveLeft(15);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pushedKeys.put('r', false);
           // mainGui.getPlayers().get(0).moveRight(15);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            if (mainGui.getPlayers().size() > 1)
                pushedKeys.put('a', false);
            // mainGui.getPlayers().get(1).moveLeft(15);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            if (mainGui.getPlayers().size() > 1)
                pushedKeys.put('d', false);
            // mainGui.getPlayers().get(1).moveRight(15);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // System.out.println("fd");
        currentLocation = new Point(e.getPoint());
        oldLocation = currentLocation;
        for (IClown c : mainGui.getPlayers()) {
            if (c.contain(currentLocation.x, currentLocation.y)) {
                SelectedPlayer = c;
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        SelectedPlayer = null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        oldLocation = currentLocation;
        currentLocation = e.getPoint();
        if (SelectedPlayer != null) {
            SelectedPlayer.move(oldLocation.x, currentLocation.x);

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }



}