package ASM_2.util;

import ASM_2.interfaces.QueueInterface;

public class MyQueue<T> implements QueueInterface<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    @Override
    public void enqueue(T item) {
        list.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.get(0);
        list.remove(0);
        return item;
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }
}