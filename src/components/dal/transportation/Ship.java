package components.dal.transportation;


public class Ship extends Vehicle {

    public Ship(int x_point, int y_point) {
        super("src/resources/boat.png");
        x_axis = x_point - width / 2;
        y_axis = y_point - (height);
    }

    @Override
    public void move(){
        x_axis += dx;
        y_axis += dy;
    }

    public void doSail(Direction direction) {
        switch (direction){
            case RIGHT:
                dx = 4;
                break;
            case LEFT:
                dx = -4;
                break;
        }
    }

    public void stopSail() {
        dx = 0;
    }
}
