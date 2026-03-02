package fr.serfa.lpdaoo25.jeucarte.model;


public abstract class Shape {

    protected Long id;

    protected ShapeType SHAPE_TYPE;

    private ShapeColor color;

    public Shape() {
        this.color = ShapeColor.BLACK;
    }

    public Shape(ShapeColor color) {
        this.color = color;
    }


    //TODO remove this setter when we have a proper database
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public ShapeColor getColor() {
        return color;
    }

    public abstract int getPerimeter();
    public abstract int getArea();

    public abstract int getWidth();
    public abstract int getHeight();

    public ShapeType getType() {
        return this.SHAPE_TYPE;
    }

    @Override
    public String toString() {
        return "Shape{" +
                id +
                ", " + SHAPE_TYPE +
                ", " + color +
                '}';
    }

    public enum ShapeType {
        CIRCLE,
        RECTANGLE,
        TRIANGLE,
        SQUARE,
        HEXAGON,
        PENTAGON;

        public static int size() {
            return values().length;
        }

        public static ShapeType getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    public enum ShapeColor {
        RED,
        GREEN,
        BLUE,
        YELLOW,
        BLACK,
        ORANGE,
        PURPLE,
        PINK,
        BROWN,
        GREY;

        public static int size() {
            return values().length;
        }

        public static ShapeColor getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

}
