package ru.free0u.calculator;

public class MathParser {
	final double eps = 1e-5;
	
	public MathParser() {
		
	}
	
	public boolean equalDouble(double a, double b) {
		return Math.abs(a - b) < eps;
	}
	
	public double evaluate(String exp) {
		return 0;
	}
}
