import java.time.Instant;
import java.util.List;

import core.Flight;
import structures.graph.Graph;
import structures.graph.Vertice;

public class App {
    public static void main(String[] args) {
        Graph<Flight> graph = new Graph<>(false);

        Instant initialDateTime = Instant.parse("2023-05-10T10:00:00Z");

        graph.addVertice(new Flight("roma", 1, initialDateTime));
        graph.addVertice(new Flight("madrid", 2, initialDateTime));
        graph.addVertice(new Flight("saoPaulo", 1, initialDateTime));
        graph.addVertice(new Flight("santiago", 2, initialDateTime));
        graph.addVertice(new Flight("toquio", 1, initialDateTime));
        graph.addVertice(new Flight("brasilia", 1, initialDateTime));
        graph.identifyConflicts();

        List<Instant> possibilities = List.of(
            Instant.parse("2023-05-11T10:00:00Z"),
            Instant.parse("2023-05-12T10:00:00Z"),
            Instant.parse("2023-05-13T10:00:00Z"),
            Instant.parse("2023-05-14T10:00:00Z")
        );

        System.out.println();
        graph.resolveColors(possibilities);
        associateWith(graph, possibilities);
    }

    public static void associateWith(Graph<Flight> graph, List<Instant> possibilities) {
        System.out.println();
        for (Vertice<Flight> vertice : graph.getVertices()) {
            vertice.getData().associate(possibilities, vertice.getColor());
            System.out.print(vertice.getData().identify() + ": ");
            System.out.println(vertice.getData().getColorInfo().toString());
        }
    }
}
