package hr.algebra;

import hr.algebra.model.bus.Bus;
import hr.algebra.model.car.Car;
import hr.algebra.model.truck.Truck;
import hr.algebra.model.van.Van;
import org.junit.Assert;
import org.junit.Test;

public class TicketPricesTest {

    @Test
    public void shouldReturnTrueIfCarPrice50() {
        Car car = new Car("BMW", 100.0);
        Assert.assertEquals(50.0, car.ticketPrice(), 0.0);
    }

    @Test
    public void shouldReturnTrueIfVanPrice80() {
        Van van = new Van("Mercedes", 100.0);
        Assert.assertEquals(80.0, van.ticketPrice(), 0.0);
    }

    @Test
    public void shouldReturnTrueIfBusPrice70() {
        Bus bus = new Bus("Iveco", 100.0);
        Assert.assertEquals(70.0, bus.ticketPrice(), 0.0);
    }

    @Test
    public void shouldReturnTrueIfTruckPrice90() {
        Truck truck = new Truck("MAN", 100.0);
        Assert.assertEquals(90.0, truck.ticketPrice(), 0.0);
    }
}
