package edu.bu.met.cs665.Delivery;

import java.util.Date;

public class DeliveryRequest {
    private String ShopName;
    private Date DateTime;
    private String destinationAddress;
    private  Boolean isTaken;
    public DeliveryRequest(String shopname, Date datetime, String destinationAddress, Boolean takenornot) {
        this.ShopName = shopname;
        this.DateTime = datetime;
        this.destinationAddress = destinationAddress;
        this.isTaken = takenornot;
    }

    // Getters
    public String getShopName() {
        return ShopName;
    }

    public Date getDatetime() {
        return DateTime;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public Boolean getIsTaken() {
        return isTaken;
    }

    // Setters
    public void setShopName(String shopName) {
        this.ShopName = shopName;
    }

    public void setDatetime(Date datetime) {
        this.DateTime = datetime;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public void setIsTaken(Boolean isTaken) {
        this.isTaken = isTaken;
    }

}
