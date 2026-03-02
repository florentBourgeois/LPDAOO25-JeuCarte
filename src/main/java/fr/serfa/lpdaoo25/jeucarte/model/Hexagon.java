package fr.serfa.lpdaoo25.jeucarte.model;


public class Hexagon extends Shape {
    private int cote;

    public Hexagon() {
        this(17, ShapeColor.BLACK);
    }

    public Hexagon(int cote, ShapeColor color) {
        super(color);
        SHAPE_TYPE = SHAPE_TYPE.HEXAGON;
        this.cote = cote;
    }

    @Override
    public int getWidth() {
        return this.cote * 2;
    }

    @Override
    public int getHeight() {
        return this.cote * 2;
    }

    @Override
    public int getPerimeter() {
        return (int) (this.cote * 6);
    }

    @Override
    public int getArea() {
        return 3 * (int) (Math.sqrt(3) * Math.pow(this.cote, 2)) / 2;
    }

}
