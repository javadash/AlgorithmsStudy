package Chap04_Trees_and_Graphs.q04_01;

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
	
	public void addAdjacent(DirectedGraphNode x) {
		this.neighbours.add(x);
	}
	
	public ArrayList<DirectedGraphNode> getAdjacent() {
        return neighbours;
    }
}
