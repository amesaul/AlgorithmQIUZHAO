package Greedy;

import java.util.Arrays;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
		int i = 0 ;
		int j = 0 ;
		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0 ;
		while (i<g.length&&j<s.length) {
			if (g[i]<=s[j]) {
				count++;
				i++;
			}
			j++;
		}
		return count;
	}
}
