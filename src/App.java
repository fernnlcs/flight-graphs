import java.time.Instant;
import java.util.List;

import core.Flight;
import structures.graph.Graph;
import structures.graph.Vertice;

public class App {
    public static void main(final String[] args) {
        final Graph<Flight> graph = new Graph<>(false);

        final Instant initialDateTime = Instant.parse("2023-05-10T10:00:00Z");

        graph.addVertice(new Flight("Roma", 1, initialDateTime));
        graph.addVertice(new Flight("Madrid", 2, initialDateTime));
        graph.addVertice(new Flight("São Paulo", 1, initialDateTime));
        graph.addVertice(new Flight("Santiago", 2, initialDateTime));
        graph.addVertice(new Flight("Tóquio", 1, initialDateTime));
        graph.addVertice(new Flight("Brasília", 1, initialDateTime));
        graph.identifyConflicts();

        final List<Instant> possibilities = List.of(
            Instant.parse("2023-05-11T10:00:00Z"),
            Instant.parse("2023-05-12T09:00:00Z"),
            Instant.parse("2023-05-13T12:30:00Z"),
            Instant.parse("2023-05-14T14:00:00Z")
        );

        System.out.println();
        graph.resolveColors(possibilities);
        associateWith(graph, possibilities);
    }

    public static void associateWith(final Graph<Flight> graph, final List<Instant> possibilities) {
        System.out.println();
        for (final Vertice<Flight> vertice : graph.getVertices()) {
            vertice.getData().associate(possibilities, vertice.getColor());
            System.out.print(vertice.getData().identify() + ": ");
            System.out.println(vertice.getData().getColorInfo().toString());
        }
    }
}
