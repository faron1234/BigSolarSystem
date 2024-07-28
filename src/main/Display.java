package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Display {
    /*static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];*/

    public void initialise(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        JFrame window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.setTitle("Solar System");
            window.setUndecorated(true);
            window.setLocationRelativeTo(null);
            window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            window.setVisible(true);

            /*window.setSize(screenSize.width/2, screenSize.height/2);
            window.setLocation(new Point(0, 0));
            device.setFullScreenWindow(window);*/


        }
}
