package com.data.structures;

import java.util.*;

public class UndirectedGraph {
	int nodes;
	Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
	
	
	
	public UndirectedGraph(int nodes) {
		this.nodes = nodes;
		
	}
	
	public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }
	
	public void insertEdge(int u, int v) {
		List<Integer> connectedVertices = adjacencyList.get(u);
		if (connectedVertices == null) {
			adjacencyList.put(u, new ArrayList<Integer>(){{ add(v); }});
		} else {
			connectedVertices.add(v);
		}
		
		connectedVertices = adjacencyList.get(v);
		if (connectedVertices == null) {
			adjacencyList.put(u, new ArrayList<Integer>(){{ add(v); }});
		} else { 
			connectedVertices.add(v);
		}
	}
	
	public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }
	
	/* uses a breadth-first search (BFS) algorithm to traverse the graph starting from the specified node. 
	 * It maintains a visited set to keep track of the nodes that have already been visited, 
	 * and a queue to store the nodes that need to be visited in the next level.
	 */
	
	
	public List<Integer> getReachableNodes(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
        	Integer curr = queue.poll();
            result.add(curr);
            if (adjacencyList.get(curr) != null) {
	            for (Integer neighbor : adjacencyList.get(curr)) {
	                if (!visited.contains(neighbor)) {
	                    visited.add(neighbor);
	                    queue.add(neighbor);
	                }
	            }
            }
        }

        return result;
    }
 	
	
	public List<Integer> getReachableNodesRecursive(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(start, visited, result);
        return result;
    }

    private void dfs(int curr, Set<Integer> visited, List<Integer> result) {
    	if (adjacencyList.get(curr) == null) return;
        visited.add(curr);
        result.add(curr);
        for (Integer neighbor : adjacencyList.get(curr)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, result);
            }
        }
    }
	
	public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int vertex = entry.getKey();
            List<Integer> neighbors = entry.getValue();
            System.out.print("Vertex " + vertex + ": ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

}
