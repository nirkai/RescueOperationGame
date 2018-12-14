package components.dal.transportation;


import gui.RescueGame;

public class Ship extends Vehicle {

    private int sail_speed;

    public Ship(int x_point, int y_point) {
        super(System.getProperty("user.dir")+ "/resources/boat.png");
        x_axis = x_point - width / 2;
        y_axis = y_point - (height);
        sail_speed = 4;
    }

    @Override
    public void move(){
        x_axis += dx;
        y_axis += dy;
    }

    public void doSail(Direction direction) {
        switch (direction){
            case RIGHT:
                dx = sail_speed;
                break;
            case LEFT:
                dx = -(sail_speed);
                break;
        }
    }

    public void stopSail() {
        dx = 0;
    }

    public int getSail_speed() {
        return sail_speed;
    }

    public void setSail_speed(int sail_speed) {
        this.sail_speed = sail_speed;
    }
}
