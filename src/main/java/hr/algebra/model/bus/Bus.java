package hr.algebra.model.bus;

import hr.algebra.Chargeable;
import hr.algebra.model.vehicle.BigVehicle;

public class Bus extends BigVehicle implements Chargeable {

    public Bus(String manufacturer, Double fuelAmount) {
        super(manufacturer, fuelAmount);
    }

    @Override
    public Double ticketPrice() {
        return 70.0;
    }
}
