object functions_Demo {
  def main(args: Array[String]): Unit = {

    def add(x: Int, y: Int): Int = {
      return x + y
    }

    def subtract(x: Int, y: Int): Int = {
      x - y
    }

    def multiply(x: Int, y: Int): Int = x * y

    def divide(x: Int, y: Int) = x / y

    println(add(30, 20))
    println(subtract(30, 20))
    println(multiply(30, 20))
    println(divide(30, 20))

    object Math {
      def add(x: Int = 10, y: Int = 5): Int = {
        return x + y;
      }

      def square(x: Int) = x * x;
    }

    println(Math.add(20, 10)); //calling the defined obj
    println(Math square 2); //single argument
    println(Math.add());
    println(Math.add(12));

    //Another way to declare a function - anonymous function
    var sum = (x: Int, y: Int) => x + y;
    println(sum(50, 20));

    //Higher order functions - take fn as arg and return fn
    def math(x: Double, y: Double, f: (Double, Double) => Double): Double = f(x, y);
    val result = math(50, 20, (x, y) => x + y)
    println(result);

    def math1(x: Double, y: Double, z: Double, f: (Double, Double) => Double): Double = f(f(x, y), z);
    val result1 = math1(50, 20, 10, (x, y) => x + y);
    val result2 = math1(50, 20, 10, (x, y) => x max y);
    val result3 = math1(50, 20, 10, _ min _); //_ is called wild card
    println(result1);
    println(result2);
    println(result3);

    //partially applied functions
    val sum1 =(a: Int,b : Int, c: Int) => a+b+c;
    val f = sum1(10, 20, _ :Int);
    println(f(20));

    //closures
    var number = 10;
    val addn = (x : Int) => {
      number = x + number;
      number;
    }
    number = 100;
    println(addn(20));
    println(number);

    //Currying
    def sumx(x:Int, y:Int) = x + y;
    def sum2(x:Int) = (y:Int) => x+y; // sum2 and sum3 curried fn
    def sum3(x:Int)(y:Int) = x+y
    println(sumx(10,20));

    println(sum2(10)(20));

    println(sum3(20)(90));

    val sum50 = sum3(50)_; //partial application
    println(sum50(100));
  }
}