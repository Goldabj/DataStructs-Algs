package graphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * This class implements an undirected graph to which edges can be added
 * randomly. It's for experimenting with the theory of random graphs, developed
 * by Paul Erdos and Alfred Renyi in 1959.
 * 
 * @author Brendan Goldacker
 */
public class RandomGraph {
	// TODO: add any necessary fields and classes for your chosen representation
	private Vertex[] verticies;

	class Vertex {
		int label;
		ArrayList<Vertex> neighbors;

		public Vertex(int label2) {
			this.label = label2;
			this.neighbors = new ArrayList<>();
		}

		@Override
		public String toString() {
			StringBuilder string = new StringBuilder();
			string.append(this.label);
			string.append(": ");
			for (Vertex neighbor : this.neighbors) {
				string.append(neighbor.label + " ");
			}
			return string.toString().trim();
		}

	}

	/**
	 * Constructs a new graph of the given size with no edges.
	 * 
	 * @param size
	 */
	public RandomGraph(int size) {
		this(size, new int[][] {});
	}

	/**
	 * Constructs a new graph of the given size with the given edges
	 * 
	 * @param size
	 * @param edges
	 *            each element is a pair giving the indices of the two nodes to
	 *            be connected
	 */
	public RandomGraph(int size, int[][] edges) {
		this.verticies = new Vertex[size];
		for (int i = 0; i < size; i++) {
			this.verticies[i] = new Vertex(i);
		}

		for (int[] edge : edges) {
			int v1 = edge[0];
			int v2 = edge[1];
			this.verticies[v1].neighbors.add(this.verticies[v2]);
			this.verticies[v2].neighbors.add(this.verticies[v1]);
		}
	}

	/**
	 * @return the size of the largest connected component of this graph
	 */
	public int largestConnectedComponentSize() {
		boolean[] visited = new boolean[this.verticies.length];
		
		int max = -1;
		for(Vertex v : this.verticies) {
			int compSize = componentSize(v, visited);
			if(compSize > max) {
				max = compSize;
			}
		}
		return max;
	}

	private int componentSize(Vertex v, boolean[] visited) {
		Stack<Vertex> stack = new Stack<>();
		stack.push(v);
		int size = 0;
		Vertex current = stack.pop();
		size++;
		visited[current.label] = true;
		stack.push(v);
		
		while(!stack.isEmpty()) {
			current = stack.pop();
			for(Vertex neighbor : current.neighbors) {
				if(!visited[neighbor.label]) {
					visited[neighbor.label] = true;
					size++;
					stack.push(neighbor);		
				}
			}
		}
		return size;
	}

	/**
	 * Adds a new edge, chosen uniformly from the set of missing edges.
	 * 
	 * @throws IllegalStateException
	 *             if this.isComplete()
	 */
	public void addRandomEdge() throws IllegalStateException {
		// TODO: implement this method
	}

	/**
	 * Returns whether this graph is connected, that is, whether there is a path
	 * from any node in the graph to any other node.
	 * 
	 * @return true iff this graph is connected
	 */
	public boolean isConnected() {
		// TODO: implement this method
		return false;
	}

	/**
	 * Returns whether this graph is complete, that is, any two distinct
	 * vertices are neighbors of each other.
	 * 
	 * @return true iff this graph is complete
	 */
	public boolean isComplete() {
		// TODO: implement this method
		return false;
	}

	@Override
	public String toString() {
		/*
		 * TODO: Implement this method by replacing the super call with code to
		 * create a "reasonable" string representation of the Graph. Any
		 * representation that helps you debug the other methods is fine.
		 */
		StringBuilder string = new StringBuilder();
		for (Vertex v : verticies) {
			string.append(v.toString());
			string.append("\n");
		}
		
		return string.toString();
	}
}
