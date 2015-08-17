package example;

public class CalculatorImp implements Calculator {

    public CalculatorImp(){

    }

    //add method
    @Override
    public double add(double x, double y){
      return x + y;
    }

    //subtract method
    @Override
    public double subtract(double x, double y){
      return x - y;
    }

    //mulpiply method
    @Override
    public double multiply(double x, double y){
      return x * y;
    }

    //Divide method
    @Override
    public double divide(double x, double y) throws IllegalArgumentException{
      double solution;

      if (0 == y){
        throw new IllegalArgumentException("cannot divide by zero");
      }

      solution = x / y;

      return solution;
    }

}

