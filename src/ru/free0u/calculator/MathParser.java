package ru.free0u.calculator;

public class MathParser {
	final double eps = 1e-5;
	
	char[] operations = {'+', '-', '*', '/'};
	
	public MathParser() {
		
	}
	
	
	
	
	private int findOperationIndex(String exp) {
		for (int i = 0; i < operations.length; ++i) {
			char op = operations[i];
			int index = exp.indexOf(op);
			if (index != -1) return index;
		}
		return -1;
	}
	
	public double evaluate(String exp) {
		int ind = findOperationIndex(exp);
		
		double res;
		
		if (ind == -1) {
			try {
				res = Double.parseDouble(exp);
				return res;
			} catch (Exception e) {
				throw new IllegalArgumentException("Error convert to double <" + exp + ">");
			}
		}
		
		String leftExp, rightExp;
		leftExp = exp.substring(0, ind);
		rightExp = exp.substring(ind + 1, exp.length());
		
		// unary operation
		if (leftExp.equals("")) {
			char op = exp.charAt(ind);
			if (op == '+' || op == '-') {
				return evaluate("0" + op + rightExp);
			} else
			{
				throw new IllegalArgumentException("Error expression <" + op + rightExp + ">");
			}
		}
		
		double leftRes = evaluate(leftExp);
		double rightRes = evaluate(rightExp);

		
		
		switch (exp.charAt(ind)) {
		case '+':
			return leftRes + rightRes;
		case '-':
			return leftRes - rightRes;
		case '*':
			return leftRes * rightRes;
		case '/':
			return leftRes / rightRes;
		default:
			throw new IllegalArgumentException("Error operarion <" + exp.charAt(ind) + ">");
		}
		
	}
}
