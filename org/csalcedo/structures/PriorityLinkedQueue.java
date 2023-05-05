package org.csalcedo.structures;

import java.util.function.BiFunction;

/**
 *
 * @author Luigi Salcedo
 * @param <T>
 */
public class PriorityLinkedQueue<T> extends LinkedQueue<T>
{
    private BiFunction<T, T, Integer> comparator;
    
    public PriorityLinkedQueue(BiFunction<T, T, Integer> comparator)
    {
        this.comparator = comparator;
    }
    
    @Override
    public boolean offer(T value)
    {
        // Agregar de primero
        if(size == 0) return super.addFirst(value);
        
        // Si existe primero
        if(comparator.apply(value, getFirst()) <= 0) return super.addFirst(value);
        
        // Agregar ultimo
        if(comparator.apply(value, getLast()) >= 0) return super.addLast(value);
        
        // De lo contrario comenzamos a buscar
        Node<T> piv = first;
        
        while(comparator.apply(value, piv.getNext().getValue()) > 0)
        {
            piv = piv.getNext();
        }
        
        Node<T> newNode = new Node(value);
        newNode.setNext(piv.getNext());
        piv.setNext(newNode);
        size++;
        return true;
    }
    
    @Override
    public boolean add(T value)
    {
        return offer(value);
    }
}
