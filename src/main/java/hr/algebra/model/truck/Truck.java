package hr.algebra.model.truck;

import hr.algebra.Chargeable;
import hr.algebra.model.vehicle.BigVehicle;

public class Truck extends BigVehicle implements Chargeable {

    public Truck(String manufacturer, Double fuelAmount) {
        super(manufacturer, fuelAmount);
    }

    @Override
    public Double ticketPrice() {
        return 90.0;
    }
}
