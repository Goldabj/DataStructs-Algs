package stacks;

import java.util.EmptyStackException;

public interface PurgeableStack<T> {
	/**
	 * Add the given item to the top of the stack.
	 * 
	 * @param item
	 */
	public void push(T item);

	/**
	 * Removes and returns the item at the top of the stack.
	 * 
	 * @return The item removed from the top of the stack.
	 * @throws EmptyStackException
	 *             If the stack is empty.
	 */
	public T pop() throws EmptyStackException;

	/**
	 * Returns the item at the top of the stack without mutating the stack.
	 * 
	 * @return The item at the top of the stack.
	 * @throws EmptyStackException
	 *             If the stack is empty.
	 */
	public T peek() throws EmptyStackException;

	/**
	 * @return True if and only if the stack contains no items.
	 */
	public boolean isEmpty();

	/**
	 * @return The number of items in this stack.
	 */
	public int size();

	/**
	 * Displays the contents of the stack, starting with the
	 * most-recently inserted one last. Each adjacent pair will be separated 
	 * by a comma and a space, and the whole contents will be bounded 
	 * by square brackets. See the unit tests for examples.
	 */
	public String toString();

	/**
	 * Removes all the items from this stack and everything back to the initial
	 * state, including setting its capacity back to the initial capacity.
	 */
	public void clear();

	/**
	 * Searches for the given item in this stack. If found, it returns the
	 * number of elements atop this item in the stack. If not found, returns -1.
	 * 
	 * @param item
	 * @return the number of items atop the found one; otherwise -1.
	 */
	public int depth(T item);

	/**
	 * Removes roughly half the items in this stack, by removing every other
	 * item. The top item will always be removed and every other one down the
	 * stack. This means if there is an odd number of items, that slightly more
	 * than half of the stack will be purged. For example, if we push the values
	 * a, b, c, so that c is on top, then purge will remove a and c.
	 */
	public void purge();
}
