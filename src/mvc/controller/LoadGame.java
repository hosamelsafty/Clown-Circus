package mvc.controller;

public class LoadGame implements Command{

    DataSave dataSave ;
    
    public  LoadGame(){
        dataSave= new DataSave();

    }
    @Override
    public void excute() {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.getStateFromMemento(careTaker.get(0));

    }

}
