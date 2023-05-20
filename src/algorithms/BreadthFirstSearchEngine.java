// package algorithms;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Queue;
// import java.util.concurrent.ConcurrentLinkedQueue;

// import structures.graph.Colorable;
// import structures.graph.Edge;
// import structures.graph.Graph;
// import structures.graph.Vertice;

// public class BreadthFirstSearchEngine<Type extends Colorable<Type>> {
//     public void search(Graph<Type> graph) {
//         this.search(graph, 0);
//     }

//     public void search(Graph<Type> graph, int start) {
//         List<Vertice<Type>> visited = new ArrayList<>();
//         Queue<Vertice<Type>> sequence = new ConcurrentLinkedQueue<>();
//         Vertice<Type> first = graph.getVertices().get(start);

//         visited.add(first);
//         System.out.println(first.getData());

//         sequence.add(first);

//         while (sequence.size() > 0) {
//             Vertice<Type> current = sequence.poll();
//             for (Edge<Type> edge : current.getEdgesOut()) {
//                 Vertice<Type> candidate = edge.getDestiny();
//                 if (!visited.contains(candidate)) {
//                     sequence.add(candidate);
//                     visited.add(candidate);
//                     System.out.println(candidate.getData());
//                 }
//             }
//         }
//     }
// }
