package linkedlisthalfreverse;

public class ReverseLinkedList {
	public static void main(String args[]) {
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		System.out.println(Node.reverseLinkedList(head));
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}

	public static Node reverseLinkedList(Node head) {
		Node current = head;
		Node previous = null;
		while (current != null) {
			Node nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}
		head = previous;
		return head;
	}
}