package DailyWorking.BinarySearch;

public class Powxn {
	public double myPow(double x, int n) {
		if(x==1) return 1;
		if (x<0&&n<0)
			return (-n)%2==0?1/myPow(-x,-n):-1*1/myPow(-x,-n);
		else if (x<0&&n>0)
			return (-n)%2==0?myPow(-x,n):-1*myPow(-x,n);
		else if (x>0&&n<0)
			return 1/myPow(x,-n);
		else if (x==0) return 0;
		return pow(x,n);
	}

	private double pow(double x, int n) {
//		recursion terminator
		if (n==0)
			return 1;
//	    process current logic
		double half = pow(x,n/2);
		if (n%2==0) return half*half;
		else return half*half*x;
	}
}
