package linkedlist;

public class Reverse {
	
	private static class Node {
		int data;
		Node next;		
		
		public Node (int data, Node next) {
			this.next = next;
			this.data = data;
		}
	}
	
	public static void s_rev(Node head, Node prev) {
		if (head.next != null) {
			//prev = head;
			s_rev(head.next, head);
	}
		if (head.next == null) {			
			head.next = prev;
			System.out.println(head.data);
			prev.next = null;
		}
	}
	
	public static Node rev(Node head) {
		int count = 0;
		while (head != null) {
			count++;
		}
		for (int i = 0 ; i < count / 2 ; i++) {
			swap(head, count - i);
			count--;			
		}
		
		return head;
	}

	private static void swap(Node head, int count) {
		Node last = head;
		for (int i = 0 ; i < count ; i++) {
			last = last.next;
		}
		int a = last.data;
		int b = head.data;
		b = b-a;
		b = b-a;
		a = a+b;
		//node.
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node(4, null);
		head.next = new Node(3, null);
		head.next.next = new Node(2, null);
		head.next.next.next = new Node(1, null);
		head.next.next.next.next = new Node(0, null);
		s_rev(head, null);
		/* while (head2 != null) {
			System.out.println(head2.data);
		}*/
	}
}
