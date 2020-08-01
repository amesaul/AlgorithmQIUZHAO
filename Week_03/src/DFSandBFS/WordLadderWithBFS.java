package DFSandBFS;

import javax.lang.model.element.NestingKind;
import java.util.*;

public class WordLadderWithBFS {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> list = new HashSet<>(wordList);
		int count = 0;
		Queue<String> queue = new LinkedList<>();
		if (!list.contains(endWord)) return 0;
		queue.offer(beginWord);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.equals(endWord))
					return count+1;
				char[] c = cur.toCharArray();
				for (int j=0;j<endWord.length();j++){
					char temp = c[j];
					for (char t = 'a';t<='z';++t) {
						c[j]=t;
						String judge =new String(c);
						if (list.contains(judge)) {
							queue.add(judge);
							list.remove(judge);
						}
					}
					c[j]=temp;
				}
			}
			count++;
		}
		return 0;
	}
}
