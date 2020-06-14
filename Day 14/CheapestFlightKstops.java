package june2020;

import java.util.*;

public class CheapestFlightKstops {
		
	
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, Map<Integer,Integer>> graph = new HashMap<>();
        for (int[] f : flights) {
            if (!graph.containsKey(f[0])) 
            	graph.put(f[0], new HashMap<>());
            graph.get(f[0]).put(f[1], f[2]);
        }
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int o1[], int o2[]) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
        
        pq.offer(new int[] {src, 0, K+1});
        
        
        while(!pq.isEmpty()) {
        	int[] temp = pq.poll();
        	int price = temp[1];
        	int city = temp[0];
        	int stops = temp[2];
        	if(city == dst)
        		return price;
        	if(stops > 0) {
        		Map<Integer, Integer> neighbours = graph.getOrDefault(city, new HashMap<>());
        		for(int nbr : neighbours.keySet()) {
            		pq.add(new int[]{nbr, price + neighbours.get(nbr), stops - 1});
            	}
            }
        		
        }
        
        return -1;
    }

}
