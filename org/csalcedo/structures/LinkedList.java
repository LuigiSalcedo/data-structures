package org.csalcedo.structures;

import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Luigi Salcedo
 * @param <T> parámetro en T
 */

public class LinkedList<T> implements List<T>, Iterable<T>
{
    // Atributos
    protected Node<T> first;
    protected Node<T> last;
    protected int size;
    
    // Constructor
    public LinkedList()
    {
        size = 0;
    }
    
    // Métodos
    @Override
    public boolean add(T value)
    {
        if(first == null)
        {
            return addFirst(value);
        }
        
        return addLast(value);
    }
    
   public boolean addFirst(T value)
   {
       if(first == null)
       {
           first = new Node(value);
           last = first;
       }
       else
       {
           Node<T> newElement = new Node(value);
           newElement.setNext(first);
           first = newElement;
       }
       size++;
       return true;
   }
   
   public boolean addLast(T value)
   {
       if(first == null) return addFirst(value);
       
       Node<T> newElement = new Node(value);
       
       last.setNext(newElement);
       last = newElement;
       size++;
       return true;
   }
   
   public boolean insert(int index, T value)
   {
       if(index == size) return addLast(value);
       if(index == 0) return addFirst(value);
       
       return addAfter(get(index-1), value);
   }
   
   public boolean addAfter(T valueInList, T newValue)
   {
       Node<T> piv = first;
       while(!piv.getValue().equals(newValue))
       {
           piv = piv.getNext();
           if(piv == null)
           {
               return false;
           }
       }
       
       Node<T> newNode = new Node(newValue);
       
       newNode.setNext(piv.getNext());
       piv.setNext(newNode);
       
       size++;
       return true;
   }
   
   public T getFirst()
   {
       if(first == null) return null;
       return first.getValue();
   }
   
   public T getLast()
   {
       if(last == null) return null;
       return last.getValue();
   }
   
   @Override
   public boolean remove(int index)
   {
       if(index == 0) return removeFirst();
       if(index == size-1) return removeLast();
       
       Node<T> piv = getNode(index-1);
       
       piv.setNext(piv.getNext().getNext());
       size--;
       return true;
   }
   
   public boolean removeFirst()
   {
       if(first == null) return false;
       first = first.getNext();
       size--;
       if(size == 0) last = first;
       return true;
   }
   
   
   public boolean removeLast()
   {
       if(last == null) return false;
       last = getNode(size-2);
       size--;
       if(size == 0) last = first;
       return true;
   }
   
   @Override
   public T get(int index)
   {
       return getNode(index).getValue();
   }
   
   private Node<T> getNode(int index)
   {
       Node<T> piv = first;
       for(int i = 0; i < index; i++)
       {
           piv = piv.getNext();
       }
       return piv;
   }
   
   @Override
   public int indexOf(T value)
   {
       Node<T> piv = first;
       int i = 0;
       while(piv != null)
       {
           if(piv.getValue().equals(value) || Objects.equals(value, piv.getValue())) return i;
           piv = piv.getNext();
           i++;
       }
       return -1;
   }
   
   @Override
   public int size()
   {
       return size;
   }
   
   @Override
   public boolean isEmpty()
   {
       return size == 0;
   }
   
   @Override
   public String toString()
   {
       if(size == 0) return "null";
       StringBuilder sb = new StringBuilder();
       Node<T> piv = first;
       while(piv != last)
       {
           sb.append(piv.getValue().toString()).append(" -> ");
           piv = piv.getNext();
       }
       sb.append(piv.getValue().toString());
       
       return sb.toString();
   }       

    @Override
    public Iterator<T> iterator() 
    {
        return new NodeIterator(first);
    }
}
