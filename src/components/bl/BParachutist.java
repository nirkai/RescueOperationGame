package components.bl;

import components.dal.Parachutist;

public class BParachutist extends Parachutist {
    public BParachutist(int x_position, int y_position) {
        super(x_position, y_position);
        dy = 3;
    }

    public void setFall_speed(int fall_speed) {
        if (fall_speed >= 0 && fall_speed < 6)
            dy = fall_speed;
    }
}
