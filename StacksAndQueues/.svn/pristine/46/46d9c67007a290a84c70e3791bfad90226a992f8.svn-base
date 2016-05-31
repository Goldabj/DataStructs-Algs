package queues;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueFromStacks<T> implements SimpleQueue<T> {
	Stack<T> pushStack = new Stack<>();
	Stack<T> popStack = new Stack<>();
	int size = 0;

	public QueueFromStacks() {

	}

	@Override
	public void clear() {
		// clear the first stack
		this.pushStack = new Stack<>();
		this.popStack = new Stack<>();
		this.size = 0;
	}

	@Override
	public void enqueue(T item) {
		this.pushStack.push(item);
		this.size++;

	}

	@Override
	public T dequeue() throws NoSuchElementException {
		if (this.size == 0) {
			throw new NoSuchElementException();
		}
		// put everything in reverse on popstack
		while (!this.pushStack.isEmpty()) {
			this.popStack.push(this.pushStack.pop());
		}
		T removed = this.popStack.pop();
		this.size--;
		// put it back onto push stack
		while (!this.popStack.isEmpty()) {
			this.pushStack.push(this.popStack.pop());
		}
		return removed;
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO Auto-generated method stub.
		if (this.size == 0) {
			throw new NoSuchElementException();
		}
		T peek = this.pushStack.get(0);
		return peek;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean contains(T item) {
		for (int i = 0; i < this.size; i++) {
			if (this.pushStack.get(i).equals(item)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String debugString() {
		String pushString = "[";
		for (int i = 0; i < this.size; i++) {
			pushString += this.pushStack.get(i) + ", ";
		}
		if (pushString.length() > 2) {
			pushString.substring(0, pushString.length() - 2);
		}

		return pushString + "]";
	}

	@Override
	public String toString() {
		String pushString = this.pushStack.toString();

		return pushString;
	}

}
