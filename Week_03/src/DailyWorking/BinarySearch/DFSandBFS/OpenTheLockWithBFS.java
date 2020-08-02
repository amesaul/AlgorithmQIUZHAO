package DailyWorking.BinarySearch.DFSandBFS;

import java.util.HashSet;

public class OpenTheLockWithBFS {
	public int openLock(String[] deadends, String target) {
		HashSet<String> dead = new HashSet<>();
		for (String s : deadends)
			dead.add(s);
		HashSet<String> visited = new HashSet<>();
		HashSet<String> start = new HashSet<>();
		HashSet<String> end = new HashSet<>();
		int count = 0;
		start.add("0000");
		end.add(target);
		while (!start.isEmpty()&&!end.isEmpty()) {
			HashSet<String> temp = new HashSet<>();
			for (String s : start) {
				if (dead.contains(s))
					continue;
				if (end.contains(s))
					return count;
				visited.add(s);
				for (int i = 0 ; i < target.length();++i) {
					String plus = plusOne(s,i);
					if (!visited.contains(plus))
						temp.add(plus);
					String minus = minusOne(s,i);
					if (!visited.contains(minus))
						temp.add(minus);
				}
			}
			count++;
			start=end;
			end=temp;
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
