import java.util.TreeSet;

public class TreeSetPractice {

	public static void main(String[] args) {
		TreeSet<Integer> numTree = new TreeSet<>();
		numTree.add(30);
		numTree.add(5);
		numTree.add(3);
		numTree.add(4);
		numTree.add(10);
		numTree.add(12);
		numTree.add(1);
		System.out.println(numTree.pollFirst().toString());
	}
}
