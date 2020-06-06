package june2020;

import java.util.*;

public class QueueReconstructionByHeight {
	
	public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0)
            return new int[0][0];
        Arrays.sort(people, (a,b) -> (b[0] == a[0])? a[1] - b[1] : b[0] - a[0]);
        List<int[]>  result =  new ArrayList<>();
        for(int[] x : people){
            result.add(x[1] , x);
        }
        return result.toArray(new int[people.length][2]);
    }

}
