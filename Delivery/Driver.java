package edu.bu.met.cs665.Delivery;

import java.util.List;

public interface Driver {
    void receiveDeliveryRequest(DeliveryRequest deliveryRequest);

    void checkAndAcceptDeliveries(boolean decision);

    List<DeliveryRequest> getPendingDeliveryRequests();
}
