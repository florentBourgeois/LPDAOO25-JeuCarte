package fr.serfa.lpdaoo25.jeucarte.model;


public class Triangle extends Shape {

    private int base;
    private int height;

    public Triangle() {
        this(10, 5);
    }

    public Triangle(int base, int height) {
        this(base, height, ShapeColor.RED);
    }

    public Triangle(int base, int height, ShapeColor color) {
        super(color);
        SHAPE_TYPE = ShapeType.TRIANGLE;
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return this.base;
    }

    @Override
    public int getPerimeter() {
        return (int) (this.base + Math.sqrt(Math.pow(this.base, 2) + 4 * Math.pow(this.height, 2)));
    }

    @Override
    public int getArea() {
        return this.base * this.height / 2;
    }
}
