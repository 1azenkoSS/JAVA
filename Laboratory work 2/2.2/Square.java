class Square extends Shape{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculateVolume() {
        return 0.0; // Квадрат не має об'єму
    }
}
