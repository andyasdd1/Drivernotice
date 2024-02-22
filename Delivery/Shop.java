package edu.bu.met.cs665.Delivery;

import java.util.Date;

public class Shop {
    private String name;
    private DeliveryRequestManager deliveryRequestManager;
    public Shop(String shopname, DeliveryRequestManager deliveryRequestManager) {
        this.name = shopname;
        this.deliveryRequestManager = deliveryRequestManager;
    }

    public void createDeliveryRequest(String destinationAddress, Date datetime, Boolean isTaken) {
        DeliveryRequest newRequest = new DeliveryRequest(this.name, datetime, destinationAddress, isTaken);
        deliveryRequestManager.notifyObservers(newRequest);
    }
}

