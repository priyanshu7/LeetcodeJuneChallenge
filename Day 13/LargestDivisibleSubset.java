package june2020;

import java.util.*;

public class LargestDivisibleSubset {
	
	public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return new ArrayList<Integer>();
        int[] divDP = new int[n];
        Arrays.fill(divDP, 1);
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        Arrays.sort(nums);
        int maxIdx = 0;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && divDP[i] < divDP[j] + 1){
                    prev[i] = j;
                    divDP[i] = divDP[j] + 1;
                }
            }
            
            if(divDP[maxIdx] < divDP[i]){
                maxIdx = i;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int k = maxIdx;
        while(k >= 0){
            ans.add(nums[k]);
            k = prev[k];
        }
        
        return ans;
    }

}
