package org.example.leetcode.other.lists;

import org.example.leetcode.utils.LinkedListNode;
import org.example.leetcode.utils.Utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class DuplicateInLinkedList {

    public static List<Integer> deleteDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int nextInt = iterator.next();
            if (uniqueNumbers.contains(nextInt)) {
                iterator.remove();
            } else {
                uniqueNumbers.add(nextInt);
            }
        }

        return numbers;
    }

    public static LinkedListNode deleteDuplicateWithoutBuffer(LinkedListNode numbers) {
        LinkedListNode first = numbers;
        while (Objects.nonNull(numbers.getNext())) {
            int curVal = numbers.getValue();
            LinkedListNode next = numbers.getNext();
            while (Objects.nonNull(next.getNext())) {
                if (curVal == next.getValue()) {
                    LinkedListNode tmp = next.getNext();
                    tmp.setPrevious(next.getPrevious());
                    next.getPrevious().setNext(tmp);
                }
                next = next.getNext();
            }
            numbers = numbers.getNext();
        }

        return first;
    }

    public static void main(String[] args) {
        var i = new LinkedList<>(List.of(1, 2, 5, 4, 5));
        LinkedListNode linkedListNode = Utils.randomLinkedListNode(10, 0, 5);
        Utils.print(linkedListNode);
        Utils.print(deleteDuplicateWithoutBuffer(linkedListNode));
    }
}
