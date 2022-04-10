package chap4;

import java.util.ArrayList;
import java.util.HashSet;

public class Q1dfs {
	/**
	 * @param graph:
	 *            A list of Directed graph Nodes
	 * @param s:
	 *            the starting Directed graph node
	 * @param e:
	 *            the ending Directed graph node
	 * @return a boolan value
	 */
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode e) {
		return dfs(s, e, new HashSet<DirectedGraphNode>());
	}

	private boolean dfs(DirectedGraphNode s, DirectedGraphNode e, HashSet<DirectedGraphNode> visited) {
		if (s == e)
			return true;
		visited.add(s);
		for (DirectedGraphNode neighbor : s.neighbours) {
			if (!visited.contains(neighbor)) {
				if (dfs(neighbor, e, visited)) {
					return true;
				}
			}
		}
		return false;
	}

}