package mvc.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
//import com.thoughtworks.xstream.io.xml.StaxDriver;

import circuss.Plates;

import mvc.model.Clown;
import mvc.model.IClown;

import mvc.model.Plate;


public class SaveGame implements Command {
    DataSave dataSave;

    public SaveGame(List<Plate> shape, List<IClown> clown) {
        dataSave = new DataSave();
        dataSave.setClown(clown);
        dataSave.setShape(shape);

    }

    @Override
    public void excute() {
        Originator originator = new Originator();
        originator.setState(dataSave);
        CareTaker careTaker = new CareTaker();
        careTaker.add(originator.saveStateToMemento());
       // System.out.println("kjghfhfvjyugjudfhyf");
        JFileChooser saveFile = new JFileChooser();        
        int sf = saveFile.showSaveDialog(saveFile);
        if (sf == JFileChooser.APPROVE_OPTION) {
            String ext = ".xml";
            if(!saveFile.getSelectedFile().toString().endsWith(ext))
                saveFile.setSelectedFile(new File(saveFile.getSelectedFile().toString() + ext));
        //    XStream xml = new XStream(new StaxDriver());
        //    xml.alias("data", DataSave.class);
          //  try (FileWriter writer = new FileWriter(saveFile.getSelectedFile().toString())) {
            //    writer.write(xml.toXML(dataSave));

//            } catch (IOException e) {
  //              e.printStackTrace();
    //        }
        }

    }
}
