import java.util.ArrayList;

public class FindIfPathExistsInGraph {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(edges.length == 0) return start == end;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return dfs(start,end);

    }
    private boolean dfs(int currNode, int end){
        if(currNode == end) return true;
        if(visited[currNode]) return false;
        visited[currNode] = true;
        for(int nextNode: graph.get(currNode)){
            boolean ans = dfs(nextNode, end);
            if(ans) return true;
        }
        return false;
    }
}
