package components.dal.transportation;

public class Airplane extends Vehicle {

    public Airplane(int screen_width, int screen_height) {
        super("src/resources/plane.png");
    }

    @Override
    public void move() {
        x_axis -= dx;
    }
}
