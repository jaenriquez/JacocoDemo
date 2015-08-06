package functional;

import example.ArrayStack;
import example.UnderflowException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class ArrayStackTest {

    private ArrayStack stack;

    @BeforeMethod
    public void init() {
        stack = new ArrayStack();
    }

    @Test
    public void Empty() {
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void PushOne() {
        stack.push("First Element");
        Assert.assertFalse(stack.isEmpty(), "After push, stack should not be empty");
    }

    @Test
    public void Pop() throws UnderflowException {
        stack.push("First Element");
        stack.pop();
        Assert.assertTrue(stack.isEmpty(), "After push-pop, stack should be empty");
    }

    @Test
    public void PushPopContentCheck() throws UnderflowException {
        int expected = 1234;
        stack.push(expected);
        int actual = (Integer)stack.pop();
        Assert.assertEquals (expected, actual);
    }

    @Test
    public void PushPopMultipleElements() throws UnderflowException {
        String pushed1 = "1";
        stack.push (pushed1);
        String pushed2 = "2";
        stack.push (pushed2);
        String pushed3 = "3";
        stack.push (pushed3);

        String popped = (String)stack.pop ();
        Assert.assertEquals (pushed3, popped);
        popped = (String)stack.pop ();
        Assert.assertEquals (pushed2, popped);
        popped = (String)stack.pop ();
        Assert.assertEquals (pushed1, popped);
    }

    @Test (expectedExceptions = UnderflowException.class)
    public void PopEmptyStack() throws UnderflowException {
        stack.pop();
    }


    @Test
    public void PopEmptyStack1() throws UnderflowException {
        try {
            stack.pop();
        }
        catch (Exception e) {
        }
    }


    @Test
    public void PushTop() throws UnderflowException {
        stack.push("42");
        stack.top();
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void PushTopContentCheckOneElement() throws UnderflowException {
        String pushed = "42";
        stack.push(pushed);
        String topped = (String)stack.top();
        Assert.assertEquals(pushed, topped);
    }

    @Test
    public void PushTopContentCheckMultiples() throws UnderflowException {
        String pushed3 = "3";
        stack.push(pushed3);
        String pushed4 = "4";
        stack.push(pushed4);
        String pushed5 = "5";
        stack.push(pushed5);

        String topped = (String)stack.top();
        Assert.assertEquals(pushed5, topped);
    }

    @Test
    public void PushTopNoStackStateChange() throws UnderflowException {
        String pushed = "44";
        stack.push(pushed);
        for (int i = 0; i < 10; i++) {
            String topped = (String)stack.top ();
            Assert.assertEquals(pushed, topped);
        }
    }

    @Test (expectedExceptions = UnderflowException.class)
    public void TopEmptyStack() throws UnderflowException {
        stack.top();
    }

    @Test
    public void PushNull() {
        stack.push(null);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void PushNullCheckPop() throws UnderflowException {
        stack.push(null);
        Assert.assertNull(stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void PushNullCheckTop() throws UnderflowException {
        stack.push(null);
        Assert.assertNull (stack.top());
        Assert.assertFalse(stack.isEmpty());
    }
}
