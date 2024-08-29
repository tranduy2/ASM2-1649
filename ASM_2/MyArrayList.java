package ASM_2;
import java.util.Arrays;
import java.util.Iterator;
public class MyArrayList<T> implements ArrayList<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;
    private int size;
    public MyArrayList(){
        elements= new Object[DEFAULT_CAPACITY];
    }
    @Override
    public boolean add(T element) {
        if(this.size == this.elements.length){
            this.elements = grow();
        }
        this.elements[this.size++]=element;
        return true;
    }
    @Override
    public boolean add(int index, T element) {
        if (index!=size) checkIndex(index);
        insert(index,element);
        return true;
    }
    private Object[] grow(){
        return Arrays.copyOf(this.elements,this.elements.length*2);
    }
    private Object[] shrink(){
        return Arrays.copyOf(this.elements, this.elements.length / 2);
    }
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) this.elements[index];
    }
    @Override
    public T set(int index, T element) {
        checkIndex(index);
        T oldElement = this.get(index);
        this.elements[index] = element;
        return oldElement;
    }
    @Override
    public T remove(int index) {
        checkIndex(index);
        T element = this.get(index);
        this.elements[index] = null;
        for (int i = index; i<  this.size -1; i++){
            this.elements[i] = this.elements[i+1];
        }
        this.size--;
        elements[size]= null;
        ensureCapacity();
        return element;
    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++){
            if (elements[i] == element){
                return i;
            }
        }
        return (-1);
    }
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++){
            if (elements[i] == element){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isEmpty() {
        if (this.size ==0){
            return true;
        }
        return false;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public T next() {
                return get(index++);
            }
        };
    }
    private void checkIndex(int index){
        if (index< 0 || index >= this.size){
            throw new IndexOutOfBoundsException(String.format("Index out of bounds: %d for size: %d", index, this.size));
        }
    }
    private void insert(int index, T element){
        if(this.size == this.elements.length){
            this.elements=grow();
        }
        T lastElement = this.get(this.size-1);
        for (int i = this.size -1; i> index; i--){
            this.elements[i] = this.elements[i-1];
        }
        this.elements[this.size]= lastElement;
        this.elements[index] = element;
        this.size++;
    }
    private void ensureCapacity(){
        if (this.size < this.elements.length / 3){
            this.elements = shrink();
        }
    }
    @Override
    public String toString(){
        return Arrays.toString(elements);
    }
}

