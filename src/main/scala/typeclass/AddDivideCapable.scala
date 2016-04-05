package typeclass

import scala.annotation.implicitNotFound

/**
  * Type class definition
  */
@implicitNotFound("No member of type class AddDivideCapable found for type ${T}")
trait AddDivideCapable[T] {
  def add(x: T, y: T): T
  def div(n: T, d: Int): T
}


/**
  * Type class implementations
  */
object AddDivideCapable {
  def apply[T: AddDivideCapable]: AddDivideCapable[T] = implicitly[AddDivideCapable[T]]
  
  implicit object AddDivideInt extends AddDivideCapable[Int] {
    override def add(x: Int, y: Int): Int = x + y
    override def div(n: Int, d: Int): Int = n / d
  }

  implicit object AddDivideDouble extends AddDivideCapable[Double] {
    override def add(x: Double, y: Double): Double = x + y
    override def div(n: Double, d: Int): Double = n / d
  }

  implicit object AddDivideVectorR2 extends AddDivideCapable[VectorR2] {
    override def add(a: VectorR2, b: VectorR2): VectorR2 = new VectorR2(a._1 + b._1, a._2 + b._2)
    override def div(a: VectorR2, d: Int): VectorR2 = new VectorR2(a._1 / d, a._2 / d)
  }

  implicit def AddDivideVector3[T](implicit ev: AddDivideCapable[T]): AddDivideCapable[Vector3[T]] =
    new AddDivideCapable[Vector3[T]] {
      override def add(x: Vector3[T], y: Vector3[T]): Vector3[T] = new Vector3[T](ev.add(x._1, y._1), ev.add(x._2, y._2), ev.add(x._3, y._3))
      override def div(n: Vector3[T], d: Int): Vector3[T] = new Vector3[T](ev.div(n._1, d), ev.div(n._2, d), ev.div(n._3, d))
    }
}
