object HelloWorld {
  def main(args: Array[String]): Unit = {
    val name = "Qasim"
    val age = 25
    println(name + " is "+age + " year old")
    println(s"$name is $age years old")
    println(f"$name%s is $age%d years old")
    println(s"Hello \nWorld")
    println(raw"Hello \nWorld")
  }
}