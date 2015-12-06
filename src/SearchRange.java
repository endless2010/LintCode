import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/*
 * 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。
 * 找到树中所有值在 k1 到 k2 范围内的节点。即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值。
 * 如果有 k1 = 10 和 k2 = 22, 你的程序应该返回 [12, 20, 22].
    20
   /  \
  8   22
 / \
4   12
 */
public class SearchRange {

    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	if(root==null)
    		return list;
    	searchRange(list,root,k1,k2);
    	return list;
    }
    public void searchRange(ArrayList<Integer> list,TreeNode root, int k1, int k2) {
    	if(root.val>k1 && root.left!=null)
    		searchRange(list,root.left,k1,k2);  	
    	if(root.val>=k1 && root.val<=k2)
    		list.add(root.val);	
    	if(root.val<k2 && root.right!=null)
    		searchRange(list,root.right,k1,k2);
    }
    
    @Test
    public void test(){
    	TreeNode root=TreeNode.createTree(20,8,22,4,12);
    	ArrayList<Integer> list=searchRange(root,10,22);
    	Assert.assertEquals(12,list.get(0).intValue());
    	Assert.assertEquals(20,list.get(1).intValue());
    	Assert.assertEquals(22,list.get(2).intValue());
    }
    
}
