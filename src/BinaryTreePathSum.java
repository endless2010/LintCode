import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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
    	pathsum(root,target,result);
    	return null;
    }

	private void pathsum(TreeNode root, int target, List<List<Integer>> result) {
		if(root.left==null && root.right==null)
			return;
		
	}
	@Test
	public void test(){
		TreeNode root=TreeNode.createTree(1,2,4,2,3);
		List<List<Integer>> list=binaryTreePathSum(root,5);
		Assert.assertEquals(2,list.size());
		Assert.assertEquals(list.get(0),Arrays.asList(1,2,2));
		Assert.assertEquals(list.get(1),Arrays.asList(1,4));
	}
}
