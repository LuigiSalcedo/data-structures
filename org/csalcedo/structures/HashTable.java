package org.csalcedo.structures;

import java.util.function.Function;

/**
 *
 * @author Luigi Salcedo
 * @param <K> Generic Key
 * @param <V> Generic Value
 */
public class HashTable<K, V>
{
    private float loadFactor;
    private int size;
    private int maxSize;
    private LinkedList<Entry<K, V>> [] buckets;
    private Function<Integer, Integer> hashFunction;
    private int collisions;
    
    public HashTable(int initSize, float loadFactor, Function<Integer, Integer> hashFunction)
    {
        if(initSize <= 0)
        {
            throw new IllegalArgumentException("init size " + initSize + " is not valid.");
        }
        buckets = new LinkedList[initSize];
        this.loadFactor = loadFactor;
        size = 0;
        maxSize = (int)(initSize + (initSize * loadFactor));
        
        if(hashFunction != null)
        {
            this.hashFunction = hashFunction;
        }
        else
        {
            this.hashFunction = x -> x;
        }
        collisions = 0;
    }
    
    public HashTable(int initSize, float loadFactor)
    {
        this(initSize, loadFactor, null);
    }
    
    public HashTable(int initSize)
    {
        this(initSize, 0.75f, null);
    }
    
    
    public HashTable()
    {
        this(13, 0.75f, null);
    }
    
    public HashTable(Function<Integer, Integer> hashFunction)
    {
        this(13, 0.75f, hashFunction);
    }
    
    public boolean put(K key, V value)
    {
        if(size == maxSize)
        {
            reHashAll();
        }
        Entry<K, V> newBucket = new Entry(key, value);
        
        int hash = hash(key.hashCode()) % buckets.length;
        
        if(buckets[hash] == null)
        {
            buckets[hash] = new LinkedList();
            buckets[hash].add(newBucket);
            size++;
            return true;
        }
        
        for(Entry<K, V> piv : buckets[hash])
        {
            if(piv.getKey().equals(key))
            {
                piv.setValue(value);
                return true;
            }
        }
        
        buckets[hash].add(newBucket);
        size++;
        collisions++;
        return true;
    }
    
    public V get(K key)
    {
        int hash = hash(key.hashCode()) % buckets.length;
        LinkedList<Entry<K, V>> bucket = buckets[hash];
        System.out.println("Recibimos: " + key);
        
        if(buckets[hash] == null) return null;
        
        for(Entry<K, V> entry : bucket)
        {
            System.out.println("Buscando: " + entry.getValue());
            if(entry.getKey().equals(key))
            {
                System.out.println(entry.getValue());
                return entry.getValue();
            }
        }
        
        return null;
    }
    
    private void reHashAll()
    {
        HashTable<K, V> newBuckets = new HashTable(buckets.length * 2, loadFactor, hashFunction);
        
        for(LinkedList<Entry<K, V>> bucket : buckets)
        {
            if(bucket == null) continue;
            
            while(!bucket.isEmpty())
            {
                newBuckets.put(bucket.getFirst().getKey(), bucket.getFirst().getValue());
                bucket.removeFirst();
            }
            
        }
        
        buckets = newBuckets.getBuckets();
        maxSize = (int)(size + (size * loadFactor)); 
        collisions = newBuckets.collisions;
    }
    
    public V remove(K key)
    {
        int hash = hash(key.hashCode()) % buckets.length;
        
        if(buckets[hash] == null) return null;
        
        V value = null;
        
        int i = 0;
        for(Entry<K, V> entry : buckets[hash])
        {
            if(entry.getKey().equals(key))
            {
                value = entry.getValue();
                buckets[hash].remove(i);
                collisions--;
                break;
            }
            i++;
        }
        
        return value;
    }
    
    public LinkedList<Entry<K, V>> [] getBuckets()
    {
        return buckets;
    }
    
    public int size()
    {
        return size;
    }
    
    public int collisions()
    {
        return collisions;
    }
    
    /**
     * 
     * @param hashCode hashCode value from key.hashCode();
     * @return hashCode with the function applyed.
     */
    public int hash(int hashCode)
    {
        return hashFunction.apply(hashCode);
    }
    
    public void showDataDistribution()
    {
        for(LinkedList<Entry<K, V>> bucket : buckets)
        {
            System.out.println(bucket);
        }
    }
}
