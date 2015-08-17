package functional;

import example.CalculatorImp;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorIT {
  CalculatorImp calc;
  double d0 = 0.0, d1 = 1.1, d2 = 2.2, d3 = 3.3, d4 = 4.4, d5 = 5.5, result;

  @BeforeTest
  public void setUp() throws Exception {
    calc = new CalculatorImp();
  }

  @AfterMethod
  public void tearDown()
      throws Exception {

  }

  @Test
  public void testAdd(){

    result = calc.add(d1,d2);

    Assert.assertEquals(d1 + d2, result);

  }

  @Test
  public void testSubtract(){

    result = calc.subtract(d2, d4);

    Assert.assertEquals(result, d2 - d4, "values are not equal");

  }

  @Test
  public void testMultiply(){

    result = calc.multiply(d0, d5);

    Assert.assertEquals(result, d0 * d5, "values are not equal");

  }

  @Test
  public void testDivide() throws Exception {

    result = calc.divide(d1, d2);

    Assert.assertEquals(result, d2 / d4, "values are not equal");

  }

  @Test (expectedExceptions = IllegalArgumentException.class)
  public void testDivideByZero() throws Exception {

    result = calc.divide(d5, d0);

  }
}