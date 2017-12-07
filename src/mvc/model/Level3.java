package mvc.model;

import java.util.Random;

public class Level3 implements StratgyIF {
    
    StratgyIF level ;
    public Level3(Plate p, int maxLeftX, int minRightX) {
        int x = new Random().nextInt(2);
        if(x==1){
            level =new Level1(p, maxLeftX, minRightX);
        }else
            level=new Level2(p, maxLeftX, minRightX);
        
        
        //increase= 5;
    }

    @Override
    
        public void move() {
        level.move();
    }

}
