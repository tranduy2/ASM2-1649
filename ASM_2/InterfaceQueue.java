package ASM_2;

public interface InterfaceQueue<T> extends Iterable<T>  {
    void offer(T element);
    T poll();
    T peek();
    int size( );
    boolean isEmpty( );
}

