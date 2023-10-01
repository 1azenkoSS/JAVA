package org.example;

public class Delivery {

    private final DeparturePoint[] departurePoints = {
            new DeparturePoint(1L,"Transkarpathian", "Uzhgorodska", "Uzhgorod", "Svobody", 29),
            new DeparturePoint(2L,"Transkarpathian", "Mukachivska", "Mukachevo", "Peremohy", 11),
            new DeparturePoint(3L,"Transkarpathian", "Mukachivska", "Svalyava", "Zelena", 3),
            new DeparturePoint(4L,"Transkarpathian", "Volovec", "Volovec", "Karpatska", 9),
            new DeparturePoint(5L,"Lvivska", "Lviv", "Lviv", "Sakharova", 25),
            new DeparturePoint(6L,"Lvivska", "Lviv", "Lviv", "Bandery", 12),
            new DeparturePoint(7L,"Lvivska", "Lviv", "Zolochevo", "Franka", 56),
    };
    private Shipment[] shipments = new Shipment[]{};

    public void addShipment(Shipment shipment) {

        final int shipmentsCount = this.shipments.length;

        final Shipment[] newShipments = new Shipment[shipmentsCount + 1];
        for (int i = 0; i < shipmentsCount; i++) {
            newShipments[i] = this.shipments[i];
        }

        newShipments[shipmentsCount] = shipment;

        this.shipments = newShipments;
    }
    public void createDelivery(final int departureId, final Customer customer, final Item item, final ReceivePoint receivePoint,
                               final ShipmentMethod shipmentMethod) {
        DeparturePoint departurePoint = departurePoints[departureId - 1];

        if (departurePoint.hasTheSameAddress(receivePoint)) {
            throw new IllegalArgumentException("Points cannot be the same.");
        }

        for (final DeparturePoint point : departurePoints) {
            if(receivePoint.hasTheSameAddress(point)) {
                final Shipment shipment = new Shipment(shipmentMethod, item, departurePoint, receivePoint, customer);
                this.addShipment(shipment);
                return;
            }
            int lastDP = departurePoints.length;
            if (point.equals(departurePoints[lastDP - 1])) {
                final Shipment shipment = new Shipment(ShipmentMethod.BICYCLE, item, departurePoint, receivePoint, customer);
                this.addShipment(shipment);
            }
        }
    }
    public void deleteDelivery(int shipmentNumber) {
        Long shipmentId = this.shipments[shipmentNumber - 1].getId();
        final int shipmentsNumber = this.shipments.length;
        final Shipment[] newShipments = new Shipment[shipmentsNumber - 1];

        for(int i = 0; i < shipmentsNumber; i++) {
            int j = 0;
            if(!this.shipments[i].getId().equals(shipmentId)) {
                newShipments[j++] = this.shipments[i];
            }
        }
        this.shipments = newShipments;
    }
    public void printDeparturePoint() {
        for(final DeparturePoint departurePoint : departurePoints ) {
            System.out.println(departurePoint);
        }
    }
    public void printShipments() {
        for(final Shipment shipment : this.shipments) {
            System.out.println(shipment);
        }
    }
}