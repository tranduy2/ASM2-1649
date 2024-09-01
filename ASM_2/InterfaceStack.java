package ASM_2;

public interface InterfaceStack<T> extends Iterable<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
