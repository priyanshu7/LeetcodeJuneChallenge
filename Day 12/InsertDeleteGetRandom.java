package june2020;

import java.util.*;

public class InsertDeleteGetRandom {
	
	class RandomizedSet {
	    
	    HashMap<Integer, Integer> idxMap;
	    ArrayList<Integer> list;
	    Random random;

	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        idxMap = new HashMap<>();
	        list = new ArrayList<>();
	        random = new Random();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(idxMap.containsKey(val))
	            return false;
	        list.add(val);
	        idxMap.put(val, list.size()-1);
	        return true;        
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!idxMap.containsKey(val))
	            return false;
	        int idx = idxMap.get(val);
	        Collections.swap(list, idx, list.size()-1);
	        idxMap.put(list.get(idx), idx);
	        list.remove(list.size()-1);
	        idxMap.remove(val);
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        int idx = random.nextInt(list.size());
	        return list.get(idx);
	    }
	}

}
