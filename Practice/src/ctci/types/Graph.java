package ctci.types;

import java.util.List;

public class Graph<V> {

	List<GraphNode<V>> _nodes;

	public List<GraphNode<V>> getNodes() {

		return _nodes;
	}

	public void setNodes(List<GraphNode<V>> nodes) {

		this._nodes = nodes;
	}

}
