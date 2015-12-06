import org.junit.Test;

/*
 * 给一个排序数组（从小到大），将其转换为一棵高度最小的排序二叉树。
 * 给出数组 [1,2,3,4,5,6,7], 返回
     4
   /   \
  2     6
 / \    / \
1   3  5   7
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] A) { 
    	return sortedArrayToBST(A,0,A.length-1);
    } 
    public TreeNode sortedArrayToBST(int[] A,int from,int to) {  
    	if(A==null || A.length==0 || from<0 || from>to)
    		return null;
    	if(from==to)
    		return new TreeNode(A[from]);
    	int mid=(from+to)/2;
    	TreeNode root=new TreeNode(A[mid]);
    	root.left=sortedArrayToBST(A,from,mid-1);
    	root.right=sortedArrayToBST(A,mid+1,to);
    	return root;
    } 
    @Test
    public void test(){
    	System.out.println(sortedArrayToBST(new int[]{1,2,3,4,5,6,7}));
    	System.out.println(sortedArrayToBST(new int[]{1}));
    	System.out.println(sortedArrayToBST(new int[]{1,2}));
    	System.out.println(sortedArrayToBST(new int[]{1,2,3}));
    }
}
