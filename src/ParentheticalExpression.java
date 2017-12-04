public class ParentheticalExpression extends AbstractCompoundExpression {

	public void flatten() {
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
		for (Expression e : this.getChildren()) {
			converted = converted + "\n" + e.convertToString(indentLevel + 1);
		}
		return (converted);
	}

}
