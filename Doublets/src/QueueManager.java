import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue Chain Manager
 *
 * @author goldacbj.
 *         Created Nov 1, 2015.
 */
public class QueueManager extends ChainManager{
	protected Queue myQ;
	protected int nexts;
	
	QueueManager(){
		this.myQ = new LinkedList<Chain>();
		this.nexts = this.getNumberOfNexts();
	}

	@Override
	public void add(Chain chain) {
		this.myQ.add(chain);
		setMaxSize(this.myQ.size());
	}

	@Override
	public Chain next() {
		this.incrementNumNexts();
		return (Chain) myQ.poll();
	}
	

}