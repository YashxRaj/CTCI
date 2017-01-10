package treesAndGraphs;

public class GraphNode {
	enum state {
		unvisited, visiting, visited;
	}

	public String name;
	public Boolean[] children;
	public int numNodes;
	public state state;

	public GraphNode(String name, int l) {
		numNodes = l;
		children = new Boolean[numNodes];
		for (int i = 0; i < children.length; i++)
			children[i] = false;
		this.name = name;
	}

	public Boolean add(int i) {
		if (i < numNodes)
			children[i] = true;
		else
			System.out.println("Cannot add more links to this node!");
		return children[i];
	}
}
