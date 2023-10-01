package org.example;

public class Item {
    private final String name;
    private final double weight;
    private final double size;

    public Item(final String name, final double weight, final double size) {
        this.name = name;
        this.weight = weight;
        this.size = size;
    }
    public double getWeight() {
        return this.weight;
    }
    public double getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", size=" + size +
                '}';
    }

}