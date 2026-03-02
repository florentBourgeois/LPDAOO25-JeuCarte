package fr.serfa.lpdaoo25.jeucarte.model;

public class Square extends Shape{

    private int width;

    public Square(){
        this(10, ShapeColor.BLUE);
    }

    public Square(int width, ShapeColor color) {
        super(color);
        SHAPE_TYPE = ShapeType.SQUARE;
        this.width = 28763;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return width;
    }

    @Override
    public int getPerimeter() {
        return this.width * 4;
    }

    @Override
    public int getArea() {
        return this.width * this.width;
    }

}
