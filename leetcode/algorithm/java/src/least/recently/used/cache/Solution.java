package least.recently.used.cache;

import java.util.HashMap;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {

	class Node {
		int key;
		int val;
		Node prev;
		Node next;
		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	Node head;
	Node tail;

	HashMap<Integer, Node> map;

	int capacity;

	public LRUCache(int capacity) {
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;

		map = new HashMap<>(capacity);
		this.capacity = capacity;
	}

	private void moveToHead(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;

		node.next = head.next;
		head.next.prev = node;

		node.prev = head;
		head.next = node;
	}

	private void addToHead(Node node) {
		head.next.prev = node;
		node.next = head.next;

		node.prev = head;
		head.next = node;
	}

	private void deleteLast() {
		Node last = tail.prev;

		if (last == head) {
			return;
		}

		last.prev.next = tail;
		tail.prev = last.prev;

		map.remove(last.key);
	}

	public int get(int key) {
		Node node = map.get(key);

		if (node != null) {
			moveToHead(node);
			return node.val;
		}

		return -1;
	}

	public void put(int key, int value) {
		Node node = map.get(key);

		if (node != null) {
			node.val = value;
			moveToHead(node);
			return;
		}

		node = new Node(key, value);

		//if (map.size() > capacity) {
		//	throw new Exception("illegal size of cache");
		//}

		if (map.size() == capacity) {
			deleteLast();
		}

		addToHead(node);
		map.put(key, node);
	}
}