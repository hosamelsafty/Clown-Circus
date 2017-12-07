package view;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import mvc.model.Plate;
import circuss.Plates;
import mvc.controller.ClownControlle;

public class View extends Applet implements Runnable {

    public void initialize(int NumOfPlayer) {
        plates = new Plates();
        cc = new ClownControlle(plates,NumOfPlayer);

       // this.add(plates);

        this.addMouseListener(cc);

        addKeyListener(cc);
        addMouseListener(cc);
        addMouseMotionListener(cc);

    }

    protected long time, startTime, timeBeforLoading, loadingTime,
            loadingTextTimer, loadingTextTimer2, gameStartTime, timeRemains;
  //  private PlateIterator plateIterator;
    private Image i;
    private ClownControlle cc;
    private Plates plates;
    private Image image;
    private Graphics doubleG;
    private AbstractFactory abstractfactory;
    private mvc.model.Plate plate;
    private int Height, Width;


    private URL url;
    private State state;
    Image backMenu, back1, back2, backPause, gameover, backOverTwo;
 //   protected Controler Control;

   public Button newGameButton, loadGameButton, importButton, onePlayerButton,
            twoPlayersButton, exitButton, mainMenuButton, pauseButton,
            saveButton;
 //   ArrayList<Player> Players;



    boolean check = false ;


    @Override
    public void init() {
        //check = false;
        state=new StartMenu();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Height = dim.height ;
        Width = dim.width ;
        setSize(Width, Height);
        setBackground(Color.BLACK);

        image = new ImageIcon(this.getClass().getResource("/components/stage.jpg")).getImage();



        this.addMouseMotionListener(new mouseMotion(this));
        this.addMouseListener(new mouseMotion(this));

        try {
            url = getDocumentBase();
        } catch (Exception e) {
        }

        backPause=getImage(url, "images/backPause.png");
        backMenu = getImage(url, "images/back1.jpg");
        gameover = getImage(url, "images/gameover.jpg");


        getButtons();


    }




    private void getButtons() {
        abstractfactory = FactoryProducer.getFactory("BUTTON");
        newGameButton = abstractfactory.getButton();
        newGameButton.setType("newGame");

        loadGameButton = abstractfactory.getButton();
        loadGameButton.setType("loadGame");

        importButton = abstractfactory.getButton();
        importButton.setType("import");

        onePlayerButton = abstractfactory.getButton();
        onePlayerButton.setType("onePlayer");

        twoPlayersButton = abstractfactory.getButton();
        twoPlayersButton.setType("twoPlayers");

        mainMenuButton = abstractfactory.getButton();
        mainMenuButton.setType("mainMenu");
        mainMenuButton.setWidth(200);
        mainMenuButton.setHight(86);

        exitButton = abstractfactory.getButton();
        exitButton.setType("exit");
        exitButton.setWidth(200);
        exitButton.setHight(86);

        pauseButton = abstractfactory.getButton();
        pauseButton.setType("pause");
        pauseButton.setWidth(200);
        pauseButton.setHight(86);
        pauseButton.setPosition(Width - pauseButton.getWidth() - 30, Height
                - (pauseButton.getHeight() / 2 + 150));

        saveButton = abstractfactory.getButton();
        saveButton.setType("save");
        saveButton.setWidth(200);
        saveButton.setHight(86);
        saveButton.setPosition((Width - saveButton.getWidth()) / 2, Height / 2
                - loadGameButton.getHight() / 2);
    }


    @Override
    public void start() {


        Thread thread = new Thread(this);
        thread.start();
      //  playSound("a.wav");
    }


    @Override
    public void run() {


        while (true) {

            timeBeforLoading = System.currentTimeMillis();
            loadingTime = loadingTextTimer = System.currentTimeMillis()
                    - timeBeforLoading;

            excute();

        }
    }

    private void excute() {
        state.excute(this);
        // TODO Auto-generated method stub

    }






    public void mainMenuButtons() {
        if (exitButton.getY() == 0) // buttons position were not set
            setMainMenuButtons();
        else if (newGameButton.isMoving() || loadGameButton.isMoving()
                || importButton.isMoving() || exitButton.isMoving()) { // move
                                                                        // buttons
            moveMainMenuButtons();
        }
    }

    private void moveMainMenuButtons() {
        int buttonsSpeed = 20;

        if (newGameButton.isMoving()) {
            newGameButton.setPosition(newGameButton.getX() + buttonsSpeed,
                    newGameButton.getY());
            if (newGameButton.getX() >= Width / 2 - newGameButton.getWidth()
                    / 2)
                newGameButton.setMoving(false);
        }
        if (loadGameButton.isMoving()) {
            loadGameButton.setPosition(loadGameButton.getX() - buttonsSpeed,
                    loadGameButton.getY());
            if (loadGameButton.getX() <= Width / 2 - loadGameButton.getWidth()
                    / 2)
                loadGameButton.setMoving(false);
        }

        if (importButton.isMoving()) {
            importButton.setPosition(importButton.getX() + buttonsSpeed,
                    importButton.getY());
            if (importButton.getX() >= Width / 2 - importButton.getWidth() / 2)
                importButton.setMoving(false);
        }

        if (exitButton.isMoving()) {
            exitButton.setPosition(exitButton.getX() + buttonsSpeed * 2,
                    exitButton.getY());
            if (exitButton.getX() >= Width - exitButton.getWidth() - 60)
                exitButton.setMoving(false);
        }
    }

    private void setMainMenuButtons() {
        newGameButton.setMoving(true);
        newGameButton.setPosition(0, Height / 2
                - (newGameButton.getHeight() * 3 / 2 + 50));

        loadGameButton.setMoving(true);
        loadGameButton.setPosition(Width - loadGameButton.getWidth(), Height
                / 2 - loadGameButton.getHight() / 2);

        importButton.setMoving(true);
        importButton.setPosition(0, Height / 2 + loadGameButton.getHeight() / 2
                + 50);

        exitButton.setMoving(true);
        exitButton.setPosition(0, Height - (exitButton.getHeight() / 2 + 150));

    }

    public void playersMenuButtons() {
        if (onePlayerButton.getY() == 0) // buttons position were not set
            setPlayersMenuButtons();
        else if (onePlayerButton.isMoving() || twoPlayersButton.isMoving()
                || mainMenuButton.isMoving()) { // move buttons
            movePlayersMenuButtons();
        }
    }

    private void setPlayersMenuButtons() {
        onePlayerButton.setMoving(true);
        onePlayerButton.setPosition(0,
                Height / 2 - (onePlayerButton.getHeight() + 30));

        twoPlayersButton.setMoving(true);
        twoPlayersButton.setPosition(Width - twoPlayersButton.getWidth(),
                Height / 2 + 30);

        mainMenuButton.setMoving(true);
        mainMenuButton.setPosition(0, Height
                - (mainMenuButton.getHeight() / 2 + 150));
    }

    private void movePlayersMenuButtons() {
        int buttonsSpeed = 20;

        if (onePlayerButton.isMoving()) {
            onePlayerButton.setPosition(onePlayerButton.getX() + buttonsSpeed,
                    onePlayerButton.getY());
            if (onePlayerButton.getX() >= Width / 2
                    - onePlayerButton.getWidth() / 2)
                onePlayerButton.setMoving(false);
        }
        if (twoPlayersButton.isMoving()) {
            twoPlayersButton.setPosition(
                    twoPlayersButton.getX() - buttonsSpeed,
                    twoPlayersButton.getY());
            if (twoPlayersButton.getX() <= Width / 2
                    - twoPlayersButton.getWidth() / 2)
                twoPlayersButton.setMoving(false);
        }
        if (mainMenuButton.isMoving()) {
            mainMenuButton.setPosition(
                    mainMenuButton.getX() + buttonsSpeed * 2,
                    mainMenuButton.getY());
            if (mainMenuButton.getX() >= Width - mainMenuButton.getWidth() - 60)
                mainMenuButton.setMoving(false);
        }
    }



    public void save() {
        // TODO Auto-generated method stub
        saveButton.setClicked(false);

    }

    public void pauseMenuButtons() {
        // TODO Auto-generated method stub

    }


    @Override
    public void paint(Graphics g) {

        state.paintState(g, this, url);
    }







    @Override
    public void update(Graphics g) {
        if (i == null) {
            i = createImage(Width, Height);
            doubleG = i.getGraphics();
        }

        doubleG.setColor(getBackground());
        doubleG.fillRect(0, 0, Width, Height);

        doubleG.setColor(getForeground());
        paint(doubleG);

        g.drawImage(i, 0, 0, this);
    }

    @Override
    public void stop() {
    }

    @Override
    public void destroy() {
    }




//    public static synchronized void playSound(final String url) {
//        new Thread(new Runnable() {
//        // The wrapper thread is unnecessary, unless it blocks on the
//        // Clip finishing; see comments.
//          @Override
//        public void run() {
//            try {
//              Clip clip = AudioSystem.getClip();
//              AudioInputStream inputStream = AudioSystem.getAudioInputStream(
//                View.class.getResourceAsStream("/images/"+url+"/"));
//              clip.open(inputStream);
//              clip.start();
//            } catch (Exception e) {
//              System.err.println(e.getMessage());
//            }
//          }
//        }).start();
//      }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Plates getPlates() {
        return plates;
    }

    public void setPlates(Plates plates) {
        this.plates = plates;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
