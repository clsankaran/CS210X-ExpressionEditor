public class SimpleCompoundExpression extends AbstractCompoundExpression {

    // instance variable
    private String _operation;

    public SimpleCompoundExpression(String operation){
        _operation = operation;
    }

    public String getOperation (){
        return _operation;
    }

    public void flatten () {
        for(Expression e : this.getChildren()) {
            e.flatten();
            if (e.getClass() == this.getClass()){
                if(this._operation.equals(((SimpleCompoundExpression) e).getOperation())){
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
		// TODO Auto-generated method stub
		return null;
	}
}
