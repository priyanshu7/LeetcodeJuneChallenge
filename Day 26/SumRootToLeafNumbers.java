package june2020;

public class SumRootToLeafNumbers {
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private int sum;

	private void total(TreeNode node, int val) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			sum += val + node.val;
			return;
		}
		total(node.left, (val + node.val) * 10);
		total(node.right, (val + node.val) * 10);
	}

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		sum = 0;
		total(root, 0);
		return sum;
	}

}
