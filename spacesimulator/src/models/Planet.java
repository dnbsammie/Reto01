package models;

public class Planet {
    private final String name;
    private final double earthDistance, timeTravel, recFuel;
    private final boolean ringSystem;

    public Planet(String name, double earthDistance, double timeTravel, double recFuel, boolean ringSystem) {
        this.name = name;
        this.earthDistance = earthDistance;
        this.timeTravel = timeTravel;
        this.recFuel = recFuel;
        this.ringSystem = ringSystem;
    }

    public String getName() { return name; }

    public double getEarthDistance() { return earthDistance; }

    public double getTimeTravel() { return timeTravel; }

    public double getRecFuel() { return recFuel; }

    public boolean hasRingSystem() { return ringSystem; }

    @Override
    public String toString() {
        return String.format(
                "Planeta: %s\nDistancia desde la tierra: %.2f millones de km\nTiempo de viaje: %.2f días\n"
                        + "Combustible recomendado: %.2f%%\nTiene anillos: %s\n",
                name, earthDistance, timeTravel, recFuel, ringSystem ? "Sí" : "No");
    }
}