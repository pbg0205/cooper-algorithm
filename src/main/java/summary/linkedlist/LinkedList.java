package summary.linkedlist;

import java.util.Objects;

public class LinkedList<T> {

	static class Node <T> {
		private Node nextNode;
		private T value;

		public Node(final T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node{" +
				"nextNode=" + nextNode +
				", value=" + value +
				'}';
		}

	}

	private Node root;

	public Boolean add(T number) {
		if (this.root == null) {
			this.root = new Node(number);
			return true;
		}

		// next 로직 필요
		Node leafNode = leaf();
		leafNode.nextNode = new Node(number);

		return true;
	}

	public Boolean remove(Integer number) {
		if (Objects.equals(root.value, number)) { // root 제거
			root = root.nextNode;
			return true;
		}

		Node currentNode = this.root;
		Node nextNode = this.root.nextNode;
		Node nextnextNode = this.root.nextNode.nextNode;

		while (currentNode.nextNode != null) { // root 다음부터 탐색
			if (Objects.equals(nextNode.value, number)) {
				currentNode.nextNode = nextnextNode;
				return true;
			}

			currentNode = currentNode.nextNode;
		}

		return false;
	}

	public Node leaf() {
		Node currentNode = this.root;
		while (currentNode.nextNode != null) {
			currentNode = currentNode.nextNode;
		}

		return currentNode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		Node currentNode = this.root;
		while (currentNode.nextNode != null) {
			builder.append(currentNode.value).append(" ");
			currentNode = currentNode.nextNode;
		}

		builder.append(currentNode.value);

		return builder.toString();
	}

}
