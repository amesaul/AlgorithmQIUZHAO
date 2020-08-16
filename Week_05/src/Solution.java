import java.io.FileOutputStream;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> start = new HashSet<>();
		Set<String> end = new HashSet<>();
		int count = 0;
		Set<String> visited = new HashSet<>(wordList);
		start.add(beginWord);
		if (!visited.contains(endWord)) return 0;
		end.add(endWord);
		while (!start.isEmpty()&&!end.isEmpty()){
			if (start.size()>end.size()){
				Set<String> exchange = end;
				end = start;
				start = exchange;
			}
			Set<String> temp = new HashSet<>();
			for (String s : start) {
				if (end.contains(s)) return count+1;
				visited.remove(s);
				char[] chars = s.toCharArray();
				for (int i = 0; i < chars.length; ++i) {
					char c = chars[i];
					for (char j = 'a'; j <= 'z'; j++) {
						chars[i] = j;
						String t = new String(chars);
						if (visited.contains(t)) {
							temp.add(t);
						}
					}
					chars[i] = c;
				}
			}
			start = temp;
			count++;
		}
	return 0;
	}
}





