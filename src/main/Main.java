package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Main {
    private static boolean buttonDown = false;
    private static boolean zoomIn = false;
    private static boolean zoomOut = false;
    private static boolean speedUp = false;
    private static boolean slowDown = false;
    private static int[] mousePos = new int[2];
    private static final Display display = new Display();
    private static final Planet[] planets = Planet.createPlanets();

    private static void events() {
        display.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_DOWN) {
                    zoomIn = true;
                } else if (key == KeyEvent.VK_UP) {
                    zoomOut = true;
                } else if (key == KeyEvent.VK_EQUALS) {
                    speedUp = true;
                } else if (key == KeyEvent.VK_MINUS) {
                    slowDown = true;
                } else if (key == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                } else if (key == KeyEvent.VK_SPACE) {
                    if (Planet.isMoving()) {
                        Planet.stop();
                    } else {
                        Planet.move();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_DOWN) {
                    zoomIn = false;
                } else if (key == KeyEvent.VK_UP) {
                    zoomOut = false;
                } else if (key == KeyEvent.VK_EQUALS) {
                    speedUp = false;
                } else if (key == KeyEvent.VK_MINUS) {
                    slowDown = false;
                }
            }
        });

        display.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonDown = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                buttonDown = false;
            }
        });

        display.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mousePos[0] = e.getX();
                mousePos[1] = e.getY();
            }
        });
    }

    private static void renderPlanets() {
        Arrays.stream(planets).forEach(planet -> planet.render(display, 1.0, new double[]{100.0, 100.0}));
    }

    private static void speedChange() {

    }

    private static void scale() {

    }

    public static void main(String[] args) {
        display.initialise();
        while (true) {
            // mouse_pos = ...
            // display.draw();
            events();
            scale();
            speedChange();
            renderPlanets();
            // display.update();
        }
    }
}