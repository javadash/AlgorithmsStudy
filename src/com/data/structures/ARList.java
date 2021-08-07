package com.data.structures;



import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * A dynamic array, growable array, resizable array, dynamic table, or array
 * list is a random access, variable-size list data structure that allows
 * elements to be added or removed.
 * 
 * @author Johnson Olayiwola <johnson.olayiwola@gmail.com>
 * size(), capacity(), isEmpty(), at(index) -  get(index), push(item) - add, insert(index, item)
 * prepend(), pop(), delete(index) - remove(index), remove(item) - in multiple places
 * find(item), grow() - resize
 * 
 * Time
	O(1) to add/remove at end (amortized for allocations for more space), index, or update
	O(n) to insert/remove elsewhere
	
 */
public class ARList<T> {
	private final int DEFAULT_CAPACITY = 256;
	private T[] data;
	private int size;
	private int capacity;
	
	public ARList() {
		this.capacity = DEFAULT_CAPACITY;
		data = (T[])new Object[capacity];
		size = 0;
	}
	
	public ARList(final int capacity) {
		data = (T[]) new Object [capacity];
		size = 0;
	}
	/* Add item to the list*/
	
	public boolean add(T value) {
		return add(size, value);
	}
	
	/*Add value at a particular index*/
	public boolean add(int index, T value) {
		if(size >= data.length) grow();
		if(index == size) data[size] = value;
		else {
			// Shift the array down one spot and add the value in between
			System.arraycopy(data, index, data, index+1, size-index);
		}
		size++;
		return true;
	}
	
	/*Remove value from the list*/
	public boolean remove (T value) {
		for(int i = 0; i < size; i++) {
			T obj = data[i];
			if(obj.equals(value)) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	/*Remove value at index and returns that value */
	public T remove(int index) {
		if (index < 0 || index >= size) return null;
		T t = data[index];
		if(index != size) {
			System.arraycopy(data, index+1, data, index, size-index);
		}
		data[size] = null;
		int shrinkSize = data.length >> 1;
		if(shrinkSize >= DEFAULT_CAPACITY && size < shrinkSize) shrink();
		return t;
	}
	
	public T removeTail() {
		T removed = data[--size];
		data[size] = null;
		int shrinkSize = data.length >> 1;
		if(shrinkSize >= DEFAULT_CAPACITY && size < shrinkSize) shrink();
		return removed;
	}
	
	/*Grow the array by 50%*/
	private void grow() {
		int growSize = size + (size << 1);
		data = Arrays.copyOf(data, growSize);
	}
	
	/*Shrink the array by 50%*/
	private void shrink() {
		int shrinkSize = data.length >> 1;
		data = Arrays.copyOf(data, shrinkSize);
	}
	
	/**
     * Set value at index.
     * 
     * @param index of value to set.
     * @param value to set.
     * @return value previously at index.
     */
    public T set(int index, T value) {
        if (index<0 || index>=size) return null;
        T t = data[index];
        data[index] = value;
        return t;
    }
    
    /**
     * Get value at index.
     * 
     * @param index of value to get.
     * @param value to set.
     */
    public T get(int index) {
        if (index<0 || index>=size) return null;
        return data[index];
    }
    
    public void clear() {
    	size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            T obj = data[i];
            if (obj.equals(value)) return true;
        }
        return false;
    }
    
    public boolean isEmpty() {
		return size == 0;
	}
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(data[i]).append(", ");
        }
        return builder.toString();
    }

}

