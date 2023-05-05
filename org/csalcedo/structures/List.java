package org.csalcedo.structures;

/**
 *
 * @author Luigi Salcedo
 * @param <T> Generic value
 */
public interface List<T> 
{
    public int size();
    public boolean isEmpty();
    public boolean add(T value);
    public boolean remove(int index);
    public T get(int index);
    public int indexOf(T value);
}
