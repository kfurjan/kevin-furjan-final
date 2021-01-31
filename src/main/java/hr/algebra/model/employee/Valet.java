package hr.algebra.model.employee;

import hr.algebra.Chargeable;
import hr.algebra.Fee;
import hr.algebra.model.vehicle.Vehicle;

import java.util.List;

public class Valet extends Employee implements Fee {

    private Double percentage;
    private List<? extends Chargeable> vehicles;

    public Valet(String firstName, String lastName, Double percentage, List<? extends Chargeable> vehicles) {
        super(firstName, lastName);
        this.percentage = percentage;
        this.vehicles = vehicles;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public List<? extends Chargeable> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<? extends Chargeable> vehicles) {
        this.vehicles = vehicles;
    }

    public String parkVehicles() {
        StringBuilder sb = new StringBuilder();

        ((List<? extends Vehicle>) vehicles).forEach(v -> {
            if (v.getFuelAmount() < 10.0) {
                sb.append(v.toString());
                sb.append(" has less than 10% of fuel. It needs to be refueled! \n");
            } else {
                sb.append(v.toString());
                sb.append(" has ");
                sb.append(v.getFuelAmount());
                sb.append("% of fuel. \n");
            }
        });

        return sb.toString();
    }

    @Override
    public Double totalProfitFee() {
        return (percentage / 100) * vehicles
                .stream()
                .reduce(0.0, (partialResult, vehicle) -> partialResult + vehicle.ticketPrice(), Double::sum);
    }
}
