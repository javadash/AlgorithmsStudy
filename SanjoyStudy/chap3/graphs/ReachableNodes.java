package chap3.graphs;

public class ReachableNodes {
	public static void main(String[] args) {
        int vertices = 7; // Number of vertices in the graph
        Graph graph = new Graph(vertices);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        int startNode = 0; // Start exploring from node 0
        System.out.println("Reachable nodes from node " + startNode + ":");
        graph.findAllReachableNodes(startNode);
    }
}
