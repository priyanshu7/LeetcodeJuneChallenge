package june2020;

public class IsSubsequence {
	
	 public boolean isSubsequence(String s, String t) {
	        int m = s.length();
	        int n = t.length();
	        if(m == 0)
	            return true;
	        int idxT = 0, idxS = 0;
	        while(idxT < n){
	            if(s.charAt(idxS) == t.charAt(idxT)){
	                idxS++;
	                if(idxS == m)
	                    return true;
	            }
	            idxT++;
	        }
	        return false;
	    }

}
