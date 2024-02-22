package edu.bu.met.cs665.Delivery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DriverImp implements Driver{
    private String driverName;
    private List<DeliveryRequest> pendingDeliveryRequests = new ArrayList<>();
    private List<DeliveryRequest> acceptedDeliveryRequests = new ArrayList<>();
    public DriverImp(String driverName) {
        this.driverName = driverName;
    }
    @Override
    public void receiveDeliveryRequest(DeliveryRequest deliveryRequest) {
        pendingDeliveryRequests.add(deliveryRequest);
        System.out.println(driverName + " received a new delivery request to: " + deliveryRequest.getDestinationAddress());
    }

    @Override
    public void checkAndAcceptDeliveries(boolean decision) {
        Iterator<DeliveryRequest> iterator = pendingDeliveryRequests.iterator();
        while (iterator.hasNext()) {
            DeliveryRequest request = iterator.next();
            if (!request.getIsTaken() && decision) {
                request.setIsTaken(true); // Mark as taken
                acceptedDeliveryRequests.add(request);
                iterator.remove(); // Remove from pending requests
                System.out.println(driverName + " accepted the delivery request to: " + request.getDestinationAddress());
            }
        }
    }
    @Override
    public List<DeliveryRequest> getPendingDeliveryRequests() {
        return this.pendingDeliveryRequests;
    }
}
