package evaluator;

import java.util.Stack;

public class PostfixEvaluator extends Evaluator {

	@Override
	public int evaluate(String expression) throws ArithmeticException {
		if (expression.equals("") || expression == null){
			throw new ArithmeticException();
		}
		Stack<Integer> stack = new Stack<Integer>(); 
		String[] operations = expression.split(" ");
		for (int i=0; i<operations.length; i++){
			if (isLegal(operations[i]))
				stack.push(Integer.parseInt(operations[i]));
			if (isOperator(operations[i])){
				if (stack.size() < 2)
					throw new ArithmeticException();
				char ops = operations[i].charAt(0);
				int first = stack.pop();
				int second = stack.pop();
				switch(ops){
				case '+': 
					stack.push(first + second);
					break; 
				case '-':
					stack.push(second - first);
					break; 
				case '*':
					stack.push(first * second);
					break; 
				case '/':
					if (first == 0){
						throw new ArithmeticException();
					} 
					stack.push(second/first);
					break; 
				case '^':
					stack.push((int) Math.pow(second, first));
					break;			
				}				
			}
		}
		if (stack.size() > 1)
			throw new ArithmeticException();
		return stack.pop();
	}
}
