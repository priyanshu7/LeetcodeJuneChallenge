package june2020;

public class UniqueBST {
	
	public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            int temp = i-1, sum = 0;
            for(int j = 0; j < i; j++){
                sum += dp[j] * dp[temp];
                temp--;
            }
            dp[i] = sum;
        }
        return dp[n];
    }

}
