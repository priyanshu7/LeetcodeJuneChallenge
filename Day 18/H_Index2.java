package june2020;

public class H_Index2 {
	
	public int hIndexOn(int[] citations) {
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            if (n - i <= citations[i]) {
                return n - i;
            }
        }
        return 0;   
    }
	
	public int hIndex(int[] citations) {
        int len = citations.length;
	    int lo = 0, hi = len - 1;
	    while (lo <= hi) {
		    int mid = lo + (hi - lo) / 2;
		    if (citations[mid] == len - mid) {
			    return len - mid;
		    } else if (citations[mid] < len - mid) {
			    lo = mid + 1;
		    } else {
			    hi = mid - 1;
		    }
	    }
	    return len - lo;
        
    }

}
