package EncapsulationExercise.ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double calculateSurfaceArea() {
        return (2 * getLength() * getWidth()) + (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
    }

    public double calculateLateralSurfaceArea() {
        return (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
    }

    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }
}
