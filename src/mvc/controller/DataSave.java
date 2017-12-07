package mvc.controller;

import java.util.ArrayList;
import java.util.List;

import mvc.model.IClown;
import mvc.model.Plate;
public class DataSave {
    
    private List <Plate>shape;
    private List <IClown>clown;
    public DataSave() {
        shape = new ArrayList<>();   
        shape = new ArrayList<>();   
    }
    public List<Plate> getShape() {
        return shape;
    }
    public void setShape(List<Plate> shape) {
        this.shape = shape;
    }
    public List<IClown> getClown() {
        return clown;
    }
    public void setClown(List<IClown> clown) {
        this.clown = clown;
    }

}
