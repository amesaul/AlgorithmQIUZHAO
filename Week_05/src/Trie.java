class Trie {
	private boolean isEnd;
	private static final int CHARNUMS = 26;
	private Trie next[];

	/**
	 * Initialize your data structure here.
	 */
	public Trie() {
		isEnd = false;
		next = new Trie[CHARNUMS];
	}

	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word) {
		if (word.length() == 0 || word == null) return;
		Trie curr = this;
		char[] words = word.toCharArray();
		for (char w : words) {
			int n = w - 'a';
			if (curr.next[n] == null)
				curr.next[n] = new Trie();
			curr = curr.next[n];
		}
		curr.isEnd = true;
	}

	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {
		Trie node = searchPrefix(word);
		return node != null && node.isEnd == true;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Trie node = searchPrefix(prefix);
		return node!=null;
	}

	private Trie searchPrefix(String word) {
		Trie node = this;
		char[] words = word.toCharArray();
		for (char c : words){
			int n = c-'a';
			node = node.next[n];
			if (node==null) return null;
		}
		return node;
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */