import org.junit.Test;

/*
 * ����һ�ö����������һ���µ����ڵ㣬���ڵ���뵽���С�
 * ����Ҫ��֤������Ȼ��һ�ö����������
 * ��������һ�ö�����������ڲ���ڵ�6֮����ö�������������������ģ�

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
