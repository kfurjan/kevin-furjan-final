package hr.algebra.model.vehicle;

public class Vehicle {

    private String manufacturer;
    private Double fuelAmount;

    public Vehicle(String manufacturer, Double fuelAmount) {
        this.manufacturer = manufacturer;
        this.fuelAmount = fuelAmount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(Double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "manufacturer='" + manufacturer + '\'' +
                ", fuelAmount=" + fuelAmount +
                '}';
    }
}
