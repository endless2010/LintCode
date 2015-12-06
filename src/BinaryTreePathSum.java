import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
 * 一个有效的路径，指的是从根节点到叶节点的路径。
 * 给定一个二叉树，和 目标值 = 5:
     1
    / \
   2   4
  / \
 2   3
返回：

[
  [1, 2, 2],
  [1, 4]
]
 */
public class BinaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null)
        	return result;
        
        helper(result,new ArrayList<Integer>(),root,target);
        return result;
    }
    private void helper(List<List<Integer>> result,List<Integer> tmp,
			TreeNode root, int target) {
    	tmp.add(root.val);
    	if(root.left==null && root.right==null){		
    		if(root.val==target)
    			result.add(tmp);
    	}
    	List<Integer> clone=new ArrayList<Integer>(tmp);
    	if(root.left!=null)
    		helper(result,tmp,root.left,target-root.val);
    	if(root.right!=null)
    		helper(result,clone,root.right,target-root.val);
	}
	@Test
    public void test(){
    	TreeNode root=TreeNode.createTree(1,2,4,2,3);
    	List<List<Integer>> list=binaryTreePathSum(root,5);
    	System.out.println(list);
    }
}
