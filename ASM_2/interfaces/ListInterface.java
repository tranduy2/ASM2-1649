package ASM_2.interfaces;

public interface ListInterface<T> {
    void add(T element);
    T get(int index);
    int size();
    void remove(int index);

    void set(int i, T book);
}
