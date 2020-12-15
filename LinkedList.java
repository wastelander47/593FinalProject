// package 593FINALPROJECT;
public class LinkedList {

    private static class Node { // LinkedList.Node

        int weight = 0;
        String data = null;

        public Node left = null;
        public Node right = null;

        public Node(String data) {
            this.data = data;
            this.weight = data.length();
        }
        public Node(){
            this.data = data;
            this.weight = 0;
        }

        public static void printNode(Node node){ // print data from either left node or right node.
            if(node != null){
                printNode(node.left);
                if(node.data != null){
                    System.out.print(node.data);
                }
                printNode(node.right);
            }
        }
    }

    // public LinkedList() { head = null; }

    // public LinkedList(int v) { 
    //     head = new Node(v, null); 
    // }

    // public String toString(){
    //     return size+"";
    // }

    // public void addEnd(int v) {//O(1)
    //     if (head == null) {
    //         head = new Node(v, head);
    //         last = head;
    //     } else {
    //         Node newLast = new Node(v);
    //         last.next = newLast;
    //         last = newLast;
    //     }
    //     size++;
    // }

    // public void addStart(int v) {//O(1)
    //     Node first = new Node(v, head);
    //     head = first;
    //     size++;
    // }

    // public void removeStart() {//O(1)
    //     head = head.next;
    //     size--;
    // }

    // public int getLength() {//O(1)
    //     return size;
    // }

    // public Node getData(int index){//O(n)
    //     if (index < 0 && index > size - 1) {
    //         throw new IndexOutOfBoundsException("Index Out Of Bounds!");
    //     }
    //     Node count = head;
    //     for (int i = 0; i < size && count != null; i++, count = count.next) {
    //         if (i == index) {
    //             return count;
    //         }
    //     }
    //     return null;
    // }

    // void insert(int i, int v) {// index and data, O(1)
    //     if (i < 0 || i > size) {
    //         throw new IndexOutOfBoundsException("Index Out Of Bounds!");
    //     }
    //     if (head == null) {
    //         addEnd(v);
    //     } 
    //     else {
    //         if (i == 0) {
    //             addStart(v);
    //         } else {
    //             Node k = getData(i - 1);
    //             k.next = new Node(v, k.next);
    //             size++;
    //         }
    //     }
    // }

    // public static void main(String args[]){
    //     LinkedList a = new LinkedList();
    //     LinkedList b = new LinkedList();
    //     b.addEnd(10);
    //     b.addStart(8);
    //     b.getData(1);
    //     b.insert(1,5);
    //     System.out.println(b);
    // }

};