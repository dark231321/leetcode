package leetcode.common.tree

import java.util.Comparator
import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.util.Random

abstract class AvlNode[key, value]

sealed case class EmptyNode[key, value] () extends AvlNode[key, value]

sealed case class AvlNodeBranch[key, value]
  (var key: key,
   var value: value,
   var parent: AvlNode[key, value] = EmptyNode[key, value](),
   var height: Short = 0,
   var left:   AvlNode[key, value] = EmptyNode[key, value](),
   var right:  AvlNode[key, value] = EmptyNode[key, value]()) extends AvlNode[key, value]

trait AvlTreeTrait[key, value] {
  def insert(key: key, value: value): AvlTree[key, value]
  def remove(key: key, value: value): AvlTree[key, value]
  def toList(buffer: ListBuffer[AvlNodeBranch[key, value]]): ListBuffer[AvlNodeBranch[key, value]]
  def height(node: AvlNodeBranch[key, value]): Short;
}

sealed class AvlTree[key, value]
  (var size: Int = 0,
   var root: AvlNode[key, value] = EmptyNode[key, value]()) extends AvlTreeTrait[key, value] {

  override def height(node: AvlNodeBranch[key, value]): Short = {
    def getVal(node: AvlNode[key, value]): Short = {
      node match {
        case EmptyNode() => 0
        case AvlNodeBranch(_,_,_,h,_,_) => (Math.abs(h) + 1).toShort
      }
    }
    (getVal(node.left) - getVal(node.right)).toShort
  }

  override def insert(key: key, value: value): AvlTree[key, value] = {
    root match {
      case EmptyNode() =>
        this.size += 1
        this.root = new AvlNodeBranch[key, value](key, value)
      case _ =>
        def insertSupport(root: AvlNode[key, value],
                          parent: AvlNodeBranch[key, value],
                          key: key,
                          value: value,
                          isLeft: Boolean): AvlNode[key, value] = {
          root match {
            case EmptyNode() =>
              val tmp = new AvlNodeBranch[key, value](key, value, parent)
              if (isLeft) {
                parent.left = tmp
              } else {
                parent.right = tmp
              }
              tmp
            case br @AvlNodeBranch(k, v, p, _, l, r) =>
              val res: Int = k.asInstanceOf[Comparable[key]].compareTo(key)
              if (res > 0) {
                br.left = insertSupport(l, br, key, value, true)
              } else if (res < 0) {
                br.right = insertSupport(r, br, key, value, false)
              } else {
                return root
              }
              br.height = height(br)
              rebalanced(br, key)
          }
        }
        this.size += 1
        this.root = insertSupport(this.root, null, key, value, false)
    }
    this
  }

  /**
   * if height == -2
   * 1    x       height -2                y
   *   t1   y     height -1   ---->     x     z
   *     t2   z   height  0           t1 t2 t3 t4
   *        t3 t4
   *
   * 2    x       height -2              x
   *   t1   y     height -1    ---->  t1   z
   *      z   t4  height  0             t2   y
   *   t2   t3                             t3 t4
   *
   * else == 2
   *
   * 1         x                  y
   *         y   t1            z     x
   *       z   t2     ---->  t4 t3 t2  t1
   *    t4  t3
   *
   *
   * 2       x        height -2             x
   *      y    t4     height -1    ---->  z  t4
   *   t1    z        height  0         y  t3
   *      t2   t3                     t1 t2
   * */


  /**
   *    y
   *  t1 x
   *   t2 z
   *    t3 t4
   * */
  private def leftRotation(y: AvlNodeBranch[key, value]) : AvlNodeBranch[key, value] = {
    val x = y.right.asInstanceOf[AvlNodeBranch[key, value]]
    val t2 = x.left

    y.right = t2
    x.left = y

    x.height = height(x)
    y.height = height(y)
    x
  }


  /**
   *        x
   *      y  t1
   *    z  t2
   * */
  private def rightRotation(x: AvlNodeBranch[key, value]) : AvlNodeBranch[key, value] = {
    val y = x.left.asInstanceOf[AvlNodeBranch[key, value]]
    val t2 = y.right
    x.left = t2
    y.right = x

    x.height = height(x)
    y.height = height(y)

    y
  }

  private def rebalanced(x: AvlNodeBranch[key, value], key: key) : AvlNodeBranch[key, value] = {
    if (x.height > 1) {
      val tmp = x.left.asInstanceOf[AvlNodeBranch[key, value]]
      val res: Int = tmp.key.asInstanceOf[Comparable[key]].compareTo(key)
      if (res > 0) {
        rightRotation(x)
      } else {
        x.left = leftRotation(tmp)
        rightRotation(x)
      }
    } else if (x.height < -1) {
      val tmp = x.right.asInstanceOf[AvlNodeBranch[key, value]]
      val res: Int = tmp.key.asInstanceOf[Comparable[key]].compareTo(key)
      if (res < 0) {
        leftRotation(x)
      } else {
        x.right = rightRotation(tmp)
        leftRotation(x)
      }
    } else {
      x
    }
  }
  override def toList(buffer: ListBuffer[AvlNodeBranch[key, value]] = ListBuffer()): ListBuffer[AvlNodeBranch[key, value]] = {
    def toListHelper(root: AvlNode[key, value],
                     buffer: ListBuffer[AvlNodeBranch[key, value]]): ListBuffer[AvlNodeBranch[key, value]] = {
      root match {
        case branch @AvlNodeBranch(_, _, _, _, _, _) =>
          buffer.addOne(branch)
          toListHelper(branch.left, buffer)
          toListHelper(branch.right, buffer)
        case _ => buffer
      }
    }
    toListHelper(root, buffer)
  }


  override def remove(key: key, value: value): AvlTree[key, value] = {

    @tailrec
    def removeHelper(root: AvlNode[key, value],
                     key: key, value: value) : Unit = {
      root match {
        case br @AvlNodeBranch(k, v, _, _, r, l) =>
          if (k == key && v == value) {
            (l, r) match {
              case (EmptyNode(), EmptyNode()) => swapParentToEmpty(br)
              case (EmptyNode(), searchRight@AvlNodeBranch(_, _, _, _, _, _)) => swapToLeaf(br, searchMin(searchRight))
              case (searchLeft@AvlNodeBranch(_, _, _, _, _, _), EmptyNode()) => swapToLeaf(br, searchMin(searchLeft))
            }
          } else {
            val res: Int = key.asInstanceOf[Comparable[key]].compareTo(key)
            if (res >= 0) {
              removeHelper(l, key, value)
            } else {
              removeHelper(r, key, value)
            }
          }
        case EmptyNode() =>
      }
    }
    removeHelper(root, key, value)
    this
  }

  private def swapToLeaf(root: AvlNodeBranch[key, value],
                         end: AvlNodeBranch[key, value]): Unit = {
    root.key = end.key
    root.value = end.value
    swapParentToEmpty(end)
  }

  private def swapParentToEmpty(end: AvlNodeBranch[key, value]): Unit = {
    end.parent match {
      case EmptyNode() =>
      case br @AvlNodeBranch(_,_,_,_,_,_) =>
        br.left = EmptyNode()
        br.right = end.right
    }
  }

  @tailrec
  private def searchMin(root: AvlNodeBranch[key, value]): AvlNodeBranch[key, value] = {
    root.left match {
      case EmptyNode() => root
      case left@AvlNodeBranch(_,_,_,_,_,_) => searchMin(left)
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val i = new AvlTree[Int, String]()
    val rand = new Random()
    val j = rand.nextInt() % 10
    (0 to 5).foreach(ints => i.insert(rand.nextInt() % 100, ints.toString))
    println(i.toList().size)
    i.toList().foreach(res => println(res.key + " " + res.value + " " + res.height))
  }
}
