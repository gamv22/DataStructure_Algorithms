package ec.edu.uees;

public interface List <E> {
    boolean addFirst (E e);
    boolean addLast(E e);
    boolean add(int index, E e);
    int indexOf(E e);
    E removeFirst();
    E removeLast();
    E remove(int index);
    E get(int index);
    boolean isEmpty();
    int size();
    boolean remove(E e);
}
