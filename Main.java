import java.util.*
;// Large scale alternatives to strings: rope
// Implement rope and create tests, benchmarking
//   load 100Mb+
//   insert 1 char, 2 chars, … 200 chars in the middle of 100Mb rope
//   save
//   delete 1 char, 2 chars .. 200 chars in the middle.
//   delete a range 1k to 20k chars.
//   extract a screenful of text (a rectangular window at the start, end and middle

public class Main {
     public static void main(String []args){

          Rope r = new Rope();

          r.append("Hello");
          r.append(" wo");
          r.append("rld");
          r.append(" !");
          
          r.printRoot();

          r.insert('F', 2);
          r.printRoot();
          // for(int i = 0; i< 100_000_000; i++){  // fix Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
          //      r.append("adfa");
          // }
          // r.extract(100);  // add exception the out of boundary!
     }
}
/**
 * the tree model using here is binary tree.
 */
class Rope {
     Node root;

     public Rope(){
          root = new Node();
     }

     public void append(String data){ // 
          Node newNode = new Node(data);
          Node tempRoot = new Node();

          tempRoot.left = root;
          tempRoot.right = newNode;

          if(tempRoot.left.right == null){
               tempRoot.weight = tempRoot.left.weight;
          }
          else{
               tempRoot.weight = tempRoot.left.weight + tempRoot.left.right.weight;
          }
          root = tempRoot;
     }

     public void insert(char a, int index){
          Node tempNode = root;
          if(index > tempNode.weight){
               index -= tempNode.weight;
               tempNode.right.data = tempNode.right.data.substring(0, index) + a + tempNode.right.data.substring(index);
          }
          while(index < tempNode.weight){
               tempNode = tempNode.left;
          }
          index -= tempNode.weight;
          tempNode.right.data = tempNode.right.data.substring(0, index) + a + tempNode.right.data.substring(index);

     }
     // save(){}
     // delete(char target){}
     // delete(String target, int left, int right){}
     public void extract(int index){
          Node tempNode = root;
          int temp = index;
          if(index > tempNode.weight){
               index -= tempNode.weight;
               System.out.println("The char in " + temp +" is " + tempNode.right.data.charAt(index));
          }

          while(index < tempNode.weight){
               tempNode = tempNode.left;
          }

          index -=tempNode.weight;
          System.out.println("The char in " + temp +" is " + tempNode.right.data.charAt(index));
     }

     public void printRoot(){
          Node.printNode(root);
     }
}
/*
* This class is to create node for Rope tree
*/
class Node {

     int weight = 0;
     String data = null;
     public Node left = null;
     public Node right = null;
 
     public Node(String data) {
         this.data = data;
         this.weight = data.length();
     }
     public Node(){
         this.data = null;
         this.weight = 0;
     }
 
     public static void printNode(Node node){
         if(node != null){
             printNode(node.left);
             if(node.data != null){
                 System.out.print(node.data);
             }
             printNode(node.right);
         }
     }
 }
