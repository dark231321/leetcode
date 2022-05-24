package leetcode.medium

import scala.annotation.tailrec

object IncreasingTripletSubsequence {
  def increasingTriplet(nums: Array[Int]): Boolean = {
    var fi = Int.MaxValue
    var se = Int.MaxValue
    for (i <- nums.indices) {
      nums.apply(i) match {
        case tmp: Int if(nums.apply(i) <= fi) => fi = tmp
        case tmp: Int if(nums.apply(i) <= se) => se = tmp
        case (_) => return true
      }
    }
    false
  }

}
