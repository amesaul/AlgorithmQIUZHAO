package HomeWork;

public class NumberOfIsland {
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(i, j, grid);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(int i, int j, char[][] grid) {
		grid[i][j] = '0';
		if (i + 1 != grid.length && grid[i + 1][j] == '1')
			dfs(i + 1, j, grid);
		if ((i - 1) != -1 && grid[i - 1][j] == '1')
			dfs(i - 1, j, grid);
		if (j + 1 != grid[i].length && grid[i][j + 1] == '1')
			dfs(i, j + 1, grid);
		if ((j - 1) != -1 && grid[i][j - 1] == '1')
			dfs(i, j - 1, grid);
	}
}
