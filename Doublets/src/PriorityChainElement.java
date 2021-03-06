/**
 * class used with the Priority Queue, therefore it must implement Comapraable
 * and have a prioiryt
 *
 * @author goldacbj.
 *         Created Nov 1, 2015.
 */
public class PriorityChainElement<T> implements Comparable<PriorityChainElement<T>>{
	private Chain chain;
	private int priority;
	
	public PriorityChainElement(Chain s, int priority) {
		this.chain = s;
		this.priority = priority;
	}
	

	@Override
	public int compareTo(PriorityChainElement<T> o) {
		if(this.priority > o.priority) {
			return -1;
		}else if(this.priority < o.priority) {
			return 2;
		}//else equal
		return 1;
	}
	
	public Chain getElement() {
		return this.chain;
	}

}
