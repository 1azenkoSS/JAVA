package org.example;

public class ReceivePoint extends DeliveryPoint{

    public ReceivePoint(final String oblast,final String region,final String settlements,final String street,final int building) {
        super(oblast, region, settlements, street, building);
    }

    @Override
    public String toString() {
        return "RP: " + super.toString();
    }
}