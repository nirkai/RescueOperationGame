package transport;

import components.bl.BParachutist;
import components.dal.Parachutist;
import components.dal.transportation.Airplane;

import java.util.*;

/**
 * Transport of the Parachutists in the Airplane
 */
public class AirTransport {
    private Airplane plane;
    private Stack<Parachutist> parachutists;
    private List<Parachutist> jumper_parachutists;


    public AirTransport(Airplane plane) {
        this.plane = plane;
        parachutists = new Stack<>();
        jumper_parachutists = new ArrayList<>();
    }

    public void add_parachutist(Parachutist parachutist){
        parachutists.add(parachutist);
        parachutists.sort(new Comparator<Parachutist>() {
            @Override
            public int compare(Parachutist p1, Parachutist p2) {
                return p1.getX_axis() - p2.getX_axis();
            }
        });
    }

    public void jump(){
        jumper_parachutists.add(parachutists.pop());
        for (Parachutist jumper_parachutist : jumper_parachutists) {
            if (jumper_parachutist.getY_axis() < 0)
                jumper_parachutists.remove(jumper_parachutist);
        }
    }

    public void flight(){
        plane.move();
        if (!parachutists.isEmpty() && (plane.getX_axis() <= parachutists.peek().getX_axis()))
            jump();
    }

    public Airplane getPlane() {
        return plane;
    }

    public void setPlane(Airplane plane) {
        this.plane = plane;
    }

    public List<Parachutist> getJumper_parachutists() {
        return jumper_parachutists;
    }
}
