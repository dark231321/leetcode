package leetcode.medium

object RotateImage {
  /**
  (5, 1  9,  11)        (15,13,2, 5)
     (2, 4, 8,  10)  ----> (14,3, 4, 1)
     (13,3, 6,  7 )        (12,6, 8, 9)
     (15,14,12, 16)        (16,7, 10,11)

      j                      j
    i(5, 1, 9, 11,21)      i(25,1, 9, 11,5)
     (2, 4, 8, 10,22)       (2, 4, 8, 10,22)
     (13,3, 6, 7, 23) ----> (13,3, 6, 7, 23)
     (15,14,12,16,24)       (15,14,12,16,24)
     (25,26,27,28,29)       (29,26,27,28,21)
   */
  def rotate(matrix: Array[Array[Int]]): Unit = {
    val size = matrix.length / 2 + matrix.length % 2
    matrix.foreach(a => println(a.mkString("Array(", ", ", ")")))
    (0 to size).foreach(i =>
      val sizeMatrix = matrix.length - 1 - i
      (i until sizeMatrix).map(j => {
        val index = if (i == 0) j else j - 1;
        val first = matrix.apply(i).apply(j)
        matrix.apply(i).update(j, matrix.apply(sizeMatrix - index).apply(i))
        matrix.apply(sizeMatrix - index).update(i, matrix.apply(sizeMatrix).apply(sizeMatrix - index))
        matrix.apply(sizeMatrix).update(sizeMatrix - index, matrix.apply(j).apply(sizeMatrix))
        matrix.apply(j).update(sizeMatrix, first)
      }
      )
    )
  }
}

object Solution {
  /**
  (5, 1  9,  11)        (15,13,2, 5)
     (2, 4, 8,  10)  ----> (14,3, 4, 1)
     (13,3, 6,  7 )        (12,6, 8, 9)
     (15,14,12, 16)        (16,7, 10,11)

      j                      j
    i(5, 1, 9, 11,21)      i(25,1, 9, 11,5)
     (2, 4, 8, 10,22)       (2, 4, 8, 10,22)
     (13,3, 6, 7, 23) ----> (13,3, 6, 7, 23)
     (15,14,12,16,24)       (15,14,12,16,24)
     (25,26,27,28,29)       (29,26,27,28,21)
   */
  def rotate(matrix: Array[Array[Int]]): Unit = {
    val size = matrix.length / 2 + matrix.length % 2
    (0 to size).foreach(i => {
      val sizeMatrix = matrix.length - 1 - i
      (i until sizeMatrix).map(j => {
        val index = if (i == 0) j else j - 1;
        val first = matrix.apply(i).apply(j)
        matrix.apply(i).update(j, matrix.apply(sizeMatrix - index).apply(i))
        matrix.apply(sizeMatrix - index).update(i, matrix.apply(sizeMatrix).apply(sizeMatrix - index))
        matrix.apply(sizeMatrix).update(sizeMatrix - index, matrix.apply(j).apply(sizeMatrix))
        matrix.apply(j).update(sizeMatrix, first)
      })
    })

    matrix.foreach(e => println(e.mkString(" ")))
  }

  def rotateMatrix(matrix: Array[Array[Int]]): Unit = {
    matrix.indices.map(i => (i until matrix.length).map(j => {
      val tmp = matrix.apply(i).apply(j)
      matrix.apply(i).update(j, matrix.apply(j).apply(i))
      matrix.apply(j).update(i, tmp)
    }))
    matrix.indices.foreach(i => matrix.update(i, matrix.apply(i).reverse))
  }
}
