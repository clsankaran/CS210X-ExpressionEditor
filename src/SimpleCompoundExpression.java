public class SimpleCompoundExpression extends AbstractCompoundExpression {

    // instance variable
    private String _operation;

    public SimpleCompoundExpression(String operation){
        _operation = operation;
    }

    public void flatten () {
        for(Expression e : this.getChildren()) {
            e.flatten();
            if (e.getClass() == this.getClass()){
                if(this._operation.equals(((SimpleCompoundExpression) e)._operation)){
                    for(Expression c : ((SimpleCompoundExpression) e).getChildren()){
                        this.addSubexpression(c);
                    }
                    this.removeSubexpression(e);
                }
            }
        }
    }

	@Override
	public String convertToString(int indentLevel) {
        String converted = _operation;
        for(int i = 0; i < indentLevel; i++){
            converted = "\t" + converted;
        }
        for(Expression e : this.getChildren()) {
            converted = converted + "\n" + e.convertToString(indentLevel);
        }
        return(converted);
	}
}
