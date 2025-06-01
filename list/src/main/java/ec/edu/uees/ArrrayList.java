package ec.edu.uees;
public class ArrrayList<E> implements List<E>{
    private E[] array;
    private int current;


    public ArrrayList() {
        array = (E[]) new Object[10];
        //current = 0;
    }

    @Override
    public boolean addFirst(E e) {
        if (e==null) return false;
        if (current == array.length) ensureCapacity(1);
        else{
        for (int i = current; i > 0; i--)
            array[i] = array[i-1];
        array[0] = e;
        current++;}
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e==null) return false;
        if (current == array.length) ensureCapacity(0);
        array[current] = e;
        current++;
        return true;
    }

    private void ensureCapacity( int offset) {
        E[] tmp = (E[]) new Object[(int)(current*1.5)];
        for (int i = 0; i < current; i++) 
            tmp[i+offset] = array[i];
        array = tmp;
    }

    @Override
    public boolean add(int index, E e) {
        if (e==null) return false;
        if (current == array.length) ensureCapacity(0);
        if (index < 0 || index > current) return false;
        for (int i = current; i > index; i--)
            array[i] = array[i-1];
        array[index] = e;
        current++;
        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) throw new UnsupportedOperationException("Esta lista esta vacia");
        E tmp = array[0];
        for (int i = 0; i < current-1; i++)
            array[i] = array[i+1];
        array[--current] = null;;
        return tmp;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) throw new UnsupportedOperationException("Esta lista esta vacia");
        current--;
        E tmp = array[current];
        array[current] = null;
        return tmp;
    }

    @Override
    public E remove(int index) {
        if (isEmpty()) throw new UnsupportedOperationException("Esta lista esta vacia");
        if (index < 0 || index >= current) return null;
        E tmp = array[index];
        for (int i = index; i < current-1; i++)
            array[i] = array[i+1];
        array[--current] = null;
        return tmp;
    }

    @Override
    public E get(int index) {
        if (isEmpty()) throw new UnsupportedOperationException("Esta lista esta vacia");
        if (index < 0 || index >= current) return null;
        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return current == 0;
    }

    @Override
    public int size() {
        return current;
    }

    @Override
    public boolean remove(E e) {
        int index = indexOf(e);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < current; i++)
            if (array[i].equals(e)) return i;
        return -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < current; i++){
            s.append(array[i]);
            if (i!=(current)-1) s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

}
