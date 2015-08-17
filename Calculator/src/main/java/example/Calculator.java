package example;


/**
 * Created by jared.enriquez on 8/17/15.
 */
public interface Calculator {
  //add method
  double add(double x, double y);

  //subtract method
  double subtract(double x, double y);

  //mulpiply method
  double multiply(double x, double y);

  //Divide method
  double divide(double x, double y) throws IllegalArgumentException;
}
