package models;

public class SpaceShip {
    private String name;
    private int fuelCapacity, speed, cargoCapacity, toughness, shieldStrength, energyLevel, gravityControl, damage;
    private String specialNote;

    public SpaceShip(String name, int fuelCapacity, int speed, int cargoCapacity, int toughness, int shieldStrength,
            int energyLevel, int gravityControl, int damage, String specialNote) {
        this.name = name;
        this.fuelCapacity = fuelCapacity;
        this.speed = speed;
        this.cargoCapacity = cargoCapacity;
        this.toughness = toughness;
        this.shieldStrength = shieldStrength;
        this.energyLevel = energyLevel;
        this.gravityControl = gravityControl;
        this.damage = damage;
        this.specialNote = specialNote;
    }

    // @formatter:off
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getFuelCapacity() { return fuelCapacity; }
    public void setFuelCapacity(int fuelCapacity) { this.fuelCapacity = fuelCapacity; }
    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }
    public int getCargoCapacity() { return cargoCapacity; }
    public void setCargoCapacity(int cargoCapacity) { this.cargoCapacity = cargoCapacity; }
    public int getToughness() { return toughness; }
    public void setToughness(int toughness) { this.toughness = toughness; }
    public int getShieldStrength() { return shieldStrength; }
    public void setShieldStrength(int shieldStrength) { this.shieldStrength = shieldStrength; }
    public int getEnergyLevel() { return energyLevel; }
    public void setEnergyLevel(int energyLevel) { this.energyLevel = energyLevel; }
    public int getGravityControl() { return gravityControl; }
    public void setGravityControl(int gravityControl) { this.gravityControl = gravityControl; }
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }
    public String getSpecialNote() { return specialNote; }
    public void setSpecialNote(String specialNote) { this.specialNote = specialNote; }
    // @formatter:on
    public void showStats() {
        System.out.printf("Nombre: %s\n", name);
        System.out.printf("Capacidad de combustible: %d\n", fuelCapacity);
        System.out.printf("Velocidad: %d\n", speed);
        System.out.printf("Capacidad de carga: %d\n", cargoCapacity);
        System.out.printf("Resistencia estructural: %d\n", toughness);
        System.out.printf("Fortaleza del escudo: %d\n", shieldStrength);
        System.out.printf("Nivel de energía: %d\n", energyLevel);
        System.out.printf("Nota especial: %s\n", specialNote);
    }
}