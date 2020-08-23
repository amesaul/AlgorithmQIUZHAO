# Week 6

## 1. 习题部分

### 1122 数组的相对排序

```java
class Solution {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] res = new int[arr1.length];
		int[] temp = new int[1001];
		int index = 0;
		for (int i : arr1) temp[i]++;
		for (int i : arr2) {
			while (temp[i] > 0) {
				res[index++] = i;
				temp[i]--;
			}
		}
		for (int i = 0; i < temp.length; ++i) {
			while (temp[i] > 0) {
				res[index++] = i;
				temp[i]--;
			}
		}
		return res;
	}
}
```

### 242 有效的字母异位词

```java
import java.util.Arrays;

class Solution {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		int[] countFirst = new int[26];
		int[] countSecond = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			countFirst[s.charAt(i)-'a']++;
			countSecond[t.charAt(i)-'a']++;
		}
		for (int i = 0; i < countFirst.length; i++) {
			if (countFirst[i]!=countSecond[i])
				return false;
		}
		return true;
	}
}
```

### 680 验证回文字符串

```java
class Solution {
	public boolean validPalindrome(String s) {
		int l = 0;
		int r = s.length() - 1;
		int count = 0;
		while (l < r) {
			if (s.charAt(l)!=s.charAt(r))
				return isPalindrome(l+1,r,s)||isPalindrome(l,r-1,s);
			l++;
			r--;
		}
		return true;
	}

	private boolean isPalindrome(int l, int r, String s) {
		while (l<r) {
			if (s.charAt(l)!=s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
}
```

### 387 字符串中第一个唯一字符

```java
class Solution {
	public int firstUniqChar(String s) {
		int[] arr = new int[26];
		for (char t : s.toCharArray()) {
			arr[t-'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i)-'a']==1)
				return i;
		}
		return -1;
	}
}
```

### LRU缓存机制

```java
import java.util.HashMap;
import java.util.Map;

class LRUCache {
	Map<Integer, DlinkNode> cache = new HashMap<>();
	int size;
	int capacity;
	DlinkNode head, tail;

	public LRUCache(int capacity) {
		size = 0;
		this.capacity = capacity;
		head = new DlinkNode();
		tail = new DlinkNode();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		DlinkNode curr = cache.get(key);
		if (curr == null) return -1;
		moveToHead(curr);
		return curr.value;
	}

	public void put(int key, int value) {
		DlinkNode curr = cache.get(key);
		if (curr == null) {
			DlinkNode newNode = new DlinkNode(key, value);
			cache.put(key, newNode);
			addToHead(newNode);
			size++;
			if (size > capacity) {
				DlinkNode tailNode = removeTail();
				cache.remove(tailNode.key);
				size--;
			}
		}
		else {
			curr.value = value;
			moveToHead(curr);
		}
	}

	private void moveToHead(DlinkNode curr) {
		removeNode(curr);
		addToHead(curr);
	}

	private void addToHead(DlinkNode curr) {
		DlinkNode node = head.next;
		head.next = curr;
		curr.prev = head;
		curr.next = node;
		node.prev = curr;
	}

	private DlinkNode removeTail() {
		DlinkNode node = tail.prev;
		removeNode(node);
		return node;
	}

	private void removeNode(DlinkNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public static class DlinkNode {
		Integer key;
		Integer value;
		DlinkNode prev;
		DlinkNode next;

		public DlinkNode() {
		}

		public DlinkNode(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}
	}
}

```

### 541 反转字符串

```java
class Solution {
	public String reverseStr(String s, int k) {
		if (s.length() == 0 || s == null) return "";
		char[] res = s.toCharArray();
		int end = s.length();
		int begin = 0;
		while (end - begin >= 2 * k) {
			reverse(res, begin, begin + k);
			begin += 2 * k;
		}
		if (end - begin < k)
			reverse(res, begin, end);
		if (end - begin >= k)
			reverse(res, begin, begin + k);
		return new String(res);
	}

	private void reverse(char[] res, int begin, int end) {
		int l = begin, r = end - 1;
		while (l < r) {
			char temp = res[l];
			res[l] = res[r];
			res[r] = temp;
			l++;
			r--;
		}
	}
}
```

### 91  解码方法 

```java
class Solution {
	public int numDecodings(String s) {
		if (s.length() == 0 || s == null) return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= s.length(); ++i) {
			int first = Integer.parseInt(s.substring(i - 1, i));
			int second = Integer.parseInt(s.substring(i - 2, i));
			if (first > 0 && first < 10)
				dp[i] += dp[i - 1];
			if (second >= 10 && second <= 26)
				dp[i] += dp[i - 2];
		}
		return dp[s.length()];
	}
}
```

## 2. 学习总结

### 各种初级排序代码

#### 选择排序SelectionSort

```java
class Solution {
	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			int temp = arr[i];arr[i] = arr[index]; arr[index] = temp;
		}
	}
}
```

#### 插入排序InsertionSort

```java
class Solution {
	public void InsertionSort(int[] arr) {
		for (int i =1;i< arr.length;++i){
			int index = i;
			int temp = arr[i];
			while (index>=1&&temp<arr[index-1]){
				arr[index] = arr[index-1];
				index--;
			}
			arr[index] = temp;
		}
	}
}
```

#### 冒泡排序BubbleSort

```java
class Solution {
	public void BubbleSort(int[] arr) {
		for (int i = 0;i<arr.length;++i){
			for (int j = 1; j<arr.length-i;++j){
				if (arr[j]<arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}

			}
		}
	}
}
```

