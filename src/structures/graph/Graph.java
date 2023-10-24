package structures.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Graph<Data extends Colorable<Data, ?>> {
    private final boolean isOriented;
    private List<Vertice<Data>> vertices = new ArrayList<>();
    private List<Edge<Data>> edges = new ArrayList<>();

    public Graph() {
        this.isOriented = true;
    }

    public Graph(final boolean isOriented) {
        this.isOriented = isOriented;
    }

    public List<Vertice<Data>> getVertices() {
        return vertices;
    }

    public void setVertices(final List<Vertice<Data>> vertices) {
        this.vertices = vertices;
    }

    public List<Edge<Data>> getEdges() {
        return edges;
    }

    public void setEdges(final List<Edge<Data>> edges) {
        this.edges = edges;
    }

    public Vertice<Data> addVertice(final Data data) {
        Vertice<Data> vertice = new Vertice<>(data);
        this.vertices.add(vertice);

        return vertice;
    }

    public Edge<Data> addEdge(final Double weight, final Vertice<Data> origin, final Vertice<Data> destiny) {
        Edge<Data> edge = new Edge<>(weight, origin, destiny);
        this.edges.add(edge);

        if (!isOriented) {
            Edge<Data> reverseEdge = new Edge<>(weight, destiny, origin);
            this.edges.add(reverseEdge);
        }

        return edge;
    }

    public void identifyConflicts() {
        for (int i = 0; i < vertices.size(); i++) {
            Vertice<Data> vertice = vertices.get(i);

            for (int j = i + 1; j < vertices.size(); j++) {
                Vertice<Data> neighbor = vertices.get(j);

                if (vertice.getData().hasConflictWith(neighbor.getData())) {
                    addEdge(1.0, vertice, neighbor);
                    System.out.print("Conflito identificado: ");
                    System.out.println(vertice.getData().identify() + " x " + neighbor.getData().identify());
                }
            }
        }

        vertices.sort(new Comparator<Vertice<Data>>() {
            @Override
            public int compare(Vertice<Data> o1, Vertice<Data> o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public void resolveColors(final List<?> possibilities) {
        final Color[] colors = Color.values();

        for (Vertice<Data> vertice : vertices) {
            boolean isPending = true;

            for (int i = 0; i < colors.length && isPending; i++) {
                Color color = colors[i];
                List<Edge<Data>> neighbors = vertice.getEdgesOut();
                boolean isAvailable = true;

                for (int j = 0; j < neighbors.size() && isAvailable; j++) {
                    Vertice<Data> neighbor = neighbors.get(j).getDestiny();
                    if (neighbor.getColor() != null && neighbor.getColor().equals(color)) {
                        isAvailable = false;
                    }
                }

                if (isAvailable) {
                    vertice.setColor(color);
                    isPending = false;

                    System.out.println(vertice.getData().identify() + ": " + color.name());
                }
            }

            if (isPending) {
                throw new RuntimeException("Precisa de mais possibilidades.");
            }
        }
    }
}
