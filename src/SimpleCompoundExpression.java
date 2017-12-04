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
        Boolean sameType = true;
        for(Expression e : this.getChildren()) {
            if (e.getClass() == this.getClass()){
                if(!this._operation.equals(((SimpleCompoundExpression) e).getOperation())){
                    sameType = false;
                }
            } else if (){

            }
        }
    }
}
