package components.dal;

import javax.swing.*;
import java.awt.*;

public class Component {
    protected int dx;
    protected int dy;
    private Image image;

    protected int x_axis;
    protected int y_axis;
    protected int width;
    protected int height;

    public Component(String fileName) {
        loadImage(fileName);
    }

    private void loadImage(String fileName) {
        ImageIcon imageIcon = new ImageIcon(fileName);
        image = imageIcon.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public int getX_axis() {
        return x_axis;
    }

    public int getY_axis() {
        return y_axis;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }
}
