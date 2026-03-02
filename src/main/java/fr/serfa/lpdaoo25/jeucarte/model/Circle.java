package fr.serfa.lpdaoo25.jeucarte.model;

public class Circle extends Shape {
    private int radius;

    public Circle() {
        this(17, ShapeColor.BLACK);
    }

    public Circle(int radius, ShapeColor color) {
        super(color);
        SHAPE_TYPE = SHAPE_TYPE.CIRCLE;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public int getWidth() {
        return this.radius * 2;
    }

    @Override
    public int getHeight() {
        return this.radius * 2;
    }

    @Override
    public int getPerimeter() {
        return (int) (2 * Math.PI * this.radius);
    }

    @Override
    public int getArea() {
        return (int) (Math.PI * Math.pow(this.radius, 2));
    }

}
