package org.example;

import java.util.Arrays;

public class MyArrayList<E>{
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private E[] array;
    private int pointer = 0;

    public MyArrayList() {
        this.array = (E[]) new Object[INIT_SIZE];
    }

    public void add(E element) {
        if (pointer >= array.length) {
            growArray();
        }
        array[pointer] = element;
        pointer++;
    }

    public E remove(int index) {
        checkBounds(index);
        E element = array[index];
        System.arraycopy(array, index + 1, array, index, pointer - index - 1);
        pointer--;
        array[pointer] = null;
        return element;
    }

    public boolean remove(E removedElement) {
        boolean result = false;

        if (removedElement == null) {
            for (int i = 0; i < pointer; i++) {
                if (array[i] == null) {
                    remove(i);
                    result = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < pointer; i++) {
                if (removedElement.equals(array[i])) {
                    remove(i);
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    public E set(int index, E element) {
        checkBounds(index);
        E oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    public E get(int index) {
        checkBounds(index);
        return array[index];
    }

    public void clear() {
        Arrays.fill(array, null);
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    private void growArray() {
        long newCapacity = array.length * CUT_RATE;

        if (newCapacity > Integer.MAX_VALUE) {
            newCapacity = Integer.MAX_VALUE;
        }

        E[] newArray = (E[]) new Object[(int) newCapacity];
        System.arraycopy(this.array, 0, newArray, 0, array.length);
        this.array = newArray;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= pointer) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d",
                    index, pointer));
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, pointer));
    }
}
