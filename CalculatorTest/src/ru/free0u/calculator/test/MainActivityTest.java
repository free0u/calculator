package ru.free0u.calculator.test;

import junit.framework.Assert;
import ru.free0u.calculator.MainActivity;
import ru.free0u.calculator.MathParser;

import android.test.ActivityInstrumentationTestCase2;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	MathParser mp;
	final double eps = 1e-5;
	
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mp = new MathParser();
	}
	
	public boolean equalDouble(double a, double b) {
		return Math.abs(a - b) < eps;
	}
	
	public void testCase0() {
		String exp = "0";
		double res = 0;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
    }
	
	public void testCase1() {
		String exp = "2+2";
		double res = 4;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
    }
	
	public void testCase2() {
		String exp = "2+2*2";
		double res = 6;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
    }
	
	public void testCase3() {
		String exp = "-1";
		double res = -1;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
    }
	
	public void testCase4() {
		String exp = "+2";
		double res = 2;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
    }
	
	public void testCase5() {
		String exp = "+-2";
		double res = -2;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
    }
	
	
	public void testCase6() {
		String exp = "-+2";
		double res = -2;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
    }
	
	public void testCase7() {
		String exp = "2*+3";
		double res = 6;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
	}
	
	public void testCase8() {
		String exp = "--2";
		double res = 2;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
	}
	
	public void testCase9() {
		String exp = "1/0.0001+0.002";
		double res = 10000.002;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
	}
	
	public void testCase10() {
		String exp = "(2*(3*(1+4)+(2*7)))+(2+3)+1";
		double res = 64;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
	}
	
	public void testCase11() {
		String exp = "((((1+2))))";
		double res = 3;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
	}
	
	
	public void testCase12() {
		String exp = "(1)*((2))*(((3)))*((((4))))";
		double res = 24;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
	}
	
	public void testCase13() {
		String exp = "(1+(2+(3+(4))))";
		double res = 10;
		
		Assert.assertTrue(equalDouble(res, mp.evaluate(exp)));
	}
	
	
	
	public void testCaseIllegal0() {
		String test = "0 0";
		try {
			mp.evaluate(test);
			fail(test);
		} catch (IllegalArgumentException e) {
		}
	}
	
	public void testCaseIllegal1() {
		String test = "*1";
		try {
			mp.evaluate(test);
			fail(test);
		} catch (IllegalArgumentException e) {
		}
	}
	
	public void testCaseIllegal2() {
		String test = "1+";
		try {
			mp.evaluate(test);
			fail(test);
		} catch (IllegalArgumentException e) {
		}
	}
	
	public void testCaseIllegal3() {
		String test = "((1+2)";
		try {
			mp.evaluate(test);
			fail(test);
		} catch (IllegalArgumentException e) {
		}
	}
	
	public void testCaseIllegal4() {
		String test = "(1+2))";
		try {
			mp.evaluate(test);
			fail(test);
		} catch (IllegalArgumentException e) {
		}
	}
	
	
	
	
}
