package mvc.model;

public class Level2 extends NormalStratgy implements StratgyIF {
   int  increase;
   
    public Level2(Plate p, int maxLeftX, int minRightX) {
        super(p, maxLeftX, minRightX);
        
    }

    @Override
    
        public void move() {
            if (plate.draw) {
               
                if (plate.x == plate.maxLeftX || plate.x == plate.minRightX) {
                    plate.down = true;
                   

                }

                if (plate.down) {
                   

                    plate.y += 8;
                    plate.x+= increase ;
                } else {
                    if (plate.x < plate.maxLeftX) {
                        plate.x += 5;
                        increase=5;
                       
                    } else {
                        plate.x -= 5;
                        increase=-5;
                        
                    }
                }
            }
        }

   

}
