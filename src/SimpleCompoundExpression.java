public class SimpleCompoundExpression extends AbstractCompoundExpression {

    // instance variable
    private String _operation;

    public String getOperation (){
        return _operation;
    }

    public void setOperation (String operation){
        _operation = operation;
    }

    public void flatten () {
        Boolean sameType = true;
        for(Expression e : this.getChildren()) {
            if (e.getClass() == this.getClass()){
                if(){

                }
            }
        }
    }
}
