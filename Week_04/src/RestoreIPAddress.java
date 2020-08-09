import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() == 0 || s.length()>12) return Collections.emptyList();
		bfs(0, 1, s, new StringBuilder(""), result);
		return result;
	}

	private void bfs(int i, int level, String s, StringBuilder sb, List<String> result) {
		if (i == s.length()) {
			if (level == 5) {
				result.add(sb.toString());
			}
			return;
		}

		if (s.charAt(i)=='0'){
			if (level==1)
				bfs(i+1,level+1,s,new StringBuilder(sb).append("0"),result);
			else bfs(i+1,level+1,s,new StringBuilder(sb).append(".0"),result);
			return;
		}
		for (int index = 1; index <= 3; index++) {
			if (i+index>s.length()) return;
			int value= Integer.parseInt(s.substring(i,index+i));
			if (value<256){
				if (level==1){
					bfs(i+index,level+1,s,new StringBuilder(sb).append(value),result);
				}else bfs(i+index,level+1,s,new StringBuilder(sb).append(".").append(value),result);
			}
		}
	}
}
