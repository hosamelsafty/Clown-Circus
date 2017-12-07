package mvc.model;
import java.io.File;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

public class CircusLogs {

    public  void loggerHistoryInfo(String commend){
        // AA name the class  
        //Logger logger = Logger.getLogger(CircusLogs.class);
         String log4jConfigFile = System.getProperty("user.dir")
                    + File.separator + "log4j.properties";
         //   PropertyConfigurator.configure(log4jConfigFile);
     //         logger.info(commend);
    }
public static void main(String[] args) {
    CircusLogs lg =new CircusLogs();
    lg.loggerHistoryInfo("be new ");
    lg.loggerHistoryInfo("be old ");
    lg.loggerHistoryInfo("be single ");
    lg.loggerHistoryInfo("be new ");
    
}
}
