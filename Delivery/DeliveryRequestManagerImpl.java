package edu.bu.met.cs665.Delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryRequestManagerImpl implements DeliveryRequestManager {
    private List<Driver> drivers = new ArrayList<>();
    // A map to keep track of which requests are taken and by which driver
    private Map<DeliveryRequest, Driver> takenRequests = new HashMap<>();

    @Override
    public void addObserver(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public void removeObserver(Driver driver) {
        drivers.remove(driver);
    }

    @Override
    public void notifyObservers(DeliveryRequest request) {
        for (Driver driver : drivers) {
            driver.receiveDeliveryRequest(request);
        }
    }

    @Override
    public int getObserverCount() {
        return this.drivers.size();
    }

    @Override
    public List<Driver> getObservers() {
        return this.drivers;
    }

    @Override
    public boolean markRequestAsTaken(DeliveryRequest request, Driver driver) {
        if (isRequestAvailable(request)) {
            takenRequests.put(request, driver);
            request.setIsTaken(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean isRequestAvailable(DeliveryRequest request) {
        return !request.getIsTaken();
    }
}

