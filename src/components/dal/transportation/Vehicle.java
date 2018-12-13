package components.dal.transportation;

import components.dal.Component;

public abstract class Vehicle extends Component{


    public Vehicle(String fileName) {
        super(fileName);
    }

    public abstract void move();
}
