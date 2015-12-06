import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MergeInteval {
	
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval interval1, Interval interval2) {
				return interval1.start - interval2.start;
			}
		});

		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval interval = intervals.get(0);
		for (int i = 1; i < intervals.size(); ++i) {
			if (interval.end < intervals.get(i).start) {
				result.add(interval);
				interval = intervals.get(i);
			} else {
				interval.end = Math.max(interval.end, intervals.get(i).end);
			}
		}
		result.add(interval);
		return result;
	}

	@Test
	public void test(){
		ArrayList<Interval> list=new ArrayList<Interval>();
		list.add(new Interval(1,1));list.add(new Interval(2,4));
		list.add(new Interval(3,3));list.add(new Interval(3,7));
		list.add(new Interval(8,15));list.add(new Interval(9,10));
		list.add(new Interval(10,10));list.add(new Interval(12,18));
		List<Interval> merged=merge(list);
		Assert.assertEquals(3,merged.size());
		Assert.assertEquals(true,merged.contains(new Interval(1,1)));
		Assert.assertEquals(true,merged.contains(new Interval(2,7)));
		Assert.assertEquals(true,merged.contains(new Interval(8,18)));
	}
}