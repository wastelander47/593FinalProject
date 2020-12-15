package rope593;

import java.util.ArrayList;

//Node for constrcuting "Rope tree"
class Node {

	int weight = 0;
	String data;
	Node left;
	Node right;
	Node parent;

	public Node() {
		this.data = null;
		this.weight = 0;
	}
	
	public Node(String data) {
		this.data = data;
		this.weight = data.length();
	}
	
	public Node(String data,Node left,Node right){
		this.data=data;
		this.left=left;
		this.right=right;
	}

	public static void printNode(Node node) {
		if (node != null) {
			printNode(node.left);
			if (node.data != null) {
				System.out.print(node.data);
			}
			printNode(node.right);
		}
	}
}

public class RopeStructure {
    Node root;
    ArrayList<String> content = new ArrayList<>();
    
    public RopeStructure() {
        root = new Node();
    }
    
    public RopeStructure(String data) {
        root = new Node(data);
    }

	public boolean empty(){
		return root.data==null;
	}
	
	public Node root(){
		if(empty()){
			throw new RuntimeException("The tree is null, cannot get root");
		}
		return root;
	}
	
//	public String parent(Node node){
//		return null;
//	}
	
//	//return left child
//	public String leftChild(Node parent){
//		if(parent==null){
//			throw new RuntimeException("the node is Null,cannot add child node");
//		}
//		return parent.left==null?null:parent.left.data;
//	}
//	
//	//return right child
//	public String rightChild(Node parent){
//		if(parent==null){
//			throw new RuntimeException(parent+" node is Null,cannot add child node");
//		}
//		return parent.right==null?null:parent.right.data;
//	}
    
    public int length(Node rootnode) { //get the rope's data length
    	if(rootnode.right == null && rootnode.left == null) {
    		return rootnode.data.length();
    	}
    	else if(rootnode.right == null && rootnode.left != null) {
    		return length(rootnode.left);
    	}
    	else if(rootnode.right != null && rootnode.left == null) {
    		return length(rootnode.right);
    	}
    	else {
    		return length(rootnode.right) + length(rootnode.left);
    	}
    }
    
    public void concatenation(Node node1, Node node2) { //concatenate 2 rope
    	root.left = node1;
    	root.right = node2;
    	root.weight = length(node1);
    	node1.parent = root;
    	node2.parent = root;
    }
    
    public void printRope(Node rootnode) {
    	if(rootnode.right == null && rootnode.left == null) {
    		if(rootnode.data != null) {
    			content.add(rootnode.data);
    			System.out.print(rootnode.data);
    		}
    	}
    	else if(rootnode.left == null) {
    		printRope(rootnode.right);
    	}
    	else if(rootnode.right == null) {
    		printRope(rootnode.left);
    	}
    	else {
    		printRope(rootnode.left);
    		printRope(rootnode.right);
    	}
    }

    public void printRoot() {
        Node.printNode(root);
    }
    
    public char search(Node node, int index) {
    	if (node.weight <=index && node.right !=null) {
    		return search(node.right, index-node.weight);
    	}
    	else if(node.left != null) {
    		return search(node.left, index);
    	}
    	return node.data.charAt(index);
    }
    
    public Node searchNode(Node node, int index) {
    	if (node.weight <=index && node.right !=null) {
    		return searchNode(node.right, index-node.weight);
    	}
    	else if(node.left != null) {
    		return searchNode(node.left, index);
    	}
    	return node;
    }
    
    public Node[] splitNode(Node rootnode, int index) {
    	Node[] newnode = new Node[2];
    	return newnode;
    }
    
    public Node split(Node rootnode, int index) {
    	
    }
    
    public void append(String data) { //
        Node newNode = new Node(data);
        Node tempRoot = new Node();

        tempRoot.left = root;
        tempRoot.right = newNode;

        if (tempRoot.left.right == null) {
            tempRoot.weight = tempRoot.left.weight;
        } else {
            tempRoot.weight = tempRoot.left.weight + tempRoot.left.right.weight;
        }
        root = tempRoot;
    }
    
    public RopeStructure insert(String a, int index) {
        Node tempNode = root;
        if (index > tempNode.weight) {
            index -= tempNode.weight;
            tempNode.right.data = tempNode.right.data.substring(0, index) + a + tempNode.right.data.substring(index);
        }
        while (index < tempNode.weight) {
            tempNode = tempNode.left;
        }
        index -= tempNode.weight;
        tempNode.right.data = tempNode.right.data.substring(0, index) + a + tempNode.right.data.substring(index);
        RopeStructure newrs = new RopeStructure();
        return newrs;
    }

    public void extract(int index) {
        Node tempNode = root;
        int temp = index;
        if (index > tempNode.weight) {
            index -= tempNode.weight;
            System.out.println("The char in " + temp + " is " + tempNode.right.data.charAt(index));
        }

        while (index < tempNode.weight) {
            tempNode = tempNode.left;
        }

        index -= tempNode.weight;
        System.out.println("The char in " + temp + " is " + tempNode.right.data.charAt(index));
    }
    

    public RopeStructure delete(int indexStart, int indexEnd) {
		
    	
    	return null;
    }
    
    
}

