package example;

public interface Stack {
    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty( );

    /**
     * Insert a new item into the stack.
     * @param x the item to insert.
     */
    void push( Object x );

    /**
     * Return and remove the most recently inserted item
     * from the stack.
     * @return the most recently inserted item in the stack.
     * @exception UnderflowException if the stack is empty.
     */
    Object pop( ) throws UnderflowException;

    /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     * @return the most recently inserted item in the stack.
     * @exception UnderflowException if the stack is empty.
     */
    Object top( ) throws UnderflowException;
}
