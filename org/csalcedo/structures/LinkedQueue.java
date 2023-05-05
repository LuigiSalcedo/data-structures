package org.csalcedo.structures;

/**
 *
 * @author Luigi Salcedo
 * @param <T> Generic value
 */
public class LinkedQueue<T> extends LinkedList<T> implements Queue<T>
{
    public LinkedQueue()
    {
        super();
    }
    
    @Override
    public boolean offer(T value) 
    {
       return add(value);
    }

    @Override
    public T poll() 
    {
        T element = peek();
        removeFirst();
        return element;
    }

    @Override
    public T peek() 
    {
        return getFirst();
    }
    
}
