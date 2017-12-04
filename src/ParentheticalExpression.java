public class ParentheticalExpression extends AbstractCompoundExpression {

	public void flatten() {
        for (Expression e : this.getChildren()) {
            e.flatten();
        }
	}

	public ParentheticalExpression() {
		super();
	}

	@Override
	public String convertToString(int indentLevel) {
		String converted = "()";
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
		final Expression copy = new ParentheticalExpression();
		for (Expression e : this.getChildren()) {
			((AbstractCompoundExpression) copy).addSubexpression(e.deepCopy());
		}
		return copy;
	}

}
