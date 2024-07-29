package main;

public class Main {
    private static boolean buttonDown = false;
    private static boolean zoomIn = false;
    private static boolean zoomOut = false;
    private static boolean speedUp = false;
    private static boolean slowDown = false;
    private static int[] mousePos = new int[2];
    private static final Display display = new Display();

    private static void events() {

    }

    private static void renderPlanets(Planet planet) {
        planet.render(display, 1.0, new double[]{100.0, 100.0});
    }

    private static void speedChange() {

    }

    private static void scale() {

    }

    public static void main(String[] args) {
        display.initialise();
//        while (true) {
//            // mouse_pos = ...
//            // display.draw();
//            events();
//            scale();
//            speedChange();
//            renderPlanets();
//            // display.update();
//        }
        Planet[] planets = Planet.createPlanets();
        renderPlanets(planets[0]);
    }
}