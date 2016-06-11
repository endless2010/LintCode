import org.junit.Assert;
import org.junit.Test;

public class NumOfIslands {

	public int numIslands(boolean[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int ans = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != true)
					continue;

				ans++;
				dfs(grid, i, j);
			}
		}
		return ans;
	}

	public void dfs(boolean[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			return;

		if (grid[i][j] == true) {
			grid[i][j] = false;
			dfs(grid, i - 1, j);
			dfs(grid, i + 1, j);
			dfs(grid, i, j - 1);
			dfs(grid, i, j + 1);
		}
	}

	@Test
	public void test() {
		boolean[][] grid = new boolean[][] {
				{ true, true, false, false, false },
				{ false, true, false, false, true },
				{ false, false, false, true, true },
				{ false, false, false, false, false },
				{ false, false, false, false, true }, };
			Assert.assertEquals(3,numIslands(grid));
	}
	
}
