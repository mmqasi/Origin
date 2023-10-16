object Demo {
  def main(args: Array[String]): Unit = {
    //if statement
    val x=20;
    println("Using if")
    if (x== 20){
      println("x=20")
    }else{
      println("x!=20")
    }
  println(if (x==20) "x=20" else "x not 20")

    //and , or operators
  println(if ((1==1) && (5==5)) "true"  )
  println(if ((1==1) || (5==4)) "true"  )

 //while loop and do while
 var i=0;
 println("Using while and do- while")
 while(i<3){
   println("Line " +i)
   i +=1
 }
 var j=1
 do{
   println("Line " +j)
   j +=1
 }while(j<3)

 //for loop
 println("Using for to loop")
 for(i<- 1 to 3){
   println("Line "+i)
 }
 println("For - until loop")
 for(i <-3 until 6 ){
   println("Line "+i)
 }
 //nested for loop
 println("Nested for loop")
 for(i <-1 to 3; j<- 1 to 3 ){
      println("Line  " + i +" inner loop" + j)
    }
 //printing list
 println("Printing list with for loop")
 val lst = List(33,2,1,4,5,7,8)
 for (i<- lst) {
   println(i)
 }
   println("for loop with condition, printing even numbers")
 for(i <- lst; if i%2==0){
   println(i)
 }

//Match expressions
val age = 18
age match{
  case 18 => println(age + " eligible")
  case 6 =>  println("child")
  case 0 => println("new born")
  case _ => println("Invalid")
}


  }
}
