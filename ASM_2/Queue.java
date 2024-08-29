package ASM_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements InterfaceQueue<T> {
    private Node<T> head;
    private int size;
    public Queue( ) {
        head = null;
    }
    @Override
    public void offer( T data ) {
        Node<T> newNode = new Node<>( data );
        if ( isEmpty( ) ) {
            head = newNode;
        } else {
            Node<T> current = head;
            while ( current.next != null ) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    @Override
    public T poll( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        T data = head.element;
        if ( size == 1 ) {
            head = null;
        } else {
            Node<T> next = head.next;
            head.next = null;
            head = next;
        }
        size--;
        return data;
    }

    @Override
    public T peek( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        return head.element;
    }
    @Override
    public int size( ) {
        return size;
    }
    @Override
    public boolean isEmpty( ) {
        return head == null; // or size == 0
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T element = current.element;
                current = current.next;
                return element;
            }
        };
    }
    // toString method to represent the queue as a string
    @Override
    public String toString( ) {
        StringBuilder result = new StringBuilder( "[" );
        Node<T> current = head;

        while ( current != null ) {
            result.append( current.element );
            if ( current.next != null ) {
                result.append( ", " );
            }
            current = current.next;
        }
        result.append( "]" );
        return result.toString( );
    }
    private static class Node<T> {
        private T element;
        private Node<T> next;
        public Node( T element ) {
            this.element = element;
        }
    }
}

