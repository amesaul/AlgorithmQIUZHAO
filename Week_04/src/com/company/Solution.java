package com.company;

public class Solution {
	public String addStrings(String num1, String num2) {
		if (num1.length()<num2.length())
			return addStrings(num2,num1);
		int carry = 0;
		StringBuilder sb1 = new StringBuilder(num1);
		StringBuilder sb2 = new StringBuilder(num2);
		int index1 = num1.length()-1;
		int index2 = num2.length()-1;
		StringBuilder result = new StringBuilder(num1.length()+1);
		for (int i = 0; i < result.capacity(); i++) {
			if (index1==-1) {
				if(carry == 1)
					result.append(1);
				break;
			}
			int a = num1.charAt(index1)-'0';
			int b = 0;
			if (index2>=0) {
				b = num2.charAt(index2)-'0';
				index2--;
			}
			int t =a+b+carry;
			result.append(t%10);
			carry = (a+b+carry)/10;
			index1--;
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.addStrings("9","99");
	}
}
