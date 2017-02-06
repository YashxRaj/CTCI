package treesAndGraphs;

import java.util.Vector;

public class Graph {

	public static class GraphNode {
		enum state {
			unvisited, visiting, visited;
		}

		public String name;
		Vector<GraphNode> children;
		public state state;

		public GraphNode(String name) {
			super();
			this.name = name;
			this.children = null;
		}
	}

	public Vector<GraphNode> listOfNodes;

	public void createGraphNode(String name) {
		GraphNode gn = new GraphNode(name);
		listOfNodes.add(gn);
	}

	public boolean connectGraphNodes(GraphNode gn, GraphNode gn2, boolean directed) {
		if (!(listOfNodes.contains(gn) && listOfNodes.contains(gn2)))
			return false;
		else {
			gn.children.addElement(gn2);
			if (!(directed))
				gn2.children.addElement(gn);
			return true;
		}
	}

	public Vector<GraphNode> getAdjacent(GraphNode gn) {
		if (listOfNodes.contains(gn) == false)
			return null;
		else
			return gn.children;
	}

	public void generateRandomGraphNodes(int numberOfNodes) {
		int nameInt = 65;
		for (int i = 0; i < numberOfNodes; i++) {
			GraphNode gn = new GraphNode(Character.toString((char) nameInt++));
			listOfNodes.addElement(gn);
		}
	}

	public void connectRandomGraphNodes(boolean directed) {
		for (int i = 0; i < listOfNodes.size(); i++) {
			if (0.85 > Math.random())
				do {
					listOfNodes.get(i).children.addElement(randomGraphNode(i));
				} while (0.5 < Math.random());
			for (int j = 0; j < listOfNodes.size(); j++)
				if (listOfNodes.get(i).children.contains(j) == true) {
					if (!directed)
						listOfNodes.get(j).children.addElement(listOfNodes.get(i));
					else if (0.5 < Math.random())
						listOfNodes.get(j).children.addElement(listOfNodes.get(i));
				}
		}
	}

	public GraphNode randomGraphNode(int i) {
		int e = (int) (Math.random() * listOfNodes.size());
		return e == i ? randomGraphNode(i) : listOfNodes.get(e);
	}

	public void printAdjacencyList() {
		StringBuffer s = new StringBuffer();
		for (GraphNode n : listOfNodes) {
			s.append(n.name + " : ");
			int i = 0;
			for (GraphNode child : n.children) {
				s.append(child.name + " ");
				i++;
			}
			s.append(System.lineSeparator());
		}
		System.out.println(s.toString());
	}
}
