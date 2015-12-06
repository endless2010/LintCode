import org.junit.Test;

/*
 * 给定一棵二叉查找树和一个新的树节点，将节点插入到树中。
 * 你需要保证该树仍然是一棵二叉查找树。
 * 给出如下一棵二叉查找树，在插入节点6之后这棵二叉查找树可以是这样的：

  2             2
 / \           / \
1   4   -->   1   4
   /             / \ 
  3             3   6
 */
public class InsertNodeToBST {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
    	if(root==null)
    		return node;
    	if(node==null)
    		return root;
    	TreeNode temp=root;
    	TreeNode parent=root;
    	while(temp!=null){
    		if(temp.val==node.val)
    			return root;
    		parent=temp;
    		if(temp.val<node.val)
    			temp=temp.right;
    		else
    			temp=temp.left;
    	}
    	if(parent.val>node.val)
    		parent.left=node;
    	else
    		parent.right=node;
    	return root;
    }
    @Test
    public void test(){
    	TreeNode root=TreeNode.createTree(2,1,4,null,null,3,null);
    	TreeNode newRoot=insertNode(root,new TreeNode(6));
    	System.out.println(newRoot);
    }
}
