package june2020;

public class SearchInBST {
	public class TreeNode {
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
	
	public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) 
            return root;
        if(root.val == val){
            return root;
        }
        else{
            return (val < root.val) ? searchBST(root.left,val) : searchBST(root.right,val);
        }
    }
	
	public TreeNode searchBSTIter(TreeNode root, int val) {
	    TreeNode temp = root;
	    while(temp != null){
	        if(temp.val == val)
	            return temp;
	        else if(temp.val < val)
	            temp = temp.right;
	        else
	            temp = temp.left;
	    }
	    return null;
	}

}
