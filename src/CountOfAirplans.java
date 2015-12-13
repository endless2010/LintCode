import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given an interval list which are flying and landing time of the flight.
 * How many airplanes are on the sky at most?
 * Example For interval list [[1,10],[2,3],[5,8],[4,7]], return 3
 * https://codesolutiony.wordpress.com/2015/05/12/lintcode-number-of-airplanes-in-the-sky/
 */
public class CountOfAirplans {
	  public int countOfAirplanes(List<Interval> airplanes) { 
	        if (airplanes == null || airplanes.size() == 0) {
	            return 0;
	        }

	        Collections.sort(airplanes, new Comparator<Interval>() {
	            public int compare(Interval i1, Interval i2) {
	                return Integer.compare(i1.start, i2.start);
	            }
	        });
	        Point[] points = new Point[airplanes.size()*2];
	        for (int i = 0; i < airplanes.size(); i++) {
	            points[i*2] = new Point(airplanes.get(i).start, true);
	            points[i*2 + 1] = new Point(airplanes.get(i).end, false);
	        }
	        Arrays.sort(points, new Comparator<Point>(){
	            public int compare(Point i1, Point i2) {
	                return Integer.compare(i1.time, i2.time);
	            }
	        });
	        int res = 0;
	        int cur = 0;
	        for (Point p : points) {
	            if (!p.isStart) {
	                cur--;
	            } else {
	                cur++;
	                res = Math.max(res, cur);
	            }
	        }
	        return res;
	    }
	     
	    class Point {
	        int time;
	        boolean isStart;
	        public Point(int time, boolean isStart) {
	            this.time = time;
	            this.isStart = isStart;
	        }
	    }
	
	@Test
	public void test(){
		List<Interval> intervals1=new ArrayList<Interval>();
		intervals1.add(new Interval(1,10));
		intervals1.add(new Interval(2,3));
		intervals1.add(new Interval(5,8));
		intervals1.add(new Interval(4,7));
		Assert.assertEquals(3,countOfAirplanes(intervals1));
		
		List<Interval> intervals2=new ArrayList<Interval>();
		intervals2.add(new Interval(1,10));
		Assert.assertEquals(1,countOfAirplanes(intervals2));
		
		List<Interval> intervals3=new ArrayList<Interval>();
		intervals3.add(new Interval(1,10));
		intervals3.add(new Interval(2,3));
		Assert.assertEquals(2,countOfAirplanes(intervals3));
		
		List<Interval> intervals4=new ArrayList<Interval>();
		intervals4.add(new Interval(1,2));
		intervals4.add(new Interval(2,3));
		Assert.assertEquals(1,countOfAirplanes(intervals4));
	}
    
}
