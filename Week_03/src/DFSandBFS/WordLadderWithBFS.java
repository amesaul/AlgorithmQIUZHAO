package DFSandBFS;

import javax.lang.model.element.NestingKind;
import java.util.*;

public class WordLadderWithBFS {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> dict = new HashSet<>(wordList);
		Queue<String> q = new LinkedList<>();
		if (!dict.contains(endWord)) return 0;
		int level = 0;
		dict.remove(beginWord);
		q.add(beginWord);
		while (!q.isEmpty()) {
			for (int size = q.size(); size > 0; --size) {
				String cur = q.poll();
				if (cur.equals(endWord)) return level+1;
				char[] wordUnit = cur.toCharArray();
				for (int i = 0 ; i < wordUnit.length ; ++i ){
					char temp = wordUnit[i];
					for (char c = 'a'; c<='z';c++) {
						wordUnit[i] = c ;
						String s = new String(wordUnit);
						if (dict.contains(s)) {
							dict.remove(s);
							q.add(s);
						}
					}
					wordUnit[i] =temp;
				}
			}
			level++;
		}
		return level;
	}
}
