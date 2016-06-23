import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Given n items with size Ai, an integer m denotes the size of a backpack. How
 * full you can fill this backpack?
 * 
 * You can not divide any item into small pieces.
 * 
 * If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can
 * select [2, 3, 5], so that the max size we can fill this backpack is 10. If
 * the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the
 * backpack.
 * 
 * You function should return the max size we can fill in the given backpack.
 * 
 * Challenge O(n x m) time and O(m) memory. O(n x m) memory is also acceptable
 * if you do not know how to optimize memory.
 * 
 * 将前i件物品放到容量为v的背包中，若我们只考虑第i件物品时，它有两种选择，放或者不放。 1) 如果第i件物品不放入背包中，那么问题就转换为：将前i -
 * 1件物品放到容量为v的背包中，带来的收益f[i - 1][v] 2) 如果第i件物品能放入背包中，那么问题就转换为：将前i - 1件物品放到容量为v -
 * weight[i]的背包中， 带来的收益f[i - 1][v - weight[i]] + cost[i]
 */
public class BackPack {
  
	public int backPack(int m, int[] A) {
		if (A.length == 0)
			return 0;

		int len = A.length;
		boolean[] size = new boolean[m + 1];
		Arrays.fill(size, false);
		size[0] = true;
		for (int i = 0; i < len; i++){
			for (int j = m; j >= 0; j--) {
				if (j - A[i] >= 0 && size[j - A[i]])
					size[j] = size[j - A[i]];
			}
		}
		for (int i = m; i >= 0; i--)
			if (size[i])
				return i;

		return 0;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(12, backPack(12, new int[] { 2, 3, 7 }));
		Assert.assertEquals(10, backPack(11, new int[] { 2, 3, 7 }));
		Assert.assertEquals(10, backPack(10, new int[] { 2, 3, 7 }));
		Assert.assertEquals(10, backPack(11, new int[] { 2, 3, 5, 7 }));
	}

}
