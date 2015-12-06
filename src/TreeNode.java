public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public static TreeNode createTree(Integer... vals) {
		if (vals == null || vals.length == 0)
			return null;
		return createTreeNode(0, vals);
	}

	private static TreeNode createTreeNode(int index, Integer... vals) {
		TreeNode node = null;
		if (vals[index] != null) {
			node = new TreeNode(vals[index]);
			if (2 * index + 1 < vals.length)
				node.left = createTreeNode(2 * index + 1, vals);
			if (2 * index + 2 < vals.length)
				node.right = createTreeNode(2 * index + 2, vals);
		}
		return node;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(val + " ");
		if (left != null)
			sb.append(left);
		else
			sb.append("# ");
		if (right != null)
			sb.append(right);
		else
			sb.append("# ");
		return sb.toString();
	}

	private boolean equals(TreeNode node1,TreeNode node2){
		if(node1==null && node2==null)
			return true;
		if(node1.val!=node2.val)
			return false;
		return equals(node1.left,node2.left)&&
			   equals(node1.right,node2.right);
	}
	@Override
	public boolean equals(Object o){
		if(!(o instanceof TreeNode))
			return false;
		return equals(this,(TreeNode)o);
	}
	public static void main(String[] args) {
		TreeNode node = createTree(1, 2, 3, 5, 7, null, 9);
		System.out.println(node);
		System.out.println(node.equals(createTree(1, 2, 3, 5, 7, null, 9)));
		System.out.println(node.equals(createTree(1, 3, 3, 5, 7, null, 9)));
	}

}