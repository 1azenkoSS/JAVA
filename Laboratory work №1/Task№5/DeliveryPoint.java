package org.example;

public class DeliveryPoint {
    private final String oblast;
    private final String region;
    private final String settlements;
    private final String street;
    private final int building;
    public DeliveryPoint(final String oblast, final String region, final String settlements,
                         final String street, final int building) {
        this.oblast = oblast;
        this.building = building;
        this.street = street;
        this.region = region;
        this.settlements = settlements;
    }

    public boolean hasTheSameAddress(DeliveryPoint point) {
        return this.oblast.equals(point.oblast) && this.region.equals(point.region)
                && this.settlements.equals(point.settlements) && this.street.equals(point.street)
                && this.building == point.building;
    }

    @Override
    public String toString() {
        return "oblast='" + oblast + '\'' +
                ", region='" + region + '\'' +
                ", settlements='" + settlements + '\'' +
                ", street='" + street + '\'' +
                ", building=" + building;
    }
}