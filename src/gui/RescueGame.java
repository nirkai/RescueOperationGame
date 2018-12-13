package gui;

import gui.decoration.Background;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class RescueGame extends JFrame{
    private final int SCREEN_WIDTH = 900;
    private final  int SCREEN_HEIGHT = 600;

    public RescueGame() {
        initUI();
    }

    private void initUI() {
        add(new Background(SCREEN_WIDTH, SCREEN_HEIGHT));

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false);

        setTitle("Rescue Operation");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            RescueGame rg = new RescueGame();
            rg.setVisible(true);
        });
    }
}
