package main;

public class Main {
    private static boolean buttonDown = false;
    private static boolean zoomIn = false;
    private static boolean zoomOut = false;
    private static boolean speedUp = false;
    private static boolean slowDown = false;
    private static int[] mousePos = new int[2];

    private static void events() {

    }

    private static void renderPlanets() {

    }

    private static void speedChange() {

    }

    private static void scale() {

    }

    public static void main(String[] args) {
        Display display = new Display();
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