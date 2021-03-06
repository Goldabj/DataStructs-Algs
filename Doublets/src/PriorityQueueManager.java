/**
 * Priority Queue Manager
 *
 * @author goldacbj.
 *         Created Nov 1, 2015.
 */
public class PriorityQueueManager extends ChainManager {
	private PriorityQueue priorityQueue;
	private char[] endWord;
	
	public PriorityQueueManager(String word) {
		this.priorityQueue = new PriorityQueue();
		this.endWord = word.toCharArray();
	}

	@Override
	public void add(Chain chain) {
		int priority = getPriority(chain) + this.endWord.length;
		this.priorityQueue.add(chain, priority);
		if(this.priorityQueue.size() > maxSize()) {
			setMaxSize(this.priorityQueue.size());
		}
	}

	@Override
	public Chain next() {
		incrementNumNexts();
		return this.priorityQueue.next();
	}
	
	public int getPriority(Chain chain) {
		String lastElement = chain.getLast();
		char[] elements = lastElement.toCharArray();
		int count = 0;
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] != this.endWord[i]) {
				count++;
			}
		}
		return count;
	}

}
