object Traits {
  package Inheritance

  trait Shape {
    def color : String;
  }

  abstract class Polygon {
    def area : Double;
  }

  class Rectangle(var width:Double, var height:Double)
    extends Polygon with Shape{
    override def area : Double = width * height;
    def color : String = "Red";
  }

  class Triangle(var width:Double, var height:Double)
    extends Polygon with Shape{
    override def area : Double = width * height/2;
    def color : String ="Blue";
  }


  object traits_demo {
    def printArea(p: Polygon): Unit = {
      println(p.area);
    }

    def main(args :Array[String]): Unit = {
      var rect = new Rectangle(55.0,20.0);
      printArea(rect);
      println(rect.color);

      var tri = new Triangle(55.0, 20.0);
      printArea(tri);
      println(tri.color);



    }

  }
}
