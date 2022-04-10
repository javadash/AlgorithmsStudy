package com.data.structures;


public interface Tree<T> {
	boolean add(T element); // Add Element
	void remove(T value); // remove value from table
	boolean contains(T element); // is this element in the tree
	boolean isEmpty(); // is the tree empty?
	int size(); // number of nodes
	T min(); // smallest element
	T max(); // largest element

//	Key select(int k) key of rank k
//	void deleteMin() delete smallest key
//	void deleteMax() delete largest key
//	int size(Key lo, Key hi) number of keys in [lo..hi]
//	Iterable<Key> keys(Key lo, Key hi) keys in [lo..hi], in sorted order
//	Iterable<Key> keys() all keys in the table, in sorted order

}
