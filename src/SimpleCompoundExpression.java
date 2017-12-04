public class SimpleCompoundExpression extends AbstractCompoundExpression {

    // instance variable
    private String _operation;

    public void flatten () {
        Boolean sameType = true;
        for(Expression e : this.getChildren()) {
            if (e.getClass() != this.getClass() && e.getClass() != (new LiteralExpression()).getClass()) {
                sameType = false;
            }
        }
    }
}
