package org.example;

import java.awt.*;

public class Shipment {
    private Long id;
    private final ShipmentMethod shipmentMethod;
    private final DeparturePoint departurePoint;
    private final ReceivePoint receivePoint;
    private final Item item;
    private final Customer customer;

    public Shipment(final ShipmentMethod shipmentMethod, final Item item,
                    final DeparturePoint departurePoint, final ReceivePoint receivePoint, final Customer customer) {
        this.customer = customer;
        this.departurePoint = departurePoint;
        this.item = item;
        this.shipmentMethod = shipmentMethod;
        this.receivePoint = receivePoint;
        this.id = IdGenerator.getId();

        validateShipmentCriteria();
    }

    private void validateShipmentCriteria() {
        switch (shipmentMethod) {
            case TRACK:
                final int maxTrackWeight = 1000;
                final int maxTrackSize = 3000;
                if (item.getWeight() > maxTrackWeight ||  item.getSize() > maxTrackSize) {
                throw new IllegalArgumentException("Item does not meet TRACK shipment criteria.");
            }
            break;
            case BICYCLE:
                final double maxBicycleWeight = 5;
                final double maxBicycleSize = 10;
                if (item.getWeight() > maxBicycleWeight ||  item.getSize() > maxBicycleSize) {
                throw new IllegalArgumentException("Item does not meet BICYCLE shipment criteria.");
            }
            break;
            case BUS:
                final int maxBusWeight = 30;
                final int maxBusSize = 60;
                if (item.getWeight() > maxBusWeight ||  item.getSize() > maxBusSize) {
                throw new IllegalArgumentException("Item does not meet BUS shipment criteria.");
            }
            break;
            case TRAIN:
                final int maxTrainWeight = 1000;
                final int maxTrainSize = 5000;
                if (item.getWeight() > maxTrainWeight ||  item.getSize() > maxTrainSize) {
                throw new IllegalArgumentException("Item does not meet TRAIN shipment criteria.");
            }
            break;
            default:
                throw new IllegalArgumentException("Invalid shipment method.");
        }
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", shipmentMethod=" + shipmentMethod +
                ", departurePoint=" + departurePoint +
                ", receivePoint=" + receivePoint +
                ", item=" + item +
                ", customer=" + customer +
                '}';
    }

    public Long getId() {
        return id;
    }
}