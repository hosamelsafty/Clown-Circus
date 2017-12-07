package circuss;

import javax.swing.JFrame;

import mvc.controller.ClownControlle;

public class GUI extends JFrame {

    ClownControlle cc ;
    Plates p ;
    public GUI() {
        super();
        initialize();
    }

    private void initialize() {
        p= new Plates();
       // cc =new ClownControlle(p);

        this.add(p);

        this.addMouseListener(cc);

        addKeyListener(cc);
        addMouseListener(cc);
        addMouseMotionListener(cc);

        setting();
        }


    private void setting() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}