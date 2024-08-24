package ASM_2.interfaces;

public interface QueueInterface<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    int size();
}