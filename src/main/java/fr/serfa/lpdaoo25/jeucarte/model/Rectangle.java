package fr.serfa.lpdaoo25.jeucarte.model;


public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(){
        this(10, 35, ShapeColor.BLUE);
    }

    public Rectangle(int width, int height, ShapeColor color) {
        super(color);
        SHAPE_TYPE = ShapeType.RECTANGLE;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getPerimeter() {
        return this.height * 2 + this.width * 2;
    }

    @Override
    public int getArea() {
        return this.height * this.width;
    }
}
