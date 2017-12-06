import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.io.*;

/**
 * Code to test Project 5; you should definitely add more tests!
 */
public class ExpressionParserPartialTester {
	private ExpressionParser _parser;

	@Before
	/**
	 * Instantiates the actors and movies graphs
	 */
	public void setUp() throws IOException {
		_parser = new SimpleExpressionParser();
	}

	@Test
	/**
	 * Verifies that a specific expression is parsed into the correct parse tree.
	 */
	public void testExpression3() throws ExpressionParseException {
		final String expressionStr = "4*(z+5*x)";
		final String parseTreeStr = "·\n\t4\n\t()\n\t\t+\n\t\t\tz\n\t\t\t·\n\t\t\t\t5\n\t\t\t\tx\n";
		assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0).replace('*', '·'));
	}

	@Test
	/**
	 * Verifies that a specific expression is parsed into the correct parse tree.
	 */
	public void testExpression4() throws ExpressionParseException {
		final String expressionStr = "((x))";
		final String parseTreeStr = "()\n\t()\n\t\tx\n";
		assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0).replace('*', '·'));
	}

	@Test
	/**
	 * Verifies that a specific expression is parsed into the correct parse tree.
	 */
	public void testExpression5() throws ExpressionParseException {
		final String expressionStr = "(2*x+5)*8";
		final String parseTreeStr = "·\n\t()\n\t\t+\n\t\t\t·\n\t\t\t\t2\n\t\t\t\tx\n\t\t\t5\n\t8\n";
		assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0).replace('*', '·'));
	}

	@Test
	/**
	 * Verifies that a specific expression is parsed into the correct parse tree.
	 */
	public void testExpression6() throws ExpressionParseException {
		final String expressionStr = "(2*x+5)*((x+2*y))";
		System.out.println(_parser.parse(expressionStr, false).convertToString(0));
		final String parseTreeStr = "·\n\t()\n\t\t+\n\t\t\t·\n\t\t\t\t2\n\t\t\t\tx\n\t\t\t5\n\t()\n\t\t()\n\t\t\t+\n\t\t\t\tx\n\t\t\t\t·\n\t\t\t\t\t2\n\t\t\t\t\ty\n";
		assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0).replace('*', '·'));
	}

	@Test
	/**
	 * Just verifies that the SimpleExpressionParser could be instantiated without
	 * crashing.
	 */
	public void finishedLoading() {
		assertTrue(true);
		// Yay! We didn't crash
	}

	@Test
	/**
	 * Verifies that a specific expression is parsed into the correct parse tree.
	 */
	public void testExpression2() throws ExpressionParseException {
		final String expressionStr = "13*x";
		final String parseTreeStr = "·\n\t13\n\tx\n";
		assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0).replace('*', '·'));
	}

	@Test
	/**
	 * Verifies that a specific expression is flattened into the correct parse tree.
	 */
	public void testExpressionAndFlatten1() throws ExpressionParseException {
		final String expressionStr = "1+2+3";
		final String parseTreeStr = "+\n\t1\n\t2\n\t3\n";
		assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0).replace('*', '·'));
	}

	@Test
	/**
	 * Verifies that a specific expression is flattened into the correct parse tree.
	 */
	public void testExpressionAndFlatten2() throws ExpressionParseException {
		final String expressionStr = "(x+(x)+(x+x)+x)";
		final String parseTreeStr = "()\n\t+\n\t\tx\n\t\t()\n\t\t\tx\n\t\t()\n\t\t\t+\n\t\t\t\tx\n\t\t\t\tx\n\t\tx\n";
		assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0).replace('*', '·'));
	}
	
	@Test
	/**
	 * Verifies that a specific expression is flattened into the correct parse tree.
	 */
	public void testExpressionAndFlatten3() throws ExpressionParseException {
		final String expressionStr = "2*x*y";
		final String parseTreeStr = "·\n\t2\n\tx\n\ty\n";
		assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0).replace('*', '·'));
	}
	
	@Test
	/**
	 * Verifies that a specific expression is flattened into the correct parse tree.
	 */
	public void testExpressionAndFlatten4() throws ExpressionParseException {
		final String expressionStr = "(((x+y+z)))";
		final String parseTreeStr = "()\n\t()\n\t\t()\n\t\t\t+\n\t\t\t\tx\n\t\t\t\ty\n\t\t\t\tz\n"; // should not flatten ()
		assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0).replace('*', '·'));
	}

	@Test(expected = ExpressionParseException.class)
	/**
	 * Verifies that a specific expression correctly throws an error.
	 */
	public void testException1() throws ExpressionParseException {
		final String expressionStr = "1+2+";
		_parser.parse(expressionStr, false);
	}

	@Test(expected = ExpressionParseException.class)
	/**
	 * Verifies that a specific expression correctly throws an error.
	 */
	public void testException2() throws ExpressionParseException {
		final String expressionStr = "((()))";
		_parser.parse(expressionStr, false);
	}

	@Test(expected = ExpressionParseException.class)
	/**
	 * Verifies that a specific expression correctly throws an error.
	 */
	public void testException3() throws ExpressionParseException {
		final String expressionStr = "()()";
		_parser.parse(expressionStr, false);
	}

	@Test(expected = ExpressionParseException.class)
	/**
	 * Verifies that a specific expression correctly throws an error.
	 */
	public void testException4() throws ExpressionParseException {
		final String expressionStr = "(((";
		_parser.parse(expressionStr, false);
	}

	@Test(expected = ExpressionParseException.class)
	/**
	 * Verifies that a specific expression correctly throws an error.
	 */
	public void testException5() throws ExpressionParseException {
		final String expressionStr = "(2*x)+5*y*z+(x+)";
		_parser.parse(expressionStr, false);
	}

	@Test
	/**
	 * Verifies that a specific expression is parsed into the correct parse tree.
	 */
	public void testExpression1() throws ExpressionParseException {
		final String expressionStr = "a+b";
		final String parseTreeStr = "+\n\ta\n\tb\n";
		assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0).replace('*', '·'));
	}

	@Test
	/**
	 * Verifies that deep copy works.
	 */
	public void deepCopy() throws ExpressionParseException {
		final String expressionStr = "4*(z+5*x)";
		final Expression original = _parser.parse(expressionStr, false);
		final Expression copy = original.deepCopy();
		assertEquals(original, original);
		assertEquals(copy, copy);
		assertNotEquals(original, copy); // copy and original shouldn't have same reference
		/*
		 * following test works (as it should) when _value is public
		 * assertEquals(((LiteralExpression) ((AbstractCompoundExpression)
		 * original).getChildren().get(0))._value, ((LiteralExpression)
		 * ((AbstractCompoundExpression) copy).getChildren().get(0))._value);
		 * ((AbstractCompoundExpression) original).addSubexpression(_parser.parse("y",
		 * false));
		 */
		assertNotEquals(((AbstractCompoundExpression) original).getChildren(),
				((AbstractCompoundExpression) copy).getChildren()); // children shouldn't have same reference
		assertNotEquals(((AbstractCompoundExpression) original).getChildren().get(0),
				((AbstractCompoundExpression) copy).getChildren().get(0)); // specific child shouldn't have same
																			// reference
		((AbstractCompoundExpression) original).addSubexpression(_parser.parse("y", false));
		assertNotEquals(((AbstractCompoundExpression) original).getChildren().size(),
				((AbstractCompoundExpression) copy).getChildren().size()); // adding children to one shouldn't add it to
																			// another
	}

}
