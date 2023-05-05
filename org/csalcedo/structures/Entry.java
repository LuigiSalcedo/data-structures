package org.csalcedo.structures;

/**
 * 
 * @author Luigi Salcedo
 * @param <K> Generic Key
 * @param <V> Generic Value
 */
public class Entry<K, V> 
{
    private K key;
    private V value;
    private Entry<K, V> next;
    
    Entry(K key, V value){
        this(key, value, null);
    }
    
    Entry(K key, V value, Entry<K, V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
    
    public K getKey()
    {
        return key;
    }
    
    public V getValue()
    {
        return value;
    }
    
    public Entry<K, V> getNext()
    {
        return next;
    }
    
    public void setValue(V value)
    {
        this.value = value;
    }
    
    public void setNext(Entry<K, V> next)
    {
        this.next = next;
    }   
    
    @Override
    public String toString()
    {
        return value.toString();
    }
}
