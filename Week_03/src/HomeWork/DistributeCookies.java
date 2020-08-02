package HomeWork;

import java.util.Arrays;

public class DistributeCookies {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int indexg =0;
		int indexs =0;
		int result =0;
		while (indexg<g.length&&indexs<s.length) {
			if (g[indexg]<s[indexs]){
				indexg++;
				result++;
			}
			indexs++;
		}
		return result;
	}
}
