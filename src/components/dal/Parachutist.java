package components.dal;

public class Parachutist extends Component{

    public Parachutist(int x_position, int y_position) {
        this("src/resources/parachutist.png");
        x_axis = x_position;
        y_axis = y_position;
    }

    public Parachutist(String fileName) {
        super(fileName);
    }

    public void fall(){
        y_axis += dy;
    }

    //public void setFall_speed(int fall_speed){}
}
