package structures.graph;

public class Edge<Data extends Colorable<Data, ?>> {
    private Double weight;
    private final Vertice<Data> origin;
    private final Vertice<Data> destiny;
    
    public Edge(final Double weight, final Vertice<Data> origin, final Vertice<Data> destiny) {
        this.weight = weight;
        this.origin = origin;
        this.destiny = destiny;

        origin.addEdgeOut(this);
        destiny.addEdgeIn(this);
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(final Double weight) {
        this.weight = weight;
    }

    public Vertice<Data> getOrigin() {
        return origin;
    }

    public Vertice<Data> getDestiny() {
        return destiny;
    }
}
