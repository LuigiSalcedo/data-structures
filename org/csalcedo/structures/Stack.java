package org.csalcedo.structures;
/**
 *
 * @author Luigi Salcedo
 * @param <T> Generic value
 */
public interface Stack<T> extends List<T>
{
    public boolean push(T value);
    public T pop();
    public T peek();
}
