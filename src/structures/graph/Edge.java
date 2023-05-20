package structures.graph;

public class Edge<Data extends Colorable<Data, ?>> {
    private Double weight;
    private Vertice<Data> origin;
    private Vertice<Data> destiny;
    
    public Edge(Double weight, Vertice<Data> origin, Vertice<Data> destiny) {
        this.weight = weight;
        this.origin = origin;
        this.destiny = destiny;

        origin.addEdgeOut(this);
        destiny.addEdgeIn(this);
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Vertice<Data> getOrigin() {
        return origin;
    }

    public Vertice<Data> getDestiny() {
        return destiny;
    }
}
