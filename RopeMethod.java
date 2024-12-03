// package com.group13.Rope
// Large scale alternatives to strings: rope
// Implement rope and create tests, benchmarking
//   load 100Mb+
//   insert 1 char, 2 chars, … 200 chars in the middle of 100Mb rope
//   save
//   delete 1 char, 2 chars .. 200 chars in the middle.
//   delete a range 1k to 20k chars.
//   extract a screenful of text (a rectangular window at the start, end and middle

class RopeMethod {
     public void load(String a){
          Node newNode = new Node(a);
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
     // insert(){}
     // save(){}
     // delete(char target){}
     // delete(String target, int left, int right){}
     // extract(){}
}