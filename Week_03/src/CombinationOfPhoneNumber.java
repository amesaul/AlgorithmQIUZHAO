import java.util.*;

public class CombinationOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
		HashMap<Character,String> map = new HashMap<>();
		initMap(map);
		List<String> result = new ArrayList<>();
		if (digits.length()==0) return Collections.emptyList();
		combination(0,digits,new StringBuilder(),result,map);
		return result;
	}

	private void combination(int i, String digits, StringBuilder s , List<String> result,HashMap<Character,String> map) {
		if (i == digits.length()){
			result.add(s.toString());
			return;
		}
//		current logic
		for (char t :map.get(digits.charAt(i)).toCharArray()){
			s.append(t);
			combination(i+1,digits,new StringBuilder(s.toString()),result,map);
			s.deleteCharAt(i);
		}
	}

	private void initMap(HashMap<Character, String> map) {
		map.put('2',"abc");
		map.put('3',"def");
		map.put('4',"ghi");
		map.put('5',"jkl");
		map.put('6',"mno");
		map.put('7',"pqrs");
		map.put('8',"tuv");
		map.put('9',"wxyz");
	}
}
