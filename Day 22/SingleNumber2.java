package june2020;

import java.util.*;

public class SingleNumber2 {
	
	 public int singleNumber(int[] nums) {
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int num : nums){
	            map.put(num, map.getOrDefault(num,0) + 1);
	        }
	        for(int key : map.keySet()){
	            if(map.get(key) == 1){
	                return key;
	            }
	        }
	        return -1;
	    }
	 
	 public int singleNumber2(int[] nums) {
	        int ans = 0; 
	        int count;
	        for(int i=0; i<32; i++){   
	            count = 0;  
	            for(int j=0; j<nums.length; j++){ 
	                if((nums[j] & (1<<i)) != 0) 
	                    count++; 
	            }  
	            if ((count % 3) != 0) 
	                ans |= (1<<i); 
	        } 
	        return ans;
	    }

}
