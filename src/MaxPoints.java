import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class MaxPoints {
	/*
	 * http://blog.csdn.net/ljiabin/article/details/38904757
	 */
	public int maxPoints(Point[] points) {
		if(points==null)
			return 0;
		if (points.length < 3)
			return points.length;

		int max = 0;
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		for (int i = 0; i < points.length; i++) {
			map.clear();
			int duplicates = 1;
			for (int j = 0; j < points.length; j++) {
				if (i == j) continue;
				double slope = 0.0;
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					duplicates++;
					continue;
				} else if (points[i].x == points[j].x) {
					slope = Integer.MAX_VALUE;
				} else {
					slope = 1.0 * (points[i].y - points[j].y)/ (points[i].x - points[j].x);
				}
				map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
			}
			if (map.size() == 0) {
				max = duplicates > max ? duplicates : max;
			} else {
				for (double key : map.keySet()) {
					max = Math.max((duplicates + map.get(key)), max);
				}
			}
		}
		return max;
	}

	@Test
	public void test() {
		Assert.assertEquals(3, maxPoints(new Point[] { new Point(0, 0),
				new Point(1, 2), new Point(3, 6), new Point(4, 4) }));
		Assert.assertEquals(2, maxPoints(new Point[] { new Point(0, 0),
				new Point(1, 2) }));
		Assert.assertEquals(1, maxPoints(new Point[] { new Point(0, 0) }));
		Assert.assertEquals(0, maxPoints(new Point[] {}));
		Assert.assertEquals(3, maxPoints(new Point[] { new Point(0, 0),
				new Point(1, 1), new Point(0, 0) }));
		Assert.assertEquals(2, maxPoints(new Point[] { new Point(1, 1),
				new Point(1, 1) }));
	}
}
