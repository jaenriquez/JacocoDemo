package functional;

import example.QueueArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class QueueArrayTest {

    private QueueArray queue;

    @BeforeMethod
    public void init() {
        queue = new QueueArray();
    }

    @Test
    public void Empty() {
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void EnqueueOne() {
        queue.enqueue("a");
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void DequeueOne() {
        queue.enqueue("a");
        queue.dequeue();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void EnqueueDequeueCheck() {
        int expected = 1234;
        queue.enqueue(expected);
        int actual = (Integer) queue.dequeue();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void EnqueueDequeueMulti() {
        String q1 = "a";
        String q2 = "b";
        String q3 = "c";
        queue.enqueue(q1);
        queue.enqueue(q2);
        queue.enqueue(q3);

        String dequeued = (String) queue.dequeue();
        Assert.assertEquals(dequeued, q1);
        dequeued = (String) queue.dequeue();
        Assert.assertEquals(dequeued, q2);
        dequeued = (String) queue.dequeue();
        Assert.assertEquals(dequeued, q3);
    }

    @Test  (expectedExceptions = NoSuchElementException.class)
    public void DequeueEmpty() {
        queue.dequeue();
    }

    @Test
    public void DequeueEmpty1() {
        try {
            queue.dequeue();
        }
        catch (Exception e) {
        }
    }

    @Test
    public void EnqueueDequeueInt() {
        QueueArray<Integer> intQueue = new QueueArray<Integer>();
        Integer q1 = 1;
        Integer q2 = 2;
        Integer q3 = 3;
        intQueue.enqueue(q1);
        intQueue.enqueue(q2);
        intQueue.enqueue(q3);

        Integer dequeued = intQueue.dequeue();
        Assert.assertEquals(dequeued, q1);
        dequeued = intQueue.dequeue();
        Assert.assertEquals(dequeued, q2);
        dequeued = intQueue.dequeue();
        Assert.assertEquals(dequeued, q3);
    }

    @Test
    public void ToStringTest() {
        QueueArray<String> strQueue = new QueueArray<String>();
        strQueue.enqueue("a");
        strQueue.enqueue("b");
        strQueue.enqueue("c");

        String out = strQueue.toString();
        Assert.assertEquals(out, "[a, b, c, null]");
    }
}
