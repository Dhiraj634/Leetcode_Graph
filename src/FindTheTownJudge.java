import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FindTheTownJudge {
	public int findJudge(int n, int[][] trust) {
		if(n==1) return 1;
		HashMap<Integer, HashSet<Integer>> trusts = new HashMap<>();
		HashMap<Integer, HashSet<Integer>> trustedBy = new HashMap<>();
		for(int[] temp: trust){
			trusts.putIfAbsent(temp[0], new HashSet<>());
			trustedBy.putIfAbsent(temp[1], new HashSet<>());
			trusts.get(temp[0]).add(temp[1]);
			trustedBy.get(temp[1]).add(temp[0]);
		}
		ArrayList<Integer> suspect = new ArrayList<>();
		for(int i=1;i<=n;i++){
			if(!trusts.containsKey(i)) suspect.add(i);
		}
		for(int judge: suspect){
			if(trustedBy.containsKey(judge) && trustedBy.get(judge).size() == n-1) return judge;
		}
		return -1;
	}
}
