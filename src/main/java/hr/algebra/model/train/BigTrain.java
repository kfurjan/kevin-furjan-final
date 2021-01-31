package hr.algebra.model.train;

import hr.algebra.Chargeable;
import hr.algebra.Profitable;
import hr.algebra.model.vehicle.BigVehicle;

import java.util.List;

public class BigTrain extends Train implements Profitable {

    private static final int CAPACITY = 6;
    private static BigTrain INSTANCE;

    private List<? extends Chargeable> vehicles;

    private BigTrain(String manufacturer, Double fuelAmount, List<? extends BigVehicle> vehicles) {
        super(manufacturer, fuelAmount);
        validateProvidedVehicles(vehicles);
    }

    public static BigTrain getInstance(String manufacturer, Double fuelAmount, List<? extends BigVehicle> vehicles) {
        if (INSTANCE == null) {
            INSTANCE = new BigTrain(manufacturer, fuelAmount, vehicles);
        }
        return INSTANCE;
    }

    public List<? extends Chargeable> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<? extends BigVehicle> vehicles) {
        validateProvidedVehicles(vehicles);
    }

    private void validateProvidedVehicles(List<? extends BigVehicle> vehicles) {
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
