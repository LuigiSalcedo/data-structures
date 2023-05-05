package org.csalcedo.structures;

/**
 *
 * @author Luigi Salcedo
 * @param <T> Generic Value
 */
public interface Queue<T> extends List<T>
{
    public boolean offer(T value);
    public T poll();
    public T peek();
}
