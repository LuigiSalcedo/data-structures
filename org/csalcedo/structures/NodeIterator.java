package org.csalcedo.structures;

import java.util.Iterator;

/**
 *
 * @author Luigi Salcedo
 */
class NodeIterator<T> implements Iterator<T> 
{
    private Node<T> first;
    private Node<T> actual;
    
    NodeIterator(Node<T> first)
    {
        this.first = first;
        actual = first;
    }
    
    public void setFirst(Node<T> newFirst)
    {
        first = newFirst;
        actual = first;
    }
    
    @Override
    public boolean hasNext() 
    {
        if(actual == null)
        {
            actual = first;
            return false;
        }
        return true;
    }

    @Override
    public T next() 
    {
        Node<T> piv = actual;
        actual = actual.getNext();
        return piv.getValue();
    }
    
}
