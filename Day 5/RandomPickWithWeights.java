package june2020;

import java.util.*;

public class RandomPickWithWeights {
	
	int[] arr;
    Random rand = new Random();

    public void Solution(int[] w) {
        int[] temp = new int[w.length];
        temp[0] = w[0];
        for(int i = 1; i < w.length; i++){
            temp[i] = w[i] + temp[i-1];
        }
        this.arr = temp;
    }
    
    public int pickIndex() {
        int r = rand.nextInt(arr[arr.length - 1]) + 1;
        int lo = 0, hi = arr.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] < r)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

}
