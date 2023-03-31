package Chap04_Trees_and_Graphs.q04_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q1bfs {
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
		return bfs(s, e);
	}

	private boolean bfs(DirectedGraphNode s, DirectedGraphNode e) {
		if (s == e) {
			return true;
		}
		Queue<DirectedGraphNode> queue = new LinkedList<>();
		Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		queue.offer(s);
		visited.add(s);
		
		while(!queue.isEmpty()) {
			DirectedGraphNode cur = queue.poll();
			if (cur != null) {
				for (DirectedGraphNode neighbour : cur.neighbours) {
					if (neighbour == e) {
						return true;
					}
					if (!visited.contains(neighbour)) {
						queue.offer(neighbour);
						visited.add(neighbour);
					}
				}
			}
		}
		return false;
	}

}
