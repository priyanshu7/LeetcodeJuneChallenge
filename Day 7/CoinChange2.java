package june2020;

public class CoinChange2 {
	
	public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for(int i = 1; i < dp.length; i++) {
        	dp[i][0] = 1;
        	for(int j = 1; j <= amount; j++) {
        		dp[i][j] = dp[i-1][j] + ((j  >= coins[i - 1])? dp[i][j - coins[i-1]] : 0);
        	}
        }
        return dp[coins.length][amount];
    }
	
	public static int changeOneDimensionalArray(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int c : coins) {
        	for(int j = c; j <= amount; j++) {
        		dp[j] += dp[j-c];
        	}
        }
        return dp[amount];
    }
	
}

