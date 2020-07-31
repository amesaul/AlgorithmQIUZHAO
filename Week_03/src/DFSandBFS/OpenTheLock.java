package DFSandBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
	public int openLock(String[] deadends, String target) {
		Queue<String> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		for (String s : deadends) {
			visited.add(s);
		}
		if (visited.contains("0000")) return -1;
		q.add("0000");
		visited.add("0000");
		int step = 0 ;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String s = q.poll();
				if (s.equals(target)) return step+1;
				for (int j = 0; j < target.length(); j++) {
					String up = plusOne(s,j);
					if (!visited.contains(up)){
						q.offer(up);
						visited.add(up);
					}
					String down = minusOne(s,j);
					if (!visited.contains(down)){
						q.offer(down);
						visited.add(down);
					}
				}
			}
			step++;
		}
		return -1;
	}

	private String minusOne(String s, int j) {
		char[] c = s.toCharArray();
		if (c[j]=='0')
			c[j]='9';
		else c[j]-=1;
		return new String(c);
	}

	private String plusOne(String s, int j) {
		char[] c = s.toCharArray();
		if (c[j]=='9')
			c[j]='0';
		else c[j]+=1;
		return new String(c);
	}
}
