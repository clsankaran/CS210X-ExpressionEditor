public class LiteralExpression implements Expression {

    private CompoundExpression _parent;
    private char _value;

    public LiteralExpression(char value){
        _value = value;
    }
    /**
     * Returns the expression's parent.
     * @return the expression's parent
     */
    public CompoundExpression getParent (){
        return _parent;
    }

    /**
     * Sets the parent be the specified expression.
     * @param parent the CompoundExpression that should be the parent of the target object
     */
    public void setParent (CompoundExpression parent){
        _parent = parent;
    }

    /**
     * Creates and returns a deep copy of the expression.
     * The entire tree rooted at the target node is copied, i.e.,
     * the copied Expression is as deep as possible.
     * @return the deep copy
     */
    public Expression deepCopy (){
        LiteralExpression copy = new LiteralExpression(_value);
        
        return copy;
    }

    /**
     * Recursively flattens the expression as much as possible
     * throughout the entire tree. Specifically, in every multiplicative
     * or additive expression x whose first or last
     * child c is of the same type as x, the children of c will be added to x, and
     * c itself will be removed. This method modifies the expression itself.
     */
    public void flatten (){
        // No flatten method necessary because Literal expressions have no children.
    }

    /**
     * Creates a String representation by recursively printing out (using indentation) the
     * tree represented by this expression, starting at the specified indentation level.
     * @param indentLevel the indentation level (number of tabs from the left margin) at which to start
     * @return a String representation of the expression tree.
     */
    public String convertToString (int indentLevel){
        String converted = "" + _value;
        for(int i = 0; i < indentLevel; i++){
            converted = "\t" + converted;
        }
        return(converted);
    }

    /**
     * Static helper method to indent a specified number of times from the left margin, by
     * appending tab characters to teh specified StringBuffer.
     * @param sb the StringBuffer to which to append tab characters.
     * @param indentLevel the number of tabs to append.
     */
    public static void indent (StringBuffer sb, int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            sb.append('\t');
        }
    }

}
