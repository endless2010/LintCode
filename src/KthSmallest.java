import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/*
 * Find the kth smallest number in at row and column sorted matrix.
 * Given k = 4 and a matrix:
 * [
 * [1 ,5 ,7],
 * [3 ,7 ,8],
 * [4 ,8 ,9],
 * ]
 * return 5
 */
public class KthSmallest{
	class Point  implements Comparable<Point>{
		int x, y, value;

		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
		
		@Override
		public int compareTo(Point other) {
			if (this.value < other.value)
				return -1;
			if (this.value > other.value)
				return 1;
			
			if(this.x<other.x)
				return -1;
			else if(this.x>other.x)
				return 1;
			else
				return this.y-other.y;
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Point))
				return false;
			Point other = (Point) o;
			return this.x == other.x && this.y == other.y && this.value == other.value;
		}

		@Override
		public int hashCode() {
			return value;
		}
		@Override
		public String toString(){
			return "["+x+","+y+"]="+value;
		}
	}

	public int kthSmallest(int[][] matrix, int k) {
		if (matrix == null || k < 0 || k > matrix.length*matrix[0].length)
			throw new RuntimeException("invalid parameter");
		PriorityQueue<Point> queue=new PriorityQueue<Point>();
		queue.add(new Point(0,0,matrix[0][0]));
		int count=0;
		while(!queue.isEmpty()){
			Point point=queue.poll();

			count++;
			if(count==k)
				return point.value;
			if(point.x<matrix.length-1){
				Point down=new Point(point.x+1,point.y,matrix[point.x+1][point.y]);
				if(!queue.contains(down))
					queue.add(down);
			}
			if(point.y<matrix[0].length-1){
				Point right=new Point(point.x,point.y+1,matrix[point.x][point.y+1]);
				if(!queue.contains(right))
				queue.add(right);
			}
		}
		return 0;
	}

	@Test
	public void test() {
		int[][] matrix1 = { { 1, 5, 7 }, { 3, 7, 8 }, { 4, 8, 9 }, };
		Assert.assertEquals(1, kthSmallest(matrix1, 1));
		Assert.assertEquals(3, kthSmallest(matrix1, 2));
		Assert.assertEquals(4, kthSmallest(matrix1, 3));
		Assert.assertEquals(5, kthSmallest(matrix1, 4));
		Assert.assertEquals(7, kthSmallest(matrix1, 5));
		Assert.assertEquals(7, kthSmallest(matrix1, 6));
		Assert.assertEquals(8, kthSmallest(matrix1, 7));
		Assert.assertEquals(8, kthSmallest(matrix1, 8));
		Assert.assertEquals(9, kthSmallest(matrix1, 9));
		
		int[][] matrix2 = { { 1, 2,3 }, {  1, 2,3 }, {  1, 2,3}, };
		
		Assert.assertEquals(1, kthSmallest(matrix2, 1));
		Assert.assertEquals(1, kthSmallest(matrix2, 2));
		Assert.assertEquals(1, kthSmallest(matrix2, 3));
		Assert.assertEquals(2, kthSmallest(matrix2, 4));
		Assert.assertEquals(2, kthSmallest(matrix2, 5));
		Assert.assertEquals(2, kthSmallest(matrix2, 6));
		Assert.assertEquals(3, kthSmallest(matrix2, 7));
		Assert.assertEquals(3, kthSmallest(matrix2, 8));
		Assert.assertEquals(3, kthSmallest(matrix2, 9));
		
	}
}
