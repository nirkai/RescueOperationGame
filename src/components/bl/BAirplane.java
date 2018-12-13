package components.bl;

import components.dal.transportation.Airplane;
import java.util.Random;

public class BAirplane extends Airplane {

    public BAirplane(int screen_width, int screen_height) {

        super(screen_width, screen_height);
        Random random = new Random();
        x_axis = screen_width + width;
        y_axis = random.nextInt(screen_height / 10);    // random y point position for each airplane.
        dx = random.nextInt(5)  + 5;                    // random speed for each airplane, from 5 to 10.


    }
}
