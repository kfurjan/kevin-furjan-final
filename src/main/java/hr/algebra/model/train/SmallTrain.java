package hr.algebra.model.train;

import hr.algebra.Chargeable;
import hr.algebra.Profitable;
import hr.algebra.model.vehicle.SmallVehicle;

import java.util.List;

public class SmallTrain extends Train implements Profitable {

    private static final int CAPACITY = 8;

    private List<? extends Chargeable> vehicles;

    public SmallTrain(String manufacturer, Double fuelAmount, List<? extends SmallVehicle> vehicles) {
        super(manufacturer, fuelAmount);
        validateProvidedVehicles(vehicles);
    }

    public List<? extends Chargeable> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<? extends SmallVehicle> vehicles) {
        validateProvidedVehicles(vehicles);
    }

    private void validateProvidedVehicles(List<? extends SmallVehicle> vehicles) {
        if (vehicles.size() <= CAPACITY) {
            try {
                this.vehicles = (List<? extends Chargeable>) vehicles;
            } catch (Exception ex) {
                throw new IllegalArgumentException("Not all provided vehicles have ticket prices!");
            }
        } else {
            throw new IllegalArgumentException("Maximum capacity of vehicles exceeded!");
        }
    }

    @Override
    public Double totalTicketProfit() {
        return vehicles
                .stream()
                .reduce(0.0, (partialResult, vehicle) -> partialResult + vehicle.ticketPrice(), Double::sum);
    }
}
