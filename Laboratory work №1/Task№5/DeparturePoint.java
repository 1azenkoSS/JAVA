package org.example;

public class DeparturePoint extends DeliveryPoint{
    private Long id = 0L;
    public DeparturePoint(final Long id, final String oblast,final String region,final String settlements,final String street,final int building) {
        super(oblast, region, settlements, street, building);
        this.id = id;
    }

    @Override
    public boolean hasTheSameAddress(DeliveryPoint point) {
        return super.hasTheSameAddress(point);
    }

    @Override
    public String toString() {
        return String.format("DP №%d: ", this.id) + super.toString();
    }
}