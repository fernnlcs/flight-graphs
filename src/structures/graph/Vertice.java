package structures.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertice<Data extends Colorable<Data, ?>> implements Comparable<Vertice<Data>> {
    private Data data;
    private Color color = null;
    private final List<Edge<Data>> edgesIn = new ArrayList<>();
    private final List<Edge<Data>> edgesOut = new ArrayList<>();
    
    public Vertice(final Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(final Data data) {
        this.data = data;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public List<Edge<Data>> getEdgesIn() {
        return edgesIn;
    }

    public List<Edge<Data>> getEdgesOut() {
        return edgesOut;
    }

    public void addEdgeIn(final Edge<Data> edge) {
        this.edgesIn.add(edge);
    }

    public void addEdgeOut(final Edge<Data> edge) {
        this.edgesOut.add(edge);
    }

    public int getInDegree() {
        return edgesIn.size();
    }

    public int getOutDegree() {
        return edgesOut.size();
    }

    public int getDegree() {
        return getOutDegree();
    }

    @Override
    public int compareTo(final Vertice<Data> other) {
        return Integer.compare(other.edgesOut.size(), edgesOut.size());
    }
}
