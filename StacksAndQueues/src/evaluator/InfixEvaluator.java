package evaluator;

import java.util.Stack;

public class InfixEvaluator extends Evaluator {

	@Override
	public int evaluate(String expression) throws ArithmeticException {
		// TODO Auto-generated method stub.

		String postFix = convertToPostfix(expression);
		PostfixEvaluator pfe = new PostfixEvaluator();
		return pfe.evaluate(postFix);
	}

	public String convertToPostfix(String exp) { 
		
		Stack <String> ops = new Stack<String>();
		String[] operations = exp.split(" ");
		StringBuilder postfix = new StringBuilder();
		
		for(int i = 0; i < operations.length; i++){
			// adds numbers to the string
			if (isLegal(operations[i]))
				postfix.append(operations[i] + " ");
			//pops off everything inside parens
			else if (operations[i].contains(")")){
				//checks for too many right parens
				if(!ops.contains("(")) {
					throw new ArithmeticException();
				}
				while (!ops.peek().contains("(") && ops.size()!=0){
					postfix.append(ops.pop() + " ");
				}
				ops.pop();
			}
			//pushes on parens
			else if (operations[i].contains("("))
				ops.push(operations[i]);
			// push on the high order operations
			else if (ops.size() == 0 || rank(ops.peek()) < rank(operations[i])) 
				ops.push(operations[i]);
			//pop off equal rank operations and keeps on the lower ranked ones
			else if(rank(ops.peek()) == rank(operations[i])){
				while(ops.size() != 0 && rank(operations[i]) == rank(ops.peek())) {
					postfix.append(ops.pop() + " ");
				}
				ops.push(operations[i]);
			}
			// pops off higher opperations and push on the lower one
			else {
				while(ops.size() != 0 && !ops.peek().contains("(") ) {
					postfix.append(ops.pop() + " ");
				}
				
				ops.push(operations[i]);
			}
		}
		// add final operators
		while(ops.size() != 0){
			// check for too many ( or operators
			if (ops.peek().contains("(") || postfix.length() == 0)
				throw new ArithmeticException();
			postfix.append(ops.pop() + " ");	
		}
		
		System.out.println(postfix.toString().trim());
		return postfix.toString().trim();
	}
	private int rank(String s){
		if (s.contains(")")) return 5; 
		if (s.contains("^")) return 4; 
		if (s.contains("*") || s.contains("/")) return 3; 
		if (s.contains("+") || s.contains("-")) return 2; 
		if (s.contains("(")) return 1;  
		return 0;
	}		
}	
	
	
	


