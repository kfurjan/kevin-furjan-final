package hr.algebra.model.van;

import hr.algebra.Chargeable;
import hr.algebra.model.vehicle.SmallVehicle;

public class Van extends SmallVehicle implements Chargeable {

    public Van(String manufacturer, Double fuelAmount) {
        super(manufacturer, fuelAmount);
    }

    @Override
    public Double ticketPrice() {
        return 80.0;
    }
}
