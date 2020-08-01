package DFSandBFS;

import java.util.*;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		Set<String> start = new HashSet<>();
		Set<String> end = new HashSet<>();
		start.add(beginWord);
		if (!dict.contains(endWord)) return 0;
		end.add(endWord);
		int count = 0;
		while (!start.isEmpty()&&!end.isEmpty()) {
			Set<String> temp = new HashSet<>();
			for (String curr : start){
				if (end.contains(curr))
					return count+1;
				dict.remove(curr);
				char[] c= curr.toCharArray();
				for (int i = 0 ; i <endWord.length();++i){
					char save=c[i];
					for (char j = 'a';j<='z';++j) {
						c[i]=j;
						String judge = new String(c);
						if (dict.contains(judge)){
							temp.add(judge);
						}
					}
					c[i]=save;
				}
			}
			count++;
			start = end ;
			end = temp;
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
