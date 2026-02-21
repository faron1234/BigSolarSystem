package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Display {
    private static final JFrame window = new JFrame();

    public void initialise() {
        configureWindow();
        window.setVisible(true);
    }

    private void configureWindow() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Solar System");
        window.setUndecorated(false);
        window.setLocationRelativeTo(null);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void renderImage(String path, double[] coords) {
        BufferedImage img = loadImage(path);
        if (img != null) {
            JLabel label = createLabel(img, coords);
            ImageIcon icon = createScaledIcon(img, label);
            label.setIcon(icon);
            addLabelToWindow(label);
        }
    }

    private JLabel createLabel(BufferedImage img, double[] coords) {
        JLabel label = new JLabel();

        // Determine the size of the image for the label
        int imageWidth = img.getWidth();
        int imageHeight = img.getHeight();

        // Calculate the size to be set to the label
        int width = Math.min(imageWidth, 1000); // limit size if needed
        int height = Math.min(imageHeight, 1000); // limit size if needed

        label.setSize(width, height);

        // Center the label on the provided coordinates
        centerLabelOnCoords(label, coords, width, height);

        return label;
    }

    private BufferedImage loadImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    private ImageIcon createScaledIcon(BufferedImage img, JLabel label) {
        int size = Math.min(label.getWidth(), label.getHeight());
        Image dimg = img.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        return new ImageIcon(dimg);
    }

    private void centerLabelOnCoords(JLabel label, double[] coords, int width, int height) {
        if (coords.length < 2) {
            throw new IllegalArgumentException("coords array must have at least 2 elements");
        }

        // Convert coordinates to integer
        int centerX = (int) coords[0];
        int centerY = (int) coords[1];

        // Calculate top-left corner of the label to be centered on coords
        int x = centerX - (width / 2);
        int y = centerY - (height / 2);

        label.setBounds(x, y, width, height);
    }

    private void addLabelToWindow(JLabel label) {
        Container pane = window.getContentPane();
        pane.setLayout(null); // Use null layout to use absolute positioning
        pane.add(label);
    }
}
