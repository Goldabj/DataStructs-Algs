import java.util.Stack;

/**
 * Stack Chain Manager
 *
 * @author goldacbj.
 *         Created Nov 1, 2015.
 */
public class StackManager extends ChainManager {
	private Stack<Chain> stack;
	
	public StackManager() {
		this.stack = new Stack<Chain>();
	}

	@Override
	public void add(Chain chain) {
		this.stack.push(chain);
		if(this.stack.size() > maxSize()){
			setMaxSize(this.stack.size());
		}
		
	}

	@Override
	public Chain next() {
		incrementNumNexts();
		return this.stack.pop();
	}

}
