package gui.decoration;

import components.bl.BAirplane;
import components.bl.BParachutist;
import components.bl.BShip;
import components.dal.Parachutist;
import components.dal.transportation.*;
import transport.AirTransport;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Background extends JPanel implements ActionListener {

    private static Random random;
    private  int SCREEN_WIDTH;
    private  int SCREEN_HEIGHT;
    private Image backgroundImage;
    private Image sea;
    private final int DELAY = 15;
    private Timer timer;
    private Ship ship;
    private Airplane plane;
    private AirTransport transport;
    private int life;
    int score;

    public Background(int screen_width, int screen_height) {
        SCREEN_WIDTH = screen_width;
        SCREEN_HEIGHT = screen_height;
        random = new Random();
        life = 3;
        score = 10;

        initBackground();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initBackground() {
        this.setFocusable(true);
        this.requestFocus();

        addKeyListener(new TAdapter());

        // init play screen
        try {
            backgroundImage = ImageIO.read(new File("src/resources/background.png"));
            sea = ImageIO.read(new File("src/resources/sea.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        initComponents();
    }

    private void initComponents() {
        ship = BShip.getShipInstance(SCREEN_WIDTH, SCREEN_HEIGHT);
        plane = new BAirplane(SCREEN_WIDTH, SCREEN_HEIGHT);
        transport = new AirTransport(plane);
        int parachutist_position = random.nextInt(SCREEN_WIDTH - 20) + 10;
        BParachutist parachutist = new BParachutist(parachutist_position, plane.getY_axis());
        parachutist.setFall_speed(random.nextInt(3) + 2);
        transport.add_parachutist(parachutist);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.drawImage(backgroundImage, 0, 0, this);
        g.drawImage(sea, 0, SCREEN_HEIGHT - sea.getHeight(null), this);
        g.drawString(String.format("Score: %04d", score), 20, 40);
        g.drawString(String.format("Life: %d", life), 20, 50 + g.getFontMetrics().getHeight());
        g2d.drawImage(ship.getImage(), ship.getX_axis(),
                ship.getY_axis() - sea.getHeight(null) / 2, this);
        g2d.drawImage(plane.getImage(), plane.getX_axis(), plane.getY_axis(), this);

        for (Parachutist parachutist1 : transport.getJumper_parachutists()) {
            g2d.drawImage(parachutist1.getImage(), parachutist1.getX_axis(),
                    parachutist1.getY_axis(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        updateShip();
        updateTransport();
        repaint();
    }

    private void updateShip() {
        ship.move();
    }

    private void updateTransport() {
        transport.flight();
        updateParachutistJump();
        if (transport.getPlane().getX_axis() < 0 - transport.getPlane().getWidth()) {
            transport.setPlane(plane = new BAirplane(SCREEN_WIDTH, SCREEN_HEIGHT));
            int max_parachutists_in_transport = 3;
            for (int i = 0; i < random.nextInt(max_parachutists_in_transport); i++){

                transport.add_parachutist(new BParachutist(random.nextInt(SCREEN_WIDTH - 20) + 10, plane.getY_axis()));
            }
        }
    }

    public void updateParachutistJump(){
        for (Iterator<Parachutist> it = transport.getJumper_parachutists().iterator(); it.hasNext(); ) {
            Parachutist parachutist1 = it.next();
            parachutist1.fall();
            // check if the parachutist in the borders of the boat or if it height is too low.
            if (!(ship.getX_axis() > parachutist1.getX_axis() + parachutist1.getWidth() ||
                    parachutist1.getX_axis() > ship.getX_axis() + ship.getWidth()) && ship.getY_axis() <= parachutist1.getY_axis() + parachutist1.getHeight()) {
                it.remove();
                score += 10;
            }
            else if(parachutist1.getY_axis() + parachutist1.getHeight() > SCREEN_HEIGHT - sea.getHeight(null) / 2)
                disqualification();
        }
    }

    private void disqualification(){
        life--;
        if (life < 0)
            gameOver();
        else
            this.initBackground();
    }

    private void gameOver() {
        timer.stop();
        JLabel over = new JLabel("Game Over!");
        over.setFont(new Font("Serif", Font.BOLD, 75));
        over.setSize(500, 200);
        over.setAlignmentX(getWidth() / 2);
        add(over);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            ship.stopSail();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                ship.doSail(Direction.LEFT);
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                ship.doSail(Direction.RIGHT);
        }
    }
}
