package june2020;

import java.util.*;

public class TwoCitySchedule {
	
	public static int twoCitySchedCost(int[][] costs) {
        Comparator<int[]> comp = (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
        Arrays.sort(costs, comp);
        int cA = 0, cB = 0, res = 0, N = costs.length/2;
        for(int i = 0; i < costs.length ; i++){
        	System.out.println(Arrays.toString(costs[i]));
            if((costs[i][0] < costs[i][1] && cA < N) || cB == N ){
                res += costs[i][0];
                cA++;
            }else{
                res += costs[i][1];
                cB++;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[][] costs = {{10,20},{30,200},{400,50},{30,20},{40,50},{30,200},{400,50},{30,20}};
		System.out.println(twoCitySchedCost(costs));
	}

}
