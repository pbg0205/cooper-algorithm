package summary.linkedlist;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		// add
		list.add(3);
		list.add(4);
		list.add(5);

		System.out.println(list);

		// remove
		list.remove(3);
		// list.remove(4);
		System.out.println(list);

	}
}
