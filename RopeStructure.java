package rope593;

//Node for constrcuting "Rope tree"
class Node {

	int weight = 0;
	String data;
	Node left;
	Node right;

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
	
	public String parent(Node node){
		return null;
	}
	
	//return left child
	public String leftChild(Node parent){
		if(parent==null){
			throw new RuntimeException("节点为Null,无法添加子节点");
		}
		return parent.left==null?null:parent.left.data;
	}
	
	//return right child
	public String rightChild(Node parent){
		if(parent==null){
			throw new RuntimeException(parent+"节点为null，无法添加子节点");
		}
		return parent.right==null?null:parent.right.data;
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

    public void insert(char a, int index) {
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

    }
    
    public void insert(String a, int index) {
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

    }

    // save(){}
    // delete(char target){}
    // delete(String target, int left, int right){}
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

    public void printRoot() {
        Node.printNode(root);
    }
    
    public char search(Node node, int index) {
    	if (node.weight <=index && node.right !=null) {
    		return search(node.right,index-node.weight);
    	}
    	else if(node.left != null) {
    		return search(node.left, index);
    	}
    	return node.data.charAt(index);
    }
    
    
    
}

