import org.junit.Assert;
import org.junit.Test;

/*
����һ��������,ȷ�����Ǹ߶�ƽ��ġ�
�����������,һ�ø߶�ƽ��Ķ������Ķ����ǣ�һ�ö�������ÿ���ڵ������������������ᳬ��1�� 
���������� A={3,9,20,#,#,15,7}, B={3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
������A�Ǹ߶�ƽ��Ķ�����������B����
 */
public class IsBalancedBTree {
    public boolean isBalanced(TreeNode root) {
         if(root==null)
        	 return true;
         boolean result= Math.abs(length(root.left)-length(root.right))<=1;
         return result&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int length(TreeNode root){
    	if(root==null)
    		return 0;
    	int leftLength=length(root.left);
    	int rightLength=length(root.right);
    	return leftLength>rightLength?leftLength+1:rightLength+1;
    }
    @Test
    public void test(){
    	TreeNode root1=TreeNode.createTree(3,9,20,null,null,15,7); 
    	Assert.assertEquals(true,isBalanced(root1));
    	
    	TreeNode root2=TreeNode.createTree(3,20,null,14); 
    	Assert.assertEquals(false,isBalanced(root2));
    }
}
