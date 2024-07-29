package main;
import javax.swing.*;
import java.util.Random;

public class Planet {
    private final String name;
    private final double radius;
    private final double distance;
    private final Double mass;
    private final Planet orbiting;
    private static boolean moving = true;
    private Double[] Coords = new Double[2];
    private final double velocity = this.findVelocity();
    private Double angle = new Random().nextFloat() * (Math.PI * 2);
    private static double velocityScale = 1;

    public Planet(String name, Double rad, Double dist, Double mass, Planet orbiting) {
        this.name = name;
        this.radius = rad;
        this.distance = dist;
        this.mass = mass;
        this.orbiting = orbiting;
    }

    private Double findVelocity() {
        return 0.1;
    }

    public void render(Display display, double scale, double[] scaleCentre) {
        double scaledDist = this.distance / scale;
        double scaledRad = this.radius / scale;
        ImageIcon image = new ImageIcon("Static/images/Sun.png");
        this.updatePos(scale, scaleCentre);
        display.renderImage("Static/images/Sun.png");
    }

    private void updatePos(double scale, double[] scaleCentre) {
        this.angle += moving ? this.velocity : 0;
        double scaledDist = this.distance / scale;
        double xChange = Math.sin(this.angle) * scaledDist;
        double yChange = Math.cos(this.angle) * scaledDist;
        this.Coords[0] = xChange + this.orbitCentreX(scaleCentre);
        this.Coords[1] = yChange + this.orbitCentreY(scaleCentre);
    }

    private double orbitCentreX(double[] scaleCentre) {
        return isOrbiting() ? this.orbiting.getX() : scaleCentre[0];
    }

    private double orbitCentreY(double[] scaleCentre) {
        return isOrbiting() ? this.orbiting.getY() : scaleCentre[1];
    }

    private boolean isOrbiting() {
        return this.orbiting != null;
    }

    public double getX() {
        return Coords[0];
    }

    public double getY() {
        return Coords[1];
    }

    public String getName() {
        return name;
    }

    public static void speedUp() {
        velocityScale *= 1.02;
    }

    public static void slowDown() {
        velocityScale /= 1.02;
    }

    public static void stop() {
        moving = false;
    }

    public static void move() {
        moving = true;
    }

    public static boolean isMoving() {
        return moving;
    }

    public static Planet[] createPlanets() {
        Planet Sun = new Planet("Sun", 696340.0, 0.0, 1.989e30, null);
        Planet Mercury = new Planet("Mercury", 2439.7, 57900000.0, 3.285e23, Sun);
        Planet Venus = new Planet("Venus", 6051.8, 108200000.0, 4.867e24, Sun);
        Planet Earth = new Planet("Earth", 6371.0, 149600000.0, 5.9722e24, Sun);
        Planet Moon = new Planet("Moon", 1737.4, 384400.0, 7.3477e22, Earth);
        Planet Mars = new Planet("Mars", 3389.5, 227900000.0, 6.39e23, Sun);
        Planet Jupiter = new Planet("Jupiter", 69911.0, 778600000.0, 1.898e27, Sun);
        Planet Saturn = new Planet("Saturn", 58232.0, 1433500000.0, 5.683e26, Sun);
        Planet Uranus = new Planet("Uranus", 25362.0, 2872500000.0, 8.681e25, Sun);
        Planet Neptune = new Planet("Neptune", 24622.0, 4495100000.0, 1.024e26, Sun);
        Planet Pluto = new Planet("Pluto", 1188.3, 5906376272.0, 1.309e22, Sun);
        return new Planet[]{Sun, Mercury, Venus, Earth, Moon, Mars, Jupiter, Saturn, Uranus, Neptune, Pluto};
    }

}

