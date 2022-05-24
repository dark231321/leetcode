package leetcode.patterns;

import java.util.Objects;

public class DesignHashMap {

    private int size = 8;
    private int curSize = 0;
    private int threshold = size >> 1;
    private Node[] arr;

    private static class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public DesignHashMap() {
        this.arr = new Node[8];
    }

    public void put(int key, int value) {
        if (this.arr[key & (size - 1)] == null) {
            if (curSize > threshold && threshold << 1 > -1) {
                resize();
            }
            this.arr[key & (size - 1)] = new Node(key, value);
        } else {
            Node node = this.arr[key & (size - 1)];
            if (node.key == key) {
                node.value = value;
                return;
            }
            while (Objects.nonNull(node.next)) {
                var tmpKey = node.key;
                if (tmpKey == key) {
                    node.value = value;
                    break;
                }
                node = node.next;
            }
            node.next = new Node(key, value);
        }
        curSize++;
    }

    private void resize() {
        threshold <<= 1;
        size <<= 1;
        var newNodes = new Node[size];
        for (var node: this.arr) {
            if (node == null) continue;
            if (newNodes[node.key ^ (size - 1)] == null) {
                newNodes[node.key ^ (size - 1)] = new Node(node.key, node.value);
            } else {
                Node tmp = newNodes[node.key ^ (size - 1)];
                if (node.key == tmp.key) {
                    node.value = tmp.value;
                    continue;
                }
                while (Objects.nonNull(tmp)) {
                    var tmpKey = tmp.key;
                    if (tmpKey == node.key) {
                        tmp.value = node.value;
                        break;
                    }
                    tmp = tmp.next;
                }
                tmp.next = new Node(node.key, node.value);
            }
        }
        this.arr = newNodes;
    }

    public int get(int key) {
        var tmp = this.arr[key & (size - 1)];
        if (tmp == null) return -1;
        while (tmp != null) {
            if (tmp.key == key) {
                return tmp.value;
            }
            tmp = tmp.next;
        }
        return -1;
    }

    public void remove(int key) {
        var tmp = this.arr[key & (size - 1)];
        if (tmp == null) return;
        var last = tmp;
        if (last.key == key) {
            this.arr[key & (size - 1)] = tmp.next;
            return;
        }
        while (tmp != null) {
            if (tmp.key == key) {
                last.next = tmp.next;
                break;
            }
            last = tmp;
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        var myHashMap = new DesignHashMap();
//        for (int i = 0; i < 10; i++) {
//            tmp.put(i, i);
//        }
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
//        for (int i = 0; i < 10; i++) {
//            System.out.println(tmp.get(i));
//        }
    }
}
