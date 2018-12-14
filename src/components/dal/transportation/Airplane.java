package components.dal.transportation;

import gui.RescueGame;

public class Airplane extends Vehicle {

    public Airplane(int screen_width, int screen_height) {
        super(System.getProperty("user.dir") + "/resources/plane.png");
    }

    @Override
    public void move() {
        x_axis -= dx;
    }
}
