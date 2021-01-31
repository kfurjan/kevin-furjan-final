package hr.algebra.model.car;

import hr.algebra.Chargeable;
import hr.algebra.model.vehicle.SmallVehicle;

public class Car extends SmallVehicle implements Chargeable {

    public Car(String manufacturer, Double fuelAmount) {
        super(manufacturer, fuelAmount);
    }

    @Override
    public Double ticketPrice() {
        return 50.0;
    }
}
