package ASM_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements InterfaceStack<T> {
    private Node<T> top; // Top of the stack
    private int size; // Track the size of stack

    /**
     * METHODS
     */
    // Constructor
    public Stack( ) {
        top = null;
        size = 0;
    }
    // Push an element onto the stack
    @Override
    public void push( T element ) {
        Node<T> newNode = new Node<>( element );
        if ( isEmpty( ) ) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }
    // Pop an element from the stack
    @Override
    public T pop( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        T element = top.element;
        Node<T> next = top.next;
        top.next = null;
        top = next;
        size--;
        return element;
    }
    // Peek at the top element without removing it
    @Override
    public T peek( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        return top.element;
    }
    @Override
    public int size( ) {
        return size;
    }
    // Check if the stack is empty
    @Override
    public boolean isEmpty( ) {
        return top == null; // or size == 0
    }
    @Override
    public Iterator<T> iterator( ) {
        return new Iterator<T>( ) {
            Node<T> current = top;
            @Override
            public boolean hasNext( ) {
                return current != null;
            }

            @Override
            public T next( ) {
                if ( !hasNext( ) ) {
                    throw new NoSuchElementException( );
                }
                T element = current.element;
                current = current.next;
                return element;
            }
        };
    }
    @Override
    public String toString( ) {
        StringBuilder result = new StringBuilder( "[" );
        Node<T> current = top;

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