package DynamicPrograming;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
//		f[i,j] = min(f[i+1,j],f[i+1，j+1]))+triangle[i][j];
		int n = triangle.size();
		int[] memo = new int[n];
		for (int i = 0;i<n;++i) {
			memo[i] = triangle.get(n-1).get(i);
		}
		for (int i = n-2;i>=0;++i){
			for (int j = 0 ; j<i+1; j++){
				memo[j]=Math.min(memo[j+1],memo[j])+triangle.get(i).get(j);
			}
		}
		return memo[0];
	}
}
