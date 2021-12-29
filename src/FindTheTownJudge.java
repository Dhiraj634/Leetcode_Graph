public class FindTheTownJudge {
	public int findJudge(int n, int[][] trust) {
		if(n==1) return 1;
		int[] trusts = new int[n+1];
		int[] trustedBy = new int[n+1];
		for(int[] temp: trust){
			trustedBy[temp[1]]++;
			trusts[temp[0]]++;
		}
		for(int i=1;i<=n;i++){
			if(trusts[i]==0 && trustedBy[i] == n-1)
			{
				return i;
			}
		}
		return -1;
	}
}
