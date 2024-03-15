package merge.two.sorted.list;

import util.singlely.linked.list.node.ListNode;

class Solution {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		ListNode dummyHead = new ListNode();
		ListNode curr = dummyHead;

		while (true) {

			if (list1 == null && list2 == null) {
				break;
			}

			if (list1 == null) {
				curr.next = list2;
				list2 = list2.next;
			}
			else if (list2 == null ) {
				curr.next = list1;
				list1 = list1.next;
			}
			else if (list2.val <= list1.val) {
				curr.next = list2;
				list2 = list2.next;
			}
			else {
				curr.next = list1;
				list1 = list1.next;
			}

			curr = curr.next;
		}

		return dummyHead.next;
	}
}