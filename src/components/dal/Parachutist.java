package components.dal;

import gui.RescueGame;

import java.net.URL;

public class Parachutist extends Component{

    public Parachutist(int x_position, int y_position) {
        this(System.getProperty("user.dir")+ "/resources/parachutist.png");
        x_axis = x_position;
        y_axis = y_position;
    }

    private Parachutist(String fileName) {
        super(fileName);
    }

    public void fall(){
        y_axis += dy;
    }

}
