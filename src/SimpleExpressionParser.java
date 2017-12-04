/**
 * Starter code to implement an ExpressionParser. Your parser methods should use
 * the following grammar: 
 * E := A | X 
 * A := A+M | M 
 * M := M*M | X 
 * X := (E) | L 
 * L := [0-9]+ | [a-z]
 */
public class SimpleExpressionParser implements ExpressionParser {
	/*
	 * Attempts to create an expression tree -- flattened as much as possible --
	 * from the specified String. Throws a ExpressionParseException if the specified
	 * string cannot be parsed.
	 * 
	 * @param str the string to parse into an expression tree
	 * 
	 * @param withJavaFXControls you can just ignore this variable for R1
	 * 
	 * @return the Expression object representing the parsed expression tree
	 */
	public Expression parse(String str, boolean withJavaFXControls) throws ExpressionParseException {
		// Remove spaces -- this simplifies the parsing logic
		str = str.replaceAll(" ", "");
		Expression expression = parseExpression(str);
		if (expression == null) {
			// If we couldn't parse the string, then raise an error
			throw new ExpressionParseException("Cannot parse expression: " + str);
		}

		// Flatten the expression before returning
		expression.flatten();
		return expression;
	}

	protected Expression parseExpression(String str) {
		Expression expression;
		if (parseEBoolean(str)) {
			return parseE(str);
		}
		// TODO implement me
		return null;
	}

	private String parseE(String str) {
		if (parseABoolean(str)) {
			return parseA(str);
		} else { //parseXBoolean
			return parseX(str);
		}
	}
	
	private boolean parseEBoolean(String str) {
		if (parseABoolean(str) || parseXBoolean(str)) {
			return true;
		} else {
			return false;
		}
	}
	

	private boolean parseABoolean(String str) {
		return true;
	}
	
	private boolean parseMBoolean(String str) {
		return true;
	}

	private boolean parseXBoolean(String str) {
		return true;
	}
	
	private boolean parseLBoolean(String str) {
		return true;
	}
	

}
