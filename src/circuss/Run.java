package circuss;

public class Run {

    GUI gui = null;

    public GUI getInstance(){
        if (gui == null){
            gui = new GUI();
        }
        return gui;
    }


    public static void main(String[] args){


    }

}
