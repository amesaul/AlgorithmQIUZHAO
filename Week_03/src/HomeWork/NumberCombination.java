package HomeWork;

import java.util.*;

public class NumberCombination {
	public List<String> letterCombinations(String digits) {
		Map<Character,String> map = new HashMap<>();
		map.put('2',"abc");
		map.put('3',"def");
		map.put('4',"ghi");
		map.put('5',"jkl");
		map.put('6',"mno");
		map.put('7',"pqrs");
		map.put('8',"tuv");
		map.put('9',"wxyz");
		List<String> result = new ArrayList<>();
		if(digits.length()==0) return Collections.emptyList();
		recursion(0,digits,map,new StringBuilder(""),result);
		return result;
	}

	private void recursion(int i, String digits, Map<Character, String> map, StringBuilder s, List<String> result) {
		if (i==digits.length()) {
			result.add(s.toString());
			return;
		}
		String t = map.get(digits.charAt(i));
		for (char c: t.toCharArray()) {
			recursion(i+1,digits,map,new StringBuilder(s.append(c).toString()),result);
			s.deleteCharAt(i);
		}
	}
}
