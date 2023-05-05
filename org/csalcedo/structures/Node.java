package org.csalcedo.structures;

/**
 *
 * @author Luigi Salcedo
 */
class Node<T>
{
    // Atributos
    private T value;
    private Node<T> next;
    
    // Constructores
    public Node()
    {
        
    }
    
    public Node(T value)
    {
        this.value = value;
    }
    
    public Node(T value, Node<T> next)
    {
        this.value = value;
        this.next = next;
    }
    
    // Setters
    public void setValue(T value) 
    {
        this.value = value;
    }

    public void setNext(Node<T> next) 
    {
        this.next = next;
    }
    
    // Getters
    public T getValue() 
    {
        return value;
    }

    public Node<T> getNext() 
    {
        return next;
    }
}

