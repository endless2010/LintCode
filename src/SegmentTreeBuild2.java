import org.junit.Test;
/*
 *                  [0,  3] (max = 4)
                  /            \
        [0,  1] (max = 3)     [2, 3]  (max = 4)
        /        \               /             \
[0, 0](max = 3)  [1, 1](max = 2)[2, 2](max = 1) [3, 3] (max = 4)
 */
public class SegmentTreeBuild2 {

	public SegmentTreeNode build(int[] A,int start,int end) {
		if(start>end)
			return null;
		if (start == end)
			return new SegmentTreeNode(start, end,A[start]);
		int mid = (start + end) / 2;
		SegmentTreeNode root = new SegmentTreeNode(start, end,0);
		root.left = build(A,start, mid);
		root.right = build(A,mid + 1, end);
		root.max=root.left.max>root.right.max?root.left.max:root.right.max;
		return root;
	}
	public SegmentTreeNode build(int[] A) {
		return build(A,0,A.length-1);
	}

	@Test
	public void test() {
		SegmentTreeNode root = build(new int[]{3,2,1,4});
		System.out.println(root);
	}
}