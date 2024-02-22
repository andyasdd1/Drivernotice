package edu.bu.met.cs665.Delivery;

import java.util.List;

public interface DeliveryRequestManager {
    void addObserver(Driver driver);
    void removeObserver(Driver driver);
    void notifyObservers(DeliveryRequest request);
    int getObserverCount();
    List<Driver> getObservers();
    boolean markRequestAsTaken(DeliveryRequest request, Driver driver);
    boolean isRequestAvailable(DeliveryRequest request);

}
