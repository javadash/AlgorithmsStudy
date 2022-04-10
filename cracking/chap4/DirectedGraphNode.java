package chap4;

import java.util.ArrayList;

/**
 * Definition of Directed Graph
 * @author Johnson
 *
 */
public class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbours;
	
	DirectedGraphNode (int x) {
		label = x;
		neighbours = new ArrayList<DirectedGraphNode>();
	}
}
