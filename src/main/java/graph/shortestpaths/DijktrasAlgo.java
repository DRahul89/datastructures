package main.java.graph.shortestpaths;

/**
 * algo is similar to prim's algo create a set sptset(shortest path set) assign
 * distance to all the vertices assign INF distance at starting to all except
 * the source assign 0 distance value to source assign distance now pick min
 * dist value node and for each adjacent vertices relax each edge(u,v) vertex
 * for which dis[v] > dist[u]+ w(u,v) again take min distance value node and
 * repeat this step till spt contains all the node
 * 
 * @author rdixi7
 *
 */
public class DijktrasAlgo {

	private static int minDistanceNode(int[] dist,boolean[] spt) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] < min && spt[i] == false) {
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	/**
	 * Dijkstras Shortest path algo
	 * 
	 * @param graph
	 * @param source
	 */
	public static void dijktrasAlgoForMatrix(int[][] graph, int source) {
		boolean[] spt = new boolean[graph.length];
		int[] dist = new int[graph.length];
		int[] parent = new int[graph.length];
		for (int i = 0; i < graph.length; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[source] = 0;
		parent[source] = -1;
		for (int i = 0; i < graph.length ; i++) {
			int selectedNode = minDistanceNode(dist,spt);
			spt[selectedNode] = true;
			for (int j = 0; j < graph[selectedNode].length; j++) {
				if (!spt[j] && (graph[selectedNode][j] != 0) && (dist[selectedNode] != Integer.MAX_VALUE)
						&& (dist[j] > dist[selectedNode] + graph[selectedNode][j])) {
					dist[j] = dist[selectedNode] + graph[selectedNode][j];
					parent[j]=selectedNode;
				}
			}
		}
		printShortestPath(dist, source ,parent);
	}

	private static void printShortestPath(int[] dist, int source, int[] parent) {
		for (int i = 0; i < dist.length; i++) {
			System.out.println("shortest path length for vertes " + i + " from " + source + " is " + dist[i] + " with path "); 
			printPath(parent,i,source);
			System.out.println();
		}

	}

	private static void printPath(int[] parent,int node,int source) {
		if(node == -1){
			return;
		}
		printPath(parent, parent[node], source);
		System.out.print(node + " ");
	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 0, 10, 0, 2, 0, 0 }, { 0, 0, 0, 14, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		dijktrasAlgoForMatrix(graph, 0);

	}

}
