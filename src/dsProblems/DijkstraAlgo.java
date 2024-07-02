package dsProblems;


//List implementation, When you represent a graph as a list
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {
	
	public static void main(String[] args) {
		
		int V = 9;
        List<List<AdjacentNode> > graph
            = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new AdjacentNode(1, 4));
        graph.get(0).add(new AdjacentNode(7, 8));
        graph.get(1).add(new AdjacentNode(2, 8));
        graph.get(1).add(new AdjacentNode(7, 11));
        graph.get(1).add(new AdjacentNode(0, 7));
        graph.get(2).add(new AdjacentNode(1, 8));
        graph.get(2).add(new AdjacentNode(3, 7));
        graph.get(2).add(new AdjacentNode(8, 2));
        graph.get(2).add(new AdjacentNode(5, 4));
        graph.get(3).add(new AdjacentNode(2, 7));
        graph.get(3).add(new AdjacentNode(4, 9));
        graph.get(3).add(new AdjacentNode(5, 14));
        graph.get(4).add(new AdjacentNode(3, 9));
        graph.get(4).add(new AdjacentNode(5, 10));
        graph.get(5).add(new AdjacentNode(4, 10));
        graph.get(5).add(new AdjacentNode(6, 2));
        graph.get(6).add(new AdjacentNode(5, 2));
        graph.get(6).add(new AdjacentNode(7, 1));
        graph.get(6).add(new AdjacentNode(8, 6));
        graph.get(7).add(new AdjacentNode(0, 8));
        graph.get(7).add(new AdjacentNode(1, 11));
        graph.get(7).add(new AdjacentNode(6, 1));
        graph.get(7).add(new AdjacentNode(8, 7));
        graph.get(8).add(new AdjacentNode(2, 2));
        graph.get(8).add(new AdjacentNode(6, 6));
        graph.get(8).add(new AdjacentNode(7, 1));
 
        int[] distance = findShortestPathFromSource(V, graph, source);
        // Printing the Output
        System.out.println("Vertex  "
                           + "  Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "             "
                               + distance[i]);
        }
	}
	
	public static int[] findShortestPathFromSource(int V,List<List<AdjacentNode>> graph,int source) {
		int[] distance = new int[V];
		for(int i =0;i<V;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[source] = 0;
		
		PriorityQueue<AdjacentNode> pq = new PriorityQueue<>((a,b)-> 
			a.getWeight() - b.getWeight()
		);
		pq.add(new AdjacentNode(source,0));
		
		while(!pq.isEmpty()) {
			AdjacentNode node = pq.poll();
			for(AdjacentNode current : graph.get(node.getNode())) {
				if(distance[node.getNode()]+current.getWeight() < distance[current.getNode()]) {
					distance[current.getNode()] = distance[node.getNode()] + current.getWeight(); 
					pq.add(new AdjacentNode(current.getNode(),distance[current.getNode()]));
				}
			}
			
		}
		return distance;
		
	}

}
