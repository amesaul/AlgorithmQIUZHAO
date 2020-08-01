package Greedy;

import java.util.HashMap;
import java.util.*;

public class LemonChange {
	public boolean lemonadeChange(int[] bills) {
		Map<Integer,Integer> map = new HashMap<>();
		map.put(5,0);
		map.put(10,0);
		for (int i = 0;i<bills.length;++i){
			if (map.get(5)<0) return false;
			if (bills[i]==5) {
				map.put(5,map.get(5)+1);
			}
			if (bills[i]==10) {
				map.put(10,map.get(10)+1);
				map.put(5,map.get(5)-1);
			}
			if (bills[i]==20) {
				if (map.get(10)>0) {
					map.put(10,map.get(10)-1);
					map.put(5,map.get(5)-1);
				}else {
					map.put(5,map.get(5)-3);
				}
			}
		}
		return true;
	}
}
