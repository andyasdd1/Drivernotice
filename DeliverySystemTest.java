package edu.bu.met.cs665;
//import org.junit.jupiter.api.Test;
import  org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import edu.bu.met.cs665.Delivery.DeliveryRequestManager;
import edu.bu.met.cs665.Delivery.DeliveryRequest;
import edu.bu.met.cs665.Delivery.DeliveryRequestManagerImpl;
import edu.bu.met.cs665.Delivery.Shop;
import edu.bu.met.cs665.Delivery.Driver;
import edu.bu.met.cs665.Delivery.DriverImp;

import java.util.Date;
import java.util.List;

public class DeliverySystemTest {
    private DeliveryRequestManagerImpl manager;
    private Shop shop;

    @Before
    public void setUp() {
        manager = new DeliveryRequestManagerImpl();
        shop = new Shop("TestShop", manager);
        // Register 5 drivers
        for (int i = 0; i <= 5; i++) {
            Driver driver = new DriverImp("Driver " + i);
            manager.addObserver(driver);
        }
        System.out.println(manager.getObserverCount());
    }
    @Test
    public void testAddDriver() {
        Driver newDriver = new DriverImp("Driver 6");
        manager.addObserver(newDriver);
        assertEquals("There should now be 6 drivers", 6, manager.getObserverCount());
    }

    @Test
    public void testDriverNotification() {
        DeliveryRequest request = new DeliveryRequest("TestShop", new Date(), "123 Main St", false);
        shop.createDeliveryRequest("123 Main St", new Date(), false);
    }

    @Test
    public void testAcceptDeliveryRequest() {
        DeliveryRequest request = new DeliveryRequest("TestShop", new Date(), "456 Elm St", false);
        manager.notifyObservers(request);
        DriverImp driver = new DriverImp("TestDriver");
        driver.checkAndAcceptDeliveries(true);
        assertTrue("Request should be marked as taken", request.getIsTaken());
    }


    @Test
    public void testRemoveDriver() {
        Driver driverToRemove = new DriverImp("Driver 5");
        manager.addObserver(driverToRemove); // Assuming you add it first to remove it later.
        manager.removeObserver(driverToRemove);
        assertEquals("There should now be 4 drivers", 4, manager.getObserverCount());
    }

    @Test
    public void testDriverReceptionOfDeliveryRequest() {
        DeliveryRequest request = new DeliveryRequest("TestShop", new Date(), "789 State St", false);
        shop.createDeliveryRequest("789 State St", new Date(), false);
        List<Driver> drivers = manager.getObservers();

        for (Driver driver : drivers) {
            DriverImp concreteDriver = (DriverImp) driver;
            assertTrue("Driver should have the request in pending delivery requests",
                    concreteDriver.getPendingDeliveryRequests().contains(request));
        }
    }
}

