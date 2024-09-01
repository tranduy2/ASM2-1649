package ASM_2;

public interface ArrayList<T> extends Iterable<T> {
    boolean add(T element);
    boolean add(int index, T element);
    T get(int index);
    T set(int index, T element);
    T remove(int index);
    int size();
    int indexOf(T element);
    boolean contains(T element);
    boolean isEmpty();
}


