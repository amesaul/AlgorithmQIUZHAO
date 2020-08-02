package HomeWork;

public class PowXn {
	public double myPow(double x, long n) {
		if (n==0) return 1;
		if(n<0) return 1/pow(x,-n);
		return pow(x,n);
	}

	private double pow(double x, long n) {
		if (n==1) {
			return x;
		}
		double v = pow(x,n/2);
		if (n%2==0) {
			return v*v;
		}else return v*v*x;
	}
}
