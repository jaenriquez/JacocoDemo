package example;

public class ArrayStack implements Stack {

    private Object[] theArray;
    private int topOfStack;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Construct the stack.
     */
    public ArrayStack( ) {
        theArray = new Object[ DEFAULT_CAPACITY ];
        topOfStack = -1;
    }

    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return topOfStack == -1;
    }

    /**
     * Insert a new item into the stack.
     * @param x the item to insert.
     */
    public void push( Object x ) {
        if ( topOfStack + 1 == theArray.length ) {
            doubleArray( );
        }
        theArray[ ++topOfStack ] = x;
    }

    /**
     * Remove the most recently inserted item from the stack.
     * @throws UnderflowException if the stack is empty.
     */
    public Object pop( ) throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException( "example.ArrayStack pop" );
        }
        return theArray[ topOfStack-- ];
    }

    /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     * @return the most recently inserted item in the stack.
     * @throws UnderflowException if the stack is empty.
     */
    public Object top( ) throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException( "example.ArrayStack top" );
        }
        return theArray[ topOfStack ];
    }

    /**
     * Internal method to extend theArray.
     */
    private void doubleArray( ) {
        Object [ ] newArray;

        newArray = new Object[ theArray.length * 2 ];
        for( int i = 0; i < theArray.length; i++ )
            newArray[ i ] = theArray[ i ];
        theArray = newArray;
    }

    /**
     * Make the stack logically empty.
     */
    public void makeEmpty( ) {
        topOfStack = -1;
    }
}