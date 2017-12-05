public class ParentheticalExpression extends AbstractCompoundExpression {

	public void flatten() {
        for (Expression e : this.getChildren()) {
            e.flatten(); // recursively call flatten on children
        }
	}

	public ParentheticalExpression() {
		super();
	}

	@Override
	public String convertToString(int indentLevel) {
		String converted = "()";
		for (int i = 0; i < indentLevel; i++) {
			converted = "\t" + converted; // add specified number of tabs
		}
        converted = converted + "\n"; // add a new line at the end
		for (Expression e : this.getChildren()) {
			converted = converted + e.convertToString(indentLevel + 1); // add children strings recursively
		}
		return (converted);
	}

	public Expression deepCopy() {
		final Expression copy = new ParentheticalExpression();
		for (Expression e : this.getChildren()) {
			((AbstractCompoundExpression) copy).addSubexpression(e.deepCopy());
		}
		return copy;
	}

}
