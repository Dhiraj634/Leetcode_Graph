import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindCenterOfStarGraph {
	public int findCenter(int[][] edges) {
		Map<Integer, HashSet<Integer>> graph = new HashMap<>();
		for(int[] edge:edges){
			graph.putIfAbsent(edge[0],new HashSet<>());
			graph.putIfAbsent(edge[1],new HashSet<>());
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		Queue<Integer> queue = new LinkedList<>();
		for(int num: graph.keySet()){
			if(graph.get(num).size() == 1) queue.add(num);
		}
		while(queue.size() > 1){
			int node = queue.poll();
			for(int connectedNode : graph.get(node)){
				graph.get(connectedNode).remove(node);
				if(graph.get(connectedNode).size() ==  1)
					queue.add(connectedNode);
			}
		}
		 return queue.poll();
	}
	/**
	 * The question says that the n-1 edges should connect the centre node to all the other nodes.
	 * So the solution is very easy in such case, and it boils down to
	 *
	 * public int findCenter(int[][] edges) {
	 *    return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
	 * }
	 * */
}
