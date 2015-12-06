import org.junit.Test;

public class SegmentTreeBuild {

	public SegmentTreeNode build(int start, int end) {
		if(start>end)
			return null;
		if (start == end)
			return new SegmentTreeNode(start, end);
		int mid = (start + end) / 2;
		SegmentTreeNode root = new SegmentTreeNode(start, end);
		root.left = build(start, mid);
		root.right = build(mid + 1, end);
		return root;
	}

	@Test
	public void test() {
		SegmentTreeNode root = build(1, 6);
		System.out.println(root);
	}
}