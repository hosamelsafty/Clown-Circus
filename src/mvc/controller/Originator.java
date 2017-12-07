package mvc.controller;

public class Originator {
    private DataSave state;

    public void setState(DataSave state){
       this.state = state;
    }

    public DataSave getState(){
       return state;
    }

    public Memento saveStateToMemento(){
       return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
       state = memento.getState();
    }
 }