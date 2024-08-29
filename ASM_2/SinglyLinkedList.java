package ASM_2;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class SinglyLinkedList<T> implements LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private static class Node<T>{
        private T element;
        private Node<T> next;
        private Node(T value){
            this.element = value;
        }
    }
    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    @Override
    public void addFirst(T element){
        Node<T> newNode = new Node<>(element);
        if (head == null){
            tail = newNode;
        }else{
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    @Override
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        head = head.next;
        node.next = null;
        if (isEmpty()){
            head = tail = null;
        }
        size--;
        return node.element;
    }

    @Override
    public T removeLast() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node<T> current = head;
        T lastElement = tail.element;
        if (size == 1){
            tail = head = null;
            return lastElement;
        }
        while (current.next != tail){
            current = current.next;
        }
        current.next = null;
        tail= current;
        size--;
        return lastElement;
    }

    @Override
    public T getFirst() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return head.element;
    }

    @Override
    public T getLast() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return tail.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
    public boolean contains(T element){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node<T> current = head;
        while (current.element!=null){
            if (current.element == element){
                return true;
            }else current = current.next;
        }
        return false;
    }
    public T remove (T element){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (element == head.element){
            return removeFirst();
        }
        Node<T> current= head;
        while (current.next!= null){
            if (current.next.element == element){
                if (current.next == tail){
                    T lastElement = tail.element;
                    current.next = null;
                    tail= current;
                    size--;
                    return lastElement;
                }
                Node<T> tmp = current.next;
                current.next = current.next.next;
                tmp.next = null;
                size--;
                return tmp.element;
            }else{
                current = current.next;}
        }
        if (size == 0){
            head = tail = null;
        }
        return null;
    }
    @Override
    public String toString(){
        Node<T> node = head;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (node != null){
            result.append(node.element);
            if (node.next != null){
                result.append(", ");
            }
            node = node.next;
        }
        result.append("]");
        return result.toString();
    }
}

