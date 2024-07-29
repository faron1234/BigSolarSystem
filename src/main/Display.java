package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Display {
    /*static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];*/
    private static final JFrame window = new JFrame();

    public void initialise() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Solar System");
        window.setUndecorated(false);
        window.setLocationRelativeTo(null);
        //window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setSize(800, 600);
        window.setVisible(true);
    }

    public void renderImage(String path) {
        JLabel label = new JLabel();
        label.setBounds(-50, -100, 100, 100);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size;
        if (label.getWidth() > label.getHeight()) {
            size = label.getHeight();
        } else {
            size = label.getWidth();
        }
        Image dimg = img.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);

        label.setIcon(icon);

        Container pane = window.getContentPane();
        pane.add(label);
        window.setVisible(true);
    }
}
