package june2020;

import java.util.*;

public class ReconstructItinerary {
	
	Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
	    if (!map.containsKey(ticket.get(0))) {
		map.put(ticket.get(0), new PriorityQueue<String>());
	    }
	    map.get(ticket.get(0)).offer(ticket.get(1));
	}
	dfs("JFK");
	return result;
    }
    
    public void dfs(String s) {
	PriorityQueue<String> pq = map.get(s);
	while (pq != null && !pq.isEmpty()) {
	    dfs(pq.poll());
	}
 	result.addFirst(s);
    }

}
