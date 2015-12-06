import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * ����һ�����������ҳ�����·���и��ڵ�����ܺ͵��ڸ��� Ŀ��ֵ ��·����
 * һ����Ч��·����ָ���ǴӸ��ڵ㵽Ҷ�ڵ��·����
 * ����һ������������ Ŀ��ֵ = 5:
     1
    / \
   2   4
  / \
 2   3
���أ�

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
