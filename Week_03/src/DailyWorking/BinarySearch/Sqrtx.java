package DailyWorking.BinarySearch;

public class Sqrtx {
	public int mySqrt(int x) {
		if (x==0||x==1) return x;
		long low = 1;
		long high = x;
		long mid=0;
		while (low<high){
			mid = (low+high)/2;
			if (mid*mid>x)
				high = mid;
			else  if (mid*mid<x)
				low = mid+1;
			else break;
		}
		return (int) mid;
	}
}
