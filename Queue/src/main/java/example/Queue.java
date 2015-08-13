package example;

public interface Queue<T> {
    boolean isEmpty();

    Queue<T> enqueue(T ele);

    T dequeue();
}
