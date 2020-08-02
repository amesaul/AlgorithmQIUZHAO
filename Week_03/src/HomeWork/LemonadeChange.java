package HomeWork;

public class LemonadeChange {
	public boolean lemonadeChange(int[] bills) {
		int fiveDollarCount = 0;
		int tenDollarCount = 0;
		for (int x :bills) {
			if (x==5)
				fiveDollarCount++;
			if (x==10) {
				fiveDollarCount--;
				tenDollarCount++;
			}
			if (x==20) {
				if (tenDollarCount>0){
					tenDollarCount--;
					fiveDollarCount--;
				}else {
					fiveDollarCount=fiveDollarCount-3;
				}
			}
			if (fiveDollarCount<0) return false;
		}
		return true;
	}
}
