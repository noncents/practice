package ctci.types;

import java.util.List;

public class GraphNode<V> {

	List<GraphNode<V>> adjacentNodes;
	VisitedState state;

	V data;

	public GraphNode(V data, List<GraphNode<V>> adjacentNodes) {

		this.data = data;
		this.adjacentNodes = adjacentNodes;
		state = VisitedState.Unvisited;
	}

	public List<GraphNode<V>> getAdjacentNodes() {

		return adjacentNodes;
	}

	public VisitedState getState() {

		return state;
	}

	public void setState(VisitedState state) {

		this.state = state;
	}

	public V getData() {

		return data;
	}

	public void setData(V data) {

		this.data = data;
	}

	private enum VisitedState {
		Unvisited,
		Visited,
		Visiting;
	}
}
