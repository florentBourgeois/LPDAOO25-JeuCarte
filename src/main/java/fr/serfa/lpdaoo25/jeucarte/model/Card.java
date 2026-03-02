package fr.serfa.lpdaoo25.jeucarte.model;


import java.util.Set;

public class Card {


    private Long id;

    private Set<Shape> shapes;

    //TODO remove this setter when we have a proper database
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Card(Set<Shape> shapes) {
        this.shapes = shapes;
    }

    public Card() {

    }

    public Set<Shape> getShapes() {
        return shapes;
    }

    public boolean contains(Shape shape) {
        return this.shapes.contains(shape);
    }


    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", shapes=" + shapes +
                '}';
    }

    public Shape getShapeById(Long playedShapeID) {
        return this.shapes.stream()
                .filter(shape -> shape.getId().equals(playedShapeID))
                .findFirst()
                .orElse(null);
    }
}
