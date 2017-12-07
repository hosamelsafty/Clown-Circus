package mvc.controller;

public class Memento {
    private DataSave state;

    public Memento(DataSave state){
       this.state = state;
    }

    public DataSave getState(){
       return state;
    }    
 }