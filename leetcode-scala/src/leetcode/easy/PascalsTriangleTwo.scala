package leetcode.easy

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.collection.{immutable, mutable}

object PascalsTriangleTwo {

 val res: mutable.Map[(Int, Int), Int] = mutable.HashMap[(Int, Int), Int]();

 def C(n: Int, k: Int): Int = {
  res.getOrElse((n, k), (n, k) match {
   case (_, _) if n == k || k == 0 => 1
   case (_, _) =>
    val tmp = C(n - 1, k - 1) + C(n - 1, k)
    res.addOne((n, k), tmp)
    tmp
  })
 }

 def getRow(rowIndex: Int): List[Int] = {
  (0 to rowIndex).map(index => C(rowIndex, index))
    .toList
 }
}


object PascalsTriangleTwoMath {

 var res: ListBuffer[Long] = ListBuffer[Long]()

 def C(n: Int, k: Int): Unit = {
  (n, k) match {
   case (_, _) if k == 0 || k == n => res.append(1)
   case (_, _) => res.append(res.last * (n - k + 1) / k)
  }
 }

 def getRow(rowIndex: Int): List[Int] = {
  res = ListBuffer[Long]()
  (0 to rowIndex).foreach(index => C(rowIndex, index))
  res.map(e => e.toInt).toList
 }
}


object App extends App {
 println(PascalsTriangleTwoMath.getRow(30))
}
