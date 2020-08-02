package DailyWorking.BinarySearch;

public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num==0||num==1) return true;
		int low = 1;
		int high = num;
		int mid = 0;
		while (low<high){
			mid = (low+high)/2;
			if (Math.pow(mid,2)>num) {
				high = mid-1;
			}
			else if (Math.pow(mid,2)<num) {
				low =mid+1;
			}else return true;
		}
		return false;
	}
}
