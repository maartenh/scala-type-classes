package typeclass

/**
  * Type class definition
  */
trait AddDivideCapable[T] {
  def add(x: T, y: T): T
  def div(n: T, d: Int): T
}


/**
  * Type class implementations
  */
object AddDivideCapable {
  implicit object AddDivideInt extends AddDivideCapable[Int] {
    override def add(x: Int, y: Int): Int = x + y
    override def div(n: Int, d: Int): Int = n / d
  }

  implicit object AddDivideDouble extends AddDivideCapable[Double] {
    override def add(x: Double, y: Double): Double = x + y
    override def div(n: Double, d: Int): Double = n / d
  }
}
