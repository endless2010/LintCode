import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/*
 * ��������ֵ k1 �� k2��k1 < k2����һ������������ĸ��ڵ㡣
 * �ҵ���������ֵ�� k1 �� k2 ��Χ�ڵĽڵ㡣����ӡ����x (k1 <= x <= k2) ���� x �Ƕ�����������еĽڵ�ֵ��������������Ľڵ�ֵ��
 * ����� k1 = 10 �� k2 = 22, ��ĳ���Ӧ�÷��� [12, 20, 22].
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
