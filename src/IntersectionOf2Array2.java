import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * 返回两个数组的交 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2,2].
 */
public class IntersectionOf2Array2 {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null
				|| nums2.length == 0)
			return new int[] {};
		Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
		List<Integer> joinList = new ArrayList<Integer>();
		for (int i : nums1){
			if(!map1.containsKey(i))
				map1.put(i, 1);
			else
				map1.put(i, map1.get(i)+1);
		}
		for (int i : nums2){
			if(!map2.containsKey(i))
				map2.put(i, 1);
			else
				map2.put(i, map2.get(i)+1);
		}
		for (int i : map1.keySet())
			if (map2.containsKey(i)) {
				int times=map1.get(i)>map2.get(i)?map2.get(i):map1.get(i);
				for(int v=0;v<times;++v)
					joinList.add(i);
			}
		int[] result = new int[joinList.size()];
		int index = 0;
		for (int i : joinList)
			result[index++] = i;
		return result;
	}

	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] { 2, 2 },
				intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }));

		Assert.assertArrayEquals(new int[] { 2 },
				intersection(new int[] { 1, 2, 2, 1 }, new int[] { 3, 2 }));

		Assert.assertArrayEquals(new int[] {},
				intersection(new int[] { 1, 2, 2, 1 }, new int[] { 3, 4 }));
	}
}
