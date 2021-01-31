package hr.algebra;

import hr.algebra.model.bus.Bus;
import hr.algebra.model.car.Car;
import hr.algebra.model.employee.Valet;
import hr.algebra.model.train.BigTrain;
import hr.algebra.model.train.SmallTrain;
import hr.algebra.model.truck.Truck;
import hr.algebra.model.van.Van;
import hr.algebra.model.vehicle.BigVehicle;
import hr.algebra.model.vehicle.SmallVehicle;

import java.util.Arrays;
import java.util.List;

public class Solid {

    public static void main(String[] args) {
        List<SmallVehicle> smallVehicles = Arrays.asList(
                new Car("VW", 55.0),
                new Car("Audi", 30.0),
                new Car("Opel", 32.0),
                new Car("Mercedes", 9.0),
                new Van("VW", 15.0),
                new Van("Audi", 99.0),
                new Van("Opel", 90.0),
                new Van("Mercedes", 3.0)
        );
        SmallTrain smallTrain = new SmallTrain("Mali vlak", 56.0, smallVehicles);
        System.out.printf("Total ticket profit for small train is: %.2f %n", smallTrain.totalTicketProfit());

        List<BigVehicle> bigVehicles = Arrays.asList(
                new Bus("Man", 90.0),
                new Bus("DAF", 5.0),
                new Truck("Volvo", 4.0),
                new Truck("Man", 55.0),
                new Truck("Mercedes", 40.0),
                new Truck("Iveco", 30.0)
        );
        BigTrain bigTrain = BigTrain.getInstance("Veliki vlak", 90.0, bigVehicles);
        System.out.printf("Total ticket profit for big train is: %.2f %n%n", bigTrain.totalTicketProfit());

        // ==================================================================================================

        Valet valet1 = new Valet("Marko", "Markic", 10.0, smallTrain.getVehicles());
        System.out.printf("First valet takes fee of: %.2f%n", valet1.totalProfitFee());
        System.out.println(valet1.parkVehicles());

        Valet valet2 = new Valet("Mirko", "Mirkic", 11.0, bigTrain.getVehicles());
        System.out.printf("Second valet takes fee of: %.2f%n", valet2.totalProfitFee());
        System.out.println(valet2.parkVehicles());
    }
}
