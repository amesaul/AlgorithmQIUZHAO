package DailyWorking.BinarySearch.DFSandBFS;

import java.util.*;

public class WordLadder2 {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		Set<String> list = new HashSet<>(wordList);
		if (!list.contains(endWord)) return Collections.emptyList();
		Queue<String> queue = new LinkedList<>();
		int count = Integer.MAX_VALUE;
		int level = 0;
		queue.add(beginWord);
		while (!queue.isEmpty()) {
			if (level > count) break;
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
//				先加入ArrayList中.
				if (result.size() == level)
					result.add(new ArrayList<>());
				String solve = queue.poll();
				if (solve.equals(endWord)) {
					count = level;
					result.set(level,new ArrayList<>(Arrays.asList(endWord)));
					break;
				}
				result.get(level).add(solve);
				for (int j = 0; j < endWord.length(); j++) {
					char[] chars = solve.toCharArray();
					char c = chars[j];
					for (char k = 'a'; k <= 'z'; k++) {
						chars[j] = k;
						String judge = new String(chars);
						if (list.contains(judge)) {
							list.remove(judge);
							queue.offer(judge);
						}
					}
					chars[j] = c;
				}
			}
			level++;
		}
		if (count==Integer.MAX_VALUE)
			return Collections.emptyList();
		Set<List<String>> ret = new HashSet<>();
		dfs(0,new ArrayList<String>(Arrays.asList(beginWord)),result,ret);
		return new ArrayList<>(ret);
	}

	private void dfs(int i, ArrayList<String> strings, List<List<String>> result, Set<List<String>> ret) {
		if (i==result.size()-1){
			ret.add(strings);
			return;
		}
		String judge = strings.get(i);
		char[] st =  judge.toCharArray();
		for (int j = 0; j < judge.length(); j++) {
			char c = st[j];
			for (char k = 'a'; k <= 'z'; k++) {
				st[j] = k;
				String combination = new String(st);
				if (result.get(i + 1).contains(combination)) {
					strings.add(combination);
					dfs(i + 1, new ArrayList<>(strings), result, ret);
					strings.remove(combination);
				}
			}
			st[j] = c;
		}
	}
	public static void main(String[] args) {
		String startW = "hit";
		String endW = "cog";
		List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		WordLadder2 wl = new WordLadder2();
		wl.findLadders(startW,endW,list);

	}
//		for (String s : result.get(i)){
//			char[] st =  s.toCharArray();
//			for (int j = 0; j<s.length();j++) {
//				 char c  = st[j];
//				 for (char k = 'a';k<='z';k++){
//				 	st[j] = k;
//				 	String combination = new String(st);
//				 	if (result.get(i+1).contains(combination)){
//				 		strings.add(combination);
//				 		dfs(i+1,new ArrayList<>(strings),result,ret);
//				 		strings.remove(combination);
//					}
//				 }
//				 st[j] = c ;
//			}
//		}
}
