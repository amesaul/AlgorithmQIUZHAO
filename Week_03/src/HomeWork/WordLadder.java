package HomeWork;

import DailyWorking.BinarySearch.DFSandBFS.WordLadder2;

import java.util.*;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//		双向bfs
		Set<String> wordlist = new HashSet<>(wordList);
		Set<String> start = new HashSet<>();
		Set<String> end = new HashSet<>();
		start.add(beginWord);
		end.add(endWord);
		wordlist.remove(endWord);
		if (!wordList.contains(endWord)) return 0;
		int step = 0;
		while (!start.isEmpty()&&!end.isEmpty()) {
			Set<String> temp = new HashSet<>();
			if (start.size()>end.size()){
				temp=end;
				end=start;
				start=temp;
				temp.clear();
			}
			for (String s : start) {
				if (end.contains(s))
					return step+1;
				wordlist.remove(s);
				char[] change = s.toCharArray();
				for (int i = 0; i <change.length;i++) {
					char c = change[i];
					for (char j ='a';j<='z';j++) {
						change[i] = j;
						String t = new String(change);
						if (wordlist.contains(t)){
							temp.add(t);
						}
					}
					change[i] = c;
				}
			}
			step++;
			start=temp;
		}
		return 0;
	}
	public static void main(String[] args) {
		String startW = "hit";
		String endW = "cog";
		List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		WordLadder wl = new WordLadder();
		wl.ladderLength(startW,endW,list);

	}
}
