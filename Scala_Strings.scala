import Array._
object Strings {
  def main(args : Array[String]): Unit = {
    val num1 =24;
    val num2 = 12.5;
    val string1 : String = "Hello";
    val string2 : String = " World";
    println(string1.length());
    println(string1.concat(string2));

    //format
    val result = printf("(%d -- %f -- %s)", num1, num2,string1);
    println(result);
    println("(%d -- %f -- %s)".format(num1,num2,string1))


    //Arrays
    val myarray: Array[Int] = new Array[Int](5);

    // another way of declaring array
    val myarray1 = new Array[Int](5)
    val myarray2 = Array(1,2,3,4);
    myarray(0)=10;
    myarray(1)=20;
    myarray(2)=30;
    myarray(3)=40;
    myarray(4)=50;
    for (x<- myarray) {
      println(x);
    }
    for (i <-0 to (myarray.length - 1)) {
      println(myarray(i));
    }
    for (x <- myarray1) {
      println(x); //prints default value all 0
    }

    val conc = concat(myarray,myarray2)
    println("Concatenated arrays")
    for (x <- conc) {
      println(x);
    }

    //Lists
    val mylist: List[Int] = List(1,2,4,7,8,3,6);
    val names : List[String] = List("Raj","Adam","Eva")
    println(mylist);
    println(names);
    println(8::mylist); //prepends 8 to the list
    println(Nil); //prints an empty list
    println(1 :: 3:: 6:: Nil);
    println(names.tail);
    println(mylist.head);
    println(mylist.tail);
    println(names.isEmpty);

    //Iterating over the list
    mylist.foreach(println);

    //calculate the sum of the elements in the list
    var sum : Int =0;
    mylist.foreach(sum += _);
    println(sum);

    for(name <-names){
      println(name);
    }

    println(names(1));

    //Sets
    //immutable set
    val myset : Set[Int] = Set(2,4,5,6,7,8,9);
    val myset2 : Set[Int] = Set(8,5,4,3,2,7,8);
    //mutable set
    var myset1 = scala.collection.mutable.Set(2,4,5,6,78,7);
    println(myset);
    println(myset1);

    //concatenation of sets
    println( myset ++ myset2);
    println(myset.++(myset2));

    //intersect --  returns the common items in the two sets
    println(myset.&(myset2));
    println(myset.intersect(myset2));

    //iteration
    myset.foreach(println);
    for(i <- myset){
      println(i);
    }

    //Maps
    val mymap : Map[Int,String] = Map(10 -> "Tom", 11 -> "max", 12 -> "Eva");
    println(mymap);
    println("Key 11 " + mymap(11));
    println(mymap.keys);
    println(mymap.values);

    //iteration
    mymap.keys.foreach{
      key =>
        println("key " +key);
        println("Value "+mymap(key));
    }
    val mymap2 : Map[Int,String] = Map(101 -> "Tom", 102 -> "max", 103 -> "Eva");
    println(mymap.contains(100));

    //concatenation
    println(mymap++mymap2);


    //tuples
    val mytuple = (1,2,"Hi",true);
    val mytuple1 = new Tuple4(1,4,"Hi",(2,3));
    println(mytuple);
    println(mytuple1);
    println(mytuple._2);

    mytuple.productIterator.foreach{
      i=>println(i);
    }
    println(mytuple1._4._2);

    //options
    println(mylist.find(_>1));
    println(mylist.find(_>1).get);//.get to access the value

    println(mymap.get(10));
    println(mymap.get(20).getOrElse("No value found"));
    //declaring an option
    val opt : Option[Int] = Some(23);
    println(opt.isEmpty);
    println(opt.get);


    //map and filter
    val lst = List(1,2,3,4,5,6,7);
    println(lst.map(_*2));
    println(mymap.map(x=>"hi"+x));
    println(mymap.mapValues(x=>"hi"+x));
    println(lst.map(x=>List(x,x+1)));//list of lists
    //flatMap
    println(lst.flatMap(x=>List(x,x+1)));

    println(lst.filter(x=>x%2==0));

    //reduce, fold or scan(left and right)
    val lst1 = List(1,2,4,7,9,6,5,0);
    val lst2 = List("A","B","C","D");
    println(lst2.reduceLeft(_+_));
    println(lst1.reduceLeft(_+_));

    println(lst1.foldLeft(10)(_+_));
    println(lst.scanLeft(10)(_+_));


  }
}
