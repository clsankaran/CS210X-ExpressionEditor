import java.util.ArrayList;

public class SimpleCompoundExpression extends AbstractCompoundExpression {

	// instance variable
	private String _operation;

	/**
	 * Constructor for SimpleCompoundExpressions
	 *
	 * @param operation the operation (* or +)
	 */
	public SimpleCompoundExpression(String operation) {
		super();
		_operation = operation;
	}

	/**
	 * Method that flattens the expression tree.
	 */
	public void flatten() {
        ArrayList<Expression> toAdd = new ArrayList<Expression>();
		for (Expression e : this.getChildren()) {
			e.flatten(); // recursively call flatten on children
			if (e.getClass() == this.getClass()) { // Check if children is a SimpleCompoundExpression
				if (this._operation.equals(((SimpleCompoundExpression) e)._operation)) { // Check if operation of children is the same.
					for (Expression c : ((SimpleCompoundExpression) e).getChildren()) {
						toAdd.add(c); // adds children of children with the same operation to toAdd.
					}
				} else {
					toAdd.add(e); // adds the child to toAdd if the operation is different
				}
			} else {
				toAdd.add(e); // adds the child to toAdd if it is of type literal or parenthetical
			}
		}
		this.clearSubexpression(); // clears subexpressions so that the order will stay the same
		for (Expression a : toAdd){
			this.addSubexpression(a); // adds all Expressions in toAdd as children of this
		}
	}

	/**
	 * Method that converts the expression tree into a String
	 *
	 * @param indentLevel the number of times the operation should be indented
	 */
	@Override
	public String convertToString(int indentLevel) {
		String converted = _operation;
		for (int i = 0; i < indentLevel; i++) {
			converted = "\t" + converted; // add specified number of tabs
		}
		converted = converted + "\n"; // add a new line at the end
		for (Expression e : this.getChildren()) {
			converted = converted + e.convertToString(indentLevel + 1); // add children strings recursively
		}
		return (converted);
	}

	/**
	 * Method that creates a deep copy of this expression
	 */
	public Expression deepCopy() {
		final Expression copy = new SimpleCompoundExpression(_operation);
		for (Expression e : this.getChildren()) {
			((AbstractCompoundExpression) copy).addSubexpression(e.deepCopy());
		}
		return copy;
	}
}
