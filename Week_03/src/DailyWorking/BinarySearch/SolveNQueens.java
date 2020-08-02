package DailyWorking.BinarySearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveNQueens {
	public List<List<String>> solveNQueens(int n) {
		char[][] result = new char[n][n];
		List<List<String>> lists = new ArrayList<>();
		fillChar(result);
		solveNQ(0, n, result, lists);
		return lists;
	}

	private void solveNQ(int i,
						 int n,
						 char[][] result,
						 List<List<String>> lists) {
		if (i == n) {
			lists.add(toList(result));
			return;
		}
		Set<Integer> include = new HashSet<>();
		setInclude(i, n, result, include);
		for (int s = 0; s < n; ++s) {
			if (!include.contains(s)) {
				result[i][s] = 'Q';
				solveNQ(i + 1, n, result, lists);
				result[i][s] = '.';
			}
		}
	}

	private void setInclude(int i, int n, char[][] result, Set<Integer> include) {
		for (int p = 0; p < i; ++p) {
			for (int q = 0; q < n; ++q) {
				if (result[p][q] == 'Q') {
					include.add(q);
					include.add(i - p + q);
					include.add(q-i+p);
				}
			}
		}


	}

	private List<String> toList(char[][] result) {

		List<String> res = new ArrayList<>(result.length);
		for (int i = 0; i < result.length; i++) {
			StringBuilder elements = new StringBuilder(result.length);
			for (int j = 0; j < result.length; j++) {
				elements.append(result[i][j]);
			}
			res.add(elements.toString());
		}
		return res;
	}

	private void fillChar(char[][] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = '.';
			}
		}
	}

	public static void main(String[] args) {
		SolveNQueens so = new SolveNQueens();
		so.solveNQueens(4);
	}
}
