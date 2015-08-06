package functional;

import example.QueueArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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



}
