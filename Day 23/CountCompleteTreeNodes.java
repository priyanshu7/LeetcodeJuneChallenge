package june2020;

public class CountCompleteTreeNodes {
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	     }
	 }
	// O(N) Approach
	public int countNodesON(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);        
    }
	 
	// O(log N * log N)
	static int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public static int countNodes(TreeNode root) {
        int h = height(root);
        if(h < 0)
        	return 0;
        else
        	return (height(root.right) == h-1) ? (1 << h) + countNodes(root.right)
                                         : (1 << h-1) + countNodes(root.left);
    }
    

}
