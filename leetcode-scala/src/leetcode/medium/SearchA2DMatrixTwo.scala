package leetcode.medium

import scala.annotation.tailrec

object SearchA2DMatrixTwo {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    searchHelper(matrix, target, 0, matrix.apply(0).length - 1)
  }

  @tailrec
  def searchHelper(matrix: Array[Array[Int]], target: Int, i: Int, j: Int): Boolean = {
    if (j < 0 || i >= matrix.length)
      return false
    if (matrix.apply(i).apply(j) == target) {
      true
    } else if (matrix.apply(i).apply(j) > target) {
      searchHelper(matrix, target, i, j - 1)
    } else {
      searchHelper(matrix, target, i + 1, j)
    }
  }
}

object Main extends App {
  println(SearchA2DMatrixTwo.searchMatrix(Array(Array(1, 1)), 20))
}
