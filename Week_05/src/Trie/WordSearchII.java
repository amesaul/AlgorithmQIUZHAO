package Trie;

import java.util.*;

public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		if (board == null) return Collections.emptyList();
		Trie trie = new Trie();
		int m = board.length;
		int n = board[0].length;
		Set<String> result = new HashSet<>();
		for (String s : words) {
			trie.insert(s);
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				dfs(i, j, "", board, result, trie, new HashSet<String>());
			}
		}
		return new ArrayList<>(result);
	}

	private void dfs(int i, int j, String s, char[][] board, Set<String> result, Trie trie, Set<String> visited) {
		String t = s + board[i][j];
		if (!trie.prefix(t))
			return;
		if (trie.search(t)){
			result.add(t);
		}
		visited.add(i + "," + j);
		if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j))
			dfs(i - 1, j, t, board, result, trie, new HashSet<>(visited));
		if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1)))
			dfs(i, j - 1, t, board, result, trie, new HashSet<>(visited));
		if ((i + 1 < board.length && !visited.contains((i + 1) + "," + j)))
			dfs(i + 1, j, t, board, result, trie, new HashSet<>(visited));
		if (j + 1 < board[0].length && !visited.contains(i + "," + (j + 1)))
			dfs(i , j+1, t, board, result, trie, visited);
	}

	//	implements a Trie
	class Trie {
		private boolean isEnd;
		private Trie[] next;
		private static final int NUM = 26;

		public Trie() {
			this.isEnd = false;
			this.next = new Trie[NUM];
		}

		public void insert(String word) {
			if (word.length() == 0 || word == null) return;
			Trie curr = this;
			char[] words = word.toCharArray();
			for (char c : words) {
				int n = c - 'a';
				if (curr.next[n] == null) curr.next[n] = new Trie();
				curr = curr.next[n];
			}
			curr.isEnd = true;
		}

		public boolean search(String word) {
			Trie node = searchPrefix(word);
			return node != null && node.isEnd == true;
		}

		public boolean prefix(String prefix) {
			Trie node = searchPrefix(prefix);
			return node != null;
		}

		private Trie searchPrefix(String word) {
			Trie node = this;
			char[] words = word.toCharArray();
			for (char c : words) {
				node = node.next[c - 'a'];
				if (node == null) return null;
			}
			return node;
		}
	}
}
