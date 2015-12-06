public class MaxPerLine {

	public int getMax(Point[] points) {

		Map<Double, Integer> slopes = new HashMap<Double, Integer>();

		for (int i = 0; i < points.length; ++i) {

			for (int j = i + 1; j < points.length; ++j) {

				double slope = Double.NaN;

				if (points[j].x != points[i].x)

					slope = (points[j].y - points[i].y)
							/ (points[j].x - points[i].x);

				if (slopes.get(slope) == null)

					slopes.put(slope, 1);

				else

					slopes.put(slope, slopes.get(slope) + 1);

			}

		}

		int max = 2;

		for (Integer value : slopes.values())

			if (value > max)

				max = value;

		return max;

	}

	@Test
	public void test() {

		Assert.assertEquals(3, getMax(new Point[] { new Point(0, 0),
				new Point(1, 2), new Point(3, 6), new Point(4, 4) }));

		Assert.assertEquals(2, getMax(new Point[] { new Point(0, 0),
				new Point(1, 2) }));

	}

}