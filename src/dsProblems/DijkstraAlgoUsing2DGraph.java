package dsProblems;

import java.util.PriorityQueue;

public class DijkstraAlgoUsing2DGraph {
	
	public static void main(String[] args) {
		 /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        DijkstraAlgoUsing2DGraph t = new DijkstraAlgoUsing2DGraph();
        int[] distance = t.findShortestPathFromSource(graph, 0);
     // Printing the Output
        System.out.println("Vertex  "
                           + "  Distance from Source");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "             "
                               + distance[i]);
        }
		
	}
	
	public int[] findShortestPathFromSource(int[][] graph, int source) {
		int[] distance = new int[graph.length];
		for(int i=0;i<distance.length;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[source] = 0;
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->
			a[1] - b[1]
		);
		queue.add(new int[] {source,0});
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int i = node[0];
			for(int j=0;j<graph[i].length;j++) {
				if(graph[i][j] == 0)
					continue;
				if(distance[i]+graph[i][j] < distance[j]) {
					distance[j] = distance[i] + graph[i][j];
					queue.add(new int[] {j,distance[j]});
				}		
			}
				
		}
		return distance;
		
	}

}
