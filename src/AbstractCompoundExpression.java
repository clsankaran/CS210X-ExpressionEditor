import java.util.*;

public abstract class AbstractCompoundExpression implements CompoundExpression {

	private CompoundExpression _parent;
	private List<Expression> _children;

	protected AbstractCompoundExpression() {
		_children = new ArrayList<Expression>();
	}

	/**
	 * Returns the expression's parent.
	 * 
	 * @return the expression's parent
	 */
	public CompoundExpression getParent() {
		return _parent;
	}

	/**
	 * Returns the expression's parent.
	 * 
	 * @return the expression's parent
	 */
	public List<Expression> getChildren() {
		return _children;
	}

	/**
	 * Sets the parent be the specified expression.
	 * 
	 * @param parent
	 *            the CompoundExpression that should be the parent of the target
	 *            object
	 */
	public void setParent(CompoundExpression parent) {
		_parent = parent;
	}

	/**
	 * Creates and returns a deep copy of the expression. The entire tree rooted at
	 * the target node is copied, i.e., the copied Expression is as deep as
	 * possible.
	 * 
	 * @return the deep copy
	 */
	public Expression deepCopy() {
		return this;
	}

	/**
	 * Recursively flattens the expression as much as possible throughout the entire
	 * tree. Specifically, in every multiplicative or additive expression x whose
	 * first or last child c is of the same type as x, the children of c will be
	 * added to x, and c itself will be removed. This method modifies the expression
	 * itself.
	 */
	public abstract void flatten();

	/**
	 * Creates a String representation by recursively printing out (using
	 * indentation) the tree represented by this expression, starting at the
	 * specified indentation level.
	 * 
	 * @param indentLevel
	 *            the indentation level (number of tabs from the left margin) at
	 *            which to start
	 * @return a String representation of the expression tree.
	 */
	public abstract String convertToString(int indentLevel);

	public void addSubexpression(Expression subexpression) {
		_children.add(subexpression);
		subexpression.setParent(this);
	}

	public void removeSubexpression(Expression subexpression) {
		_children.remove(subexpression);
	}
}
