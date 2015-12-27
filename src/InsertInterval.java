import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/*
 * 插入区间[2, 5] 到 [[1,2], [5,9]]，我们得到 [[1,9]]。
 * 插入区间[3, 4] 到 [[1,2], [5,9]]，我们得到 [[1,2], [3,4], [5,9]]。
 */
public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); ++i) {
			if (hasIntersect(intervals.get(i), newInterval)) {
				newInterval = merge(intervals.get(i), newInterval);
			} else
				result.add(intervals.get(i));
		}
		result.add(newInterval);
		Collections.sort(result, new Comparator<Interval>() {
			@Override
			public int compare(Interval interval1, Interval interval2) {
				return interval1.start - interval2.start;
			}
		});
		return result;
	}

	private boolean hasIntersect(Interval interval1, Interval interval2) {
		return (interval2.start>=interval1.start &&interval2.start<=interval1.end) ||
			   (interval1.start>=interval2.start &&interval1.start<=interval2.end);
	}

	private Interval merge(Interval interval1, Interval interval2) {
		int start = interval1.start > interval2.start ? interval2.start: interval1.start;
		int end = interval1.end > interval2.end ? interval1.end : interval2.end;
		return new Interval(start, end);
	}

	@Test
	public void test() {
		 ArrayList<Interval> list=new ArrayList<Interval>();
		 list.add(new Interval(1,2));list.add(new Interval(5,9));
		 ArrayList<Interval> merged=insert(list,new Interval(2,5));
		 Assert.assertEquals(1,merged.size());
		 Assert.assertEquals(true,merged.contains(new Interval(1,9)));

		ArrayList<Interval> list2 = new ArrayList<Interval>();
		list2.add(new Interval(1, 2));
		list2.add(new Interval(5, 9));
		ArrayList<Interval> merged2 = insert(list2, new Interval(3, 4));
		Assert.assertEquals(3, merged2.size());
		Assert.assertEquals(true, merged2.contains(new Interval(1, 2)));
		Assert.assertEquals(true, merged2.contains(new Interval(3, 4)));
		Assert.assertEquals(true, merged2.contains(new Interval(5, 9)));
	}
}