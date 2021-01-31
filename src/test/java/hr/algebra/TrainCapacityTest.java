package hr.algebra;

import hr.algebra.model.bus.Bus;
import hr.algebra.model.car.Car;
import hr.algebra.model.train.BigTrain;
import hr.algebra.model.train.SmallTrain;
import hr.algebra.model.truck.Truck;
import hr.algebra.model.van.Van;
import hr.algebra.model.vehicle.BigVehicle;
import hr.algebra.model.vehicle.SmallVehicle;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TrainCapacityTest {

    @Test
    public void shouldThrowExceptionIfSmallTrainOverCapacity() {
        List<SmallVehicle> smallVehicles = Arrays.asList( // 9 vehicles
                new Car("VW", 55.0),
                new Car("Audi", 30.0),
                new Car("Opel", 32.0),
                new Car("Mercedes", 9.0),
                new Van("VW", 15.0),
                new Van("Audi", 99.0),
                new Van("Opel", 90.0),
                new Van("Mercedes", 3.0),
                new Van("Mercedes", 3.0)
        );

        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> new SmallTrain("Mali vlak", 56.0, smallVehicles));
    }

    @Test
    public void shouldThrowExceptionIfBigTrainOverCapacity() {
        List<BigVehicle> bigVehicles = Arrays.asList( // 7 vehicles
                new Bus("Man", 90.0),
                new Bus("DAF", 5.0),
                new Truck("Volvo", 4.0),
                new Truck("Man", 55.0),
                new Truck("Mercedes", 40.0),
                new Truck("Iveco", 30.0),
                new Truck("Iveco", 30.0)
        );

        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> BigTrain.getInstance("Veliki vlak", 90.0, bigVehicles));
    }
}
