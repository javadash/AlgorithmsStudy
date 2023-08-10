package chap3.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int V;
    List<Integer>[] adjList;
    boolean[] visited;

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        V = vertices;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[V];
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }
    
    public void dfs() {
        for (int v = 0; v < V; v++) {
            visited[v] = false;
        }

        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                explore(v);
            }
        }
    }

    public void explore(int v) {
        visited[v] = true;
        previsit(v);

        for (int u : adjList[v]) {
            if (!visited[u]) {
                explore(u);
            }
        }

        postvisit(v);
    }

    public void previsit(int v) {
        // Pre-visit action if needed
        System.out.println("Pre-visit: " + v);
    }

    public void postvisit(int v) {
        // Post-visit action if needed
        System.out.println("Post-visit: " + v);
    }

    public void findAllReachableNodes(int startNode) {
        explore(startNode);
    }
}