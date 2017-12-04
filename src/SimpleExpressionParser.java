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

	private Expression parseExpression(String str) {
		Expression expression;
		return parseE(str);
	}

	private Expression parseE(String str) {
		Expression result;
		if (parseA(str) != null) {
			result = parseA(str);
		} else if (parseX(str) != null){ //parseXBoolean
			result = parseX(str);
		}
		return result;
	}
	
	private Expression parseA(String str) {
		Expression result;
		int idxOfPlus = str.indexOf('+');
		while (idxOfPlus > 0) { // try each +
			if (parseA(str.substring(0, idxOfPlus)) != null && parseM(str.substring(idxOfPlus+1)) != null) {
				 result = new SimpleCompoundExpression("+");
				 result.addSubexpression(parseA(str.substring(0, idxOfPlus)));
			}
		}
	}
	
	
	

}
