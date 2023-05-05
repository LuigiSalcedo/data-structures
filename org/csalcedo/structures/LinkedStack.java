package org.csalcedo.structures;

/**
 *
 * @author Luigi Salcedo
 * @param <T> Generic value
 */
public class LinkedStack<T> extends LinkedList<T> implements Stack<T>
{
    public LinkedStack()
    {
        super();
    }
    
    @Override
    public boolean push(T value) 
    {
        return addFirst(value);
    }

    @Override
    public T pop() 
    {
        T value = peek();
        removeFirst();
        return value;
    }

    @Override
    public T peek() 
    {
        return getFirst();
    }
    
}
