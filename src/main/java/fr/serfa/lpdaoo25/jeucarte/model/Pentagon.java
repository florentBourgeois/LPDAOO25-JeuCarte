package fr.serfa.lpdaoo25.jeucarte.model;

public class Pentagon extends Shape {
    private int cote;

    public Pentagon() {
        this(17, ShapeColor.BLACK);
    }

    public Pentagon(int cote, ShapeColor color) {
        super(color);
        SHAPE_TYPE = SHAPE_TYPE.PENTAGON;
        this.cote = cote;
    }

    @Override
    public int getWidth() {
        return (int) (1+Math.sqrt(3)*this.cote / 2); // TODO : due to int this is not the width of a pentagon
    }

    @Override
    public int getHeight() {
        return (int) (1.539 *this.cote); // TODO : due to int  this is not the height of a pentagon
    }

    @Override
    public int getPerimeter() {
        return (int) (this.cote * 5);
    }

    @Override
    public int getArea() {
        return (int) (1.72 * this.cote * this.cote); // TODO : due to int this is not the area of a pentagon
    }

}
