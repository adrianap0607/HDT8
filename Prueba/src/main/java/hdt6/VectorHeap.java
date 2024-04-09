package hdt6;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Vector;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * Implementación de una cola de prioridad utilizando un Vector como base.
 * @param <E> Tipo de elementos almacenados en la cola de prioridad.
 */
public class VectorHeap<E extends Comparable<E>> implements Queue<E> {
    protected Vector<E> data; // Vector para almacenar los elementos de la cola de prioridad

    /**
     * Constructor que crea un VectorHeap vacío.
     */
    public VectorHeap() {
        data = new Vector<>();
    }

    /**
     * Constructor que crea un VectorHeap a partir de una colección dada.
     * @param v Colección de elementos para inicializar la cola de prioridad.
     */
    public VectorHeap(Vector<E> v) {
        int i;
        data = new Vector<>(v.size());
        for (i = 0; i < v.size(); i++) {
            add(v.get(i));
        }
    }

    /**
     * Calcula el índice del padre de un nodo dado.
     * @param i Índice del nodo hijo.
     * @return Índice del padre del nodo.
     */
    protected static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Calcula el índice del hijo izquierdo de un nodo dado.
     * @param i Índice del nodo padre.
     * @return Índice del hijo izquierdo del nodo.
     */
    protected static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Calcula el índice del hijo derecho de un nodo dado.
     * @param i Índice del nodo padre.
     * @return Índice del hijo derecho del nodo.
     */
    protected static int right(int i) {
        return (2 * i + 1) + 1;
    }

    /**
     * Realiza la operación de percolación hacia arriba para mantener la propiedad de heap.
     * @param leaf Índice del nodo que necesita percolar hacia arriba.
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     * Realiza la operación de hundimiento desde la raíz para mantener la propiedad de heap.
     * @param root Índice del nodo raíz que necesita hundirse.
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        if (heapSize == 0) {
            return; // No hay elementos en el heap
        }
        
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Agrega un elemento a la cola de prioridad.
     * @param e Elemento a agregar.
     * @return Siempre devuelve true.
     */
    @Override
    public boolean add(E e) {
        return offer(e);
    }

    /**
     * Ofrece un elemento para agregarlo a la cola de prioridad.
     * @param e Elemento a agregar.
     * @return Siempre devuelve true.
     */
    @Override
    public boolean offer(E e) {
        data.add(e);
        percolateUp(data.size() - 1);
        return true;
    }

    /**
     * Elimina y devuelve el elemento de mayor prioridad de la cola de prioridad.
     * @return Elemento de mayor prioridad.
     * @throws NoSuchElementException Si la cola de prioridad está vacía.
     */
    @Override
    public E remove() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        return poll();
    }

    /**
     * Elimina y devuelve el elemento de mayor prioridad de la cola de prioridad, o null si está vacía.
     * @return Elemento de mayor prioridad, o null si la cola de prioridad está vacía.
     */
    @Override
    public E poll() {
        if (isEmpty())
            return null;
        E root = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        pushDownRoot(0);
        return root;
    }

    /**
     * Devuelve el elemento de mayor prioridad de la cola de prioridad sin eliminarlo.
     * @return Elemento de mayor prioridad.
     * @throws NoSuchElementException Si la cola de prioridad está vacía.
     */
    @Override
    public E element() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        return peek();
    }

    /**
     * Devuelve el elemento de mayor prioridad de la cola de prioridad sin eliminarlo, o null si está vacía.
     * @return Elemento de mayor prioridad, o null si la cola de prioridad está vacía.
     */
    @Override
    public E peek() {
        if (isEmpty())
            return null;
        return data.firstElement();
    }

    /**
     * Devuelve la cantidad de elementos en la cola de prioridad.
     * @return La cantidad de elementos en la cola de prioridad.
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     * @return true si la cola de prioridad está vacía, false de lo contrario.
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Elimina todos los elementos de la cola de prioridad.
     */
    @Override
    public void clear() {
        data.clear();
    }

    // Los siguientes métodos no son necesarios para el funcionamiento básico de una Queue

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return data.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return data.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return data.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return data.retainAll(c);
    }

    @Override
    public Spliterator<E> spliterator() {
        return data.spliterator();
    }

    @Override
    public Stream<E> stream() {
        return data.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return data.parallelStream();
    }
}

