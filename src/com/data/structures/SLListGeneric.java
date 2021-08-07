package com.data.structures;



import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The {@code SLList} class represents a Single Linked List of generic items.
 *  It supports the usual <em>addFirst</em> and <em>addLast</em>
 *  operations, along with methods for peeking at the first item,
 *  testing if the Linked List is empty, and iterating through
 *  the items in FIFO order.
 *  <p>
 *  This implementation uses a singly linked list with a static nested class for linked-list nodes. 

 *  The <em>addFirst</em>, <em>addLast</em>, <em>getFirst</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *
 *  @param <Item> the generic type of an item in this queue
 */
public class SLListGeneric<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queue.
     */
    public SLListGeneric() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Returns true if this list is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the first item in the list.
     *
     * @return the item in front of the list
     * @throws NoSuchElementException if this list is empty
     */
    public Item getFirst() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    
    
    /**
     * Adds the item to the front of the list.
     *
     * @param  item the item to add
     */
    public void addFirst(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    


    /**
     * Adds item to the end of the list
     *
     * @param  item the item to add
     */
    public void addLast(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 

    /**
     * Returns an iterator that iterates over the items in this list in FIFO order.
     *
     * @return an iterator that iterates over the items in this list in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


    /**
     * Unit tests the {@code Queue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SLListGeneric<Integer> L = new SLListGeneric<Integer>();
        L.addLast(15);
		L.addLast(20);
		L.addLast(20);
		L.addLast(20);
		L.addLast(20);
		L.addLast(20);
		L.addLast(20);
		L.addLast(60);
        
        System.out.println("(" + L.size() + " left on queue)");
        System.out.println(L.getFirst());
    }
}
