class Pyramid extends Shape{
    private double baseArea;
    private double height;

    public Pyramid(double baseArea, double height) {
        this.baseArea = baseArea;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return baseArea + 0.5 * baseArea * height;
    }

    @Override
    public double calculateVolume() {
        return (baseArea * height) / 3.0;
    }
}
