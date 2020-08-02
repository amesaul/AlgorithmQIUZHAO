package HomeWork;

import java.util.*;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		char[][] chess = new char[n][n];
		fillchess(chess);
		dfs(0,n,new ArrayList<String>(),result,new HashSet<String>(),chess);
		return result;
	}

	private void dfs(int i, int n, ArrayList<String> list, List<List<String>> result,HashSet<String> visited,char[][] chess) {
		if (list.size()==n) {
			result.add(list);
			return;
		}
		Set<Integer> illegal = new HashSet<>();
		addillegalPosition(i,illegal,visited);
		for (int j= 0 ; j < n;j++) {
			if (!illegal.contains(j)) {
				visited.add(i+","+j);
				chess[i][j]='Q';
				list.add(new String(chess[i]));
				dfs(i+1,n,new ArrayList<>(list),result,new HashSet<>(visited),chess);
				list.remove(list.size()-1);
				chess[i][j]='.';
				visited.remove((i+","+j));
			}
		}
	}

	private void addillegalPosition(int i, Set<Integer> illegal, HashSet<String> visited) {
		for (String s : visited) {
			int row = s.charAt(0)-'0';
			int col = s.charAt(2)-'0';
			illegal.add(col);
			illegal.add(col+i-row);
			illegal.add(col-i+row);
		}
	}

	private void fillchess(char[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				chess[i][j]='.';
			}
		}
	}
}
