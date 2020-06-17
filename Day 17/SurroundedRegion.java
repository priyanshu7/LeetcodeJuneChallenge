package june2020;

public class SurroundedRegion {
	
	public boolean isSafe(char[][] board, int row, int col) {
		return (row>=0 && row < board.length) && (col >= 0 && col < board[0].length) && (board[row][col] == 'O');
	}
	
	public void dfs(char[][] board, int i, int j) {
		int[] rowNbr = new int[] {-1,0,1,0};
		int[] colNbr = new int[] {0,-1,0,1}; 
		
		board[i][j] = '1';
		
		for(int k = 0; k < 4; k++) {
			if(isSafe(board, i + rowNbr[k], j + colNbr[k])) {
				dfs(board, i + rowNbr[k], j + colNbr[k]);
			}
		}
		
	}
    
    
    public void solve(char[][] board) {
    	int n = board.length;
    	if(n == 0)
    		return;
    	int m = board[0].length;
    	for(int i = 0; i < n; i++) {
    		if(board[i][0] == 'O') {
    			dfs(board,i,0);
    		}
    		if(board[i][m-1] == 'O') {
    			dfs(board,i,m-1);
    		}
    	}
    	
    	for(int i = 0; i < m; i++) {
    		if(board[0][i] == 'O') {
    			dfs(board,0,i);
    		}
    		if(board[n-1][i] == 'O') {
    			dfs(board,n-1,i);
    		}
    	}
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(board[i][j] == '1')
    				board[i][j] = 'O';
    			else if(board[i][j] == 'O')
    				board[i][j] = 'X';
    		}
    	}
        
    }

}
