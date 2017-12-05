import java.util.ArrayList;

public class SimpleCompoundExpression extends AbstractCompoundExpression {

	// instance variable
	private String _operation;

	public SimpleCompoundExpression(String operation) {
		super();
		_operation = operation;
	}

	public void flatten() {
        ArrayList<Expression> toAdd = new ArrayList<Expression>();
		for (Expression e : this.getChildren()) {
			e.flatten();
			if (e.getClass() == this.getClass()) {
				if (this._operation.equals(((SimpleCompoundExpression) e)._operation)) {
					for (Expression c : ((SimpleCompoundExpression) e).getChildren()) {
						toAdd.add(c);
					}
				} else {
					toAdd.add(e);
				}
			} else {
				toAdd.add(e);
			}
		}
		this.clearSubexpression();
		for (Expression a : toAdd){
			this.addSubexpression(a);
		}
	}

	@Override
	public String convertToString(int indentLevel) {
		String converted = _operation;
		for (int i = 0; i < indentLevel; i++) {
			converted = "\t" + converted;
		}
		converted = converted + "\n";
		for (Expression e : this.getChildren()) {
			converted = converted + e.convertToString(indentLevel + 1);
		}
		return (converted);
	}

	public Expression deepCopy() {
		final Expression copy = new SimpleCompoundExpression(_operation);
		for (Expression e : this.getChildren()) {
			((AbstractCompoundExpression) copy).addSubexpression(e.deepCopy());
		}
		return copy;
	}
}
