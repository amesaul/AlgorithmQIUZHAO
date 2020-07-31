package DFSandBFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinimumGeneticMutation {
	Integer result = Integer.MAX_VALUE;
	public int minMutation(String start, String end, String[] bank) {
		dfs(0,start,end,bank,new HashSet<>());
		return result==Integer.MAX_VALUE?-1:result;

	}

	private void dfs(int rem, String current, String end, String[] bank, HashSet<Object> visited) {
		if (current.equals(end)){
			result = Math.min(rem,result);
			return;
		}

		for (String s : bank){
			int count = 0 ;
			for (int i = 0 ; i<s.length();++i){
				if (s.charAt(i)!=current.charAt(i)){
					count++;
				}
				if(count>1) break;
			}
			if (count==1&&!visited.contains(s)){
				visited.add(s);
				dfs(rem+1,s,end,bank,visited);
				visited.remove(s);
			}
		}
	}
}
