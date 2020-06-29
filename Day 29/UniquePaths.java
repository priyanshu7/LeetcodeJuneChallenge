package june2020;

public class UniquePaths {
	
	public static int uniquePaths(int m, int n) {
        int[][] paths = new int[n][m];
        for(int i = 0; i < m ; i++)
            paths[0][i] = 1;
        
        for(int i = 0; i < n ; i++)
            paths[i][0] = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        
        return paths[n-1][m-1];
        
    }
	
	public static void main(String[] args) {
		int a = uniquePaths(5,100);
		System.out.println(a);
	}

}
