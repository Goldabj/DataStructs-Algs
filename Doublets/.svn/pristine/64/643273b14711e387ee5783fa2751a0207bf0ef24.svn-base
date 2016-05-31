import java.util.TreeSet;

/**
 * Our implementation of Priority Queue
 *
 * @author goldacbj.
 *         Created Nov 1, 2015.
 */
public class PriorityQueue {
	protected TreeSet<PriorityChainElement<Chain>> priorityQueue;
	
	public PriorityQueue() {
		this.priorityQueue = new TreeSet<PriorityChainElement<Chain>>();
	}

	
	public void add(Chain chain, int priority) {
		this.priorityQueue.add(new PriorityChainElement<Chain>(chain, priority));
	}

	
	public Chain next() {
		return this.priorityQueue.pollFirst().getElement();
	}
	
	public int size() {
		return this.priorityQueue.size();
	}
}
