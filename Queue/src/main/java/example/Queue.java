package example;

public interface Queue<T> {
    Queue<T> enqueue(T ele);
    T dequeue();
}
