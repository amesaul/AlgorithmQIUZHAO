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
