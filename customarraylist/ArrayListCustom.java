package customarraylist;

import java.util.Arrays;

public class ArrayListCustom<E> {

    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elementData[] = {};

    public ArrayListCustom() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    public static void main(String[] args) {
        ArrayListCustom<String> f = new ArrayListCustom<>();
        f.add("DD");
    }

    public boolean add(E e) {
        if (size == elementData.length) {
            ensureCapacity();
        }

        elementData[size++] = e;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error in getting the element at index :" + index);
        }
        return (E) elementData[index];
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error in getting the element at index :" + index);
        }
        E removedElement = (E) elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        return removedElement;
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length + 2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }

    /*
     * private void increaseSizeAndReallocate() {
     * this.size = this.size+SIZE_FACTOR;
     * Object newData[] = new Object[this.size];
     * for(int i=0; i<data.length; i++) {
     * newData[i] = data[i];
     * }
     * this.data = newData;
     * }
     */


}
