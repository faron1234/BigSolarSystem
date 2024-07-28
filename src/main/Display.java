package main;

import javax.swing.*;

public class Display {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Solar System");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setSize(800, 600);
    }
}