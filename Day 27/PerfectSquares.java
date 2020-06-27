package june2020;

import java.util.*;

public class PerfectSquares {
	
	public int numSquaresDP(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
	
	
	
	protected boolean isSquare(int n) {
	    int sq = (int) Math.sqrt(n);
	    return n == sq * sq;
	  }

	  public int numSquares(int n) {
	    while (n % 4 == 0)
	      n /= 4;
	      
	    if (n % 8 == 7)
	      return 4;

	    if (this.isSquare(n))
	      return 1;

	    for (int i = 1; i * i <= n; ++i) {
	      if (this.isSquare(n - i * i))
	        return 2;
	    }

	    return 3;
	  }

}
