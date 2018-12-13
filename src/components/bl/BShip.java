package components.bl;

import components.dal.transportation.Ship;

public class BShip extends Ship {
    int SCREEN_WIDTH;
    int SCREEN_HEIGHT;

    private static BShip bShip;
    private BShip(int screen_width, int screen_height) {
        super(screen_width / 2, screen_height);
        SCREEN_WIDTH = screen_width;
        SCREEN_HEIGHT = screen_height;
    }

    /**
     * Singleton method, for a single logic ship component
     * @param x_point
     * @param y_poiny
     * @return Bship instance
     */
    public static BShip getShipInstance(int x_point, int y_poiny){
        if (bShip != null)
            return bShip;
        return bShip = new BShip(x_point, y_poiny);
    }

    @Override
    public void move() {
        // logic check. can move only in the screen border
        if (x_axis + dx >= 0 && x_axis + width / 2 + dx < SCREEN_WIDTH)
            super.move();
    }
}
