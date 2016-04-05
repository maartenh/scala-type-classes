package typeclass

object Statistics extends App {
  
  def sum[T](xs: Seq[T])(implicit ev: AddDivideCapable[T]): T =
    xs.reduce(ev.add)
    
    
  def mean[T](xs: Seq[T])(implicit ev: AddDivideCapable[T]): T =
    ev.div(xs.reduce(ev.add), xs.length)
  
  
  val ints = List(4, 1, 6, 9, 6, 10, 11)
  
  println(s"sum($ints) = ${sum(ints)}")
  println(s"mean($ints) = ${mean(ints)}")
  

  val doubles = Vector(5.9, 13.4, 3.14, 77.2, 45.3)

  println(s"sum($doubles) = ${sum(doubles)}")
  println(s"mean($doubles) = ${mean(doubles)}")
  

  val vectors2 = Vector(new VectorR2(5.82, 13.5), new VectorR2(3.1415, 77.25), new VectorR2(45.3, 12.9))

  println(s"sum($vectors2) = ${sum(vectors2)}") 
  println(s"mean($vectors2) = ${mean(vectors2)}")
  

  val vectors3 = Vector(new Vector3[Int](82, 35, 23), new Vector3[Int](141, 72, 99), new Vector3[Int](3, 12, 9))

  println(s"sum($vectors3) = ${sum(vectors3)}")
  println(s"mean($vectors3) = ${mean(vectors3)}")

}
