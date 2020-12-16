package rope593;

import java.util.ArrayList;

//Node for constrcuting "Rope tree"
/**
 * @author Tianze Liang
 */
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
	
	public Node(String data,Node parent){
		this.data = data;
		this.parent = parent;
	}
	/**
	 * get the whole rope's data length
	 */
    public int length(Node rootnode) {
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
	
	/**
	 * import the whole data as String[]
	 */
	public Node(String[] data) {
    	if(data.length==1) {
    	this.data=data[0];
        this.left=null;
        this.right=null;
        this.parent= null;
    	}
    	else {
    		int div = data.length;
    		String[] data1 = new String[data.length/2];
    		String[] data2 = new String[data.length/2];
    		for(int i = 0; i<(div/2);i++) {
    			data1[i]=data[i];
    			data2[i]=data[i+(div/2)];
    		}
    		this.left = new Node(data1);
    		this.right = new Node(data2);
    		this.data = "";
    		this.weight = length(this);
    	}
    }

	public static void printNode(Node node) {//printout the data
		if (node != null) {
			printNode(node.left);
			if (node.data != null) {
				System.out.print(node.data);
			}
			printNode(node.right);
		}
	}
}

/**
 * @author Tianze Liang, Shaobo Li, Xu Nan
 */
public class RopeStructure {
    Node root;
    Node[] templ1;
    Node[] templ2;
    Node tempn1;
    Node tempn2;
    Node tempn;
    ArrayList<String> content = new ArrayList<>();
    
    public RopeStructure() {
        root = new Node();
    }
    
    /**
     * initialize RopeStructure
     * @author Tianze Liang
     */
    public RopeStructure(String[] data) {
    	if(data.length==1) {
    	root = new Node(data[0]);
        root.left=null;
        root.right=null;
        root.parent= null;
        //root.data = data[0];
    	}
    	else {
    		int div = data.length;
    		String[] data1 = new String[data.length/2];
    		String[] data2 = new String[data.length/2];
    		for(int i = 0; i<(div/2);i++) {
    			data1[i]=data[i];
    			data2[i]=data[i+(div/2)];
    		}
    		root.left = new Node(data1);
    		root.right = new Node(data2);
    	}
    }
    

	public RopeStructure(String data) {
        root = new Node(data);
        root.left=null;
        root.right=null;
        root.parent= null;
        root.data = data;
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
	/**
	 * get the rope's data length
	 * @author Tianze Liang
	 */
    public int length(Node rootnode) {
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
    
	/**
	 * concatenate 2 rope
	 * @author Tianze Liang
	 */
    public void concatenation(Node node1, Node node2) {
    	root.left = node1;
    	root.right = node2;
    	root.weight = length(node1);
    	node1.parent = root;
    	node2.parent = root;
    }
    
	/**
	 * printout all saved data
	 * save the rope data into ArrayList content
	 * @author Tianze Liang
	 */
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

	/**
	 * @author Tianze Liang
	 */
    public void printRoot() {
        Node.printNode(root);
    }
    
	/**Find the char at index position
	 * @author Tianze Liang
	 */
    public char search(Node node, int index) {
    	if (node.weight <=index && node.right !=null) {
    		return search(node.right, index-node.weight);
    	}
    	else if(node.left != null) {
    		return search(node.left, index);
    	}
    	return node.data.charAt(index);
    }
    
    
	/**Find the Node that include the char at index position
	 * @author Tianze Liang
	 */
    int searchi;
    public Node searchNode(Node node, int index) {
    	if (node.weight <=index && node.right !=null) {
    		return searchNode(node.right, index-node.weight);
    	}
    	else if(node.left != null) {
    		return searchNode(node.left, index);
    	}
    	searchi=index;
    	return node;
    }
    
//    public Node split(Node root, int index){
//        if(root == null) {
//            return null;
//        }
//        while(root != null){
//            if(root.weight > index)
//                root = root.left;
//            else if(root.weight < index)
//                root = root.right;
//            else
//            {
//                temprootglobal=root.right;
//                root.right=null;
//                break;
//            }
//
//        }
//            return root;
//    }
	
	/**
	 * Get the rope data using StringBuffer
	 * @author Xu Nan
	 */
	public StringBuffer subString(int start,int end,Node rootnode)
	{
		StringBuffer str = new StringBuffer("");
		boolean found=false;
		Node tmp=rootnode;
		if(end>tmp.weight)
		{
			found=true;
			end-=tmp.weight;
			if(start>tmp.weight)
			{
				start-=tmp.weight;
				str= new StringBuffer(tmp.right.data.substring(start,end));
				return str;
			}
			else
				str=new StringBuffer(tmp.right.data.substring(0,end));
		}
		if(!found)
		{
			while(end<=tmp.weight)
				tmp=tmp.left;
			end-=tmp.weight;
			if(start>=tmp.weight)
			{
				start-=tmp.weight;
				StringBuffer strtemp = str;
				str=new StringBuffer(tmp.right.data.substring(start,end));
				str.append(strtemp);
				return str;
			}
			str=new StringBuffer(tmp.right.data.substring(0,end));
		}
		tmp=tmp.left;
		while(start<tmp.weight)
		{
			StringBuffer strtemp = str;
			str=new StringBuffer(tmp.right.data);
			str.append(strtemp);
			tmp=tmp.left;
		}
		start-=tmp.weight;
		StringBuffer strtemp = str;
		str=new StringBuffer(tmp.right.data.substring(start));
		str.append(strtemp);
		return str;
	}
	
//    public Node[] split(Node rootnode, int index) {
//		Node[] newnode=new Node[2];
//		StringBuffer str1=subString(0,index-1,rootnode);
//		StringBuffer str2=subString(index,length(rootnode),rootnode);
//		return newnode;
//    }

	/**
	 * split on this node's "index" position
	 * @author Tianze Liang
	 */
    public Node[] splitNode(Node node, int index) {
    	Node[] split = new Node[2];
    	if(index>node.data.length()) {
    		throw new RuntimeException("the index is out of bound");
    	}
    	String str1 = node.data.substring(0, index);
    	String str2 = node.data.substring(index);
    	Node newnode1 = new Node(str1);
    	Node newnode2 = new Node(str2);
    	split[0]=newnode1;
    	split[1]=newnode2;
    	return split;
    }
    
	/**
	 * split the rope on rootnode's index position
	 * @author Xu Nan
	 */
    public Node[] split(Node rootnode, int index) {
    	Node target = searchNode(rootnode, index);
    	int tempi = searchi;
    	if(target.parent == null) {
    		return splitNode(target, index);
    	}
    	else if(target.parent != null) {
    		if(index!=0) {
    			Node[] split = splitNode(target, index);
    			Node split1 = split[0];
    			Node split2 = split[1];
    			target.left = split1;
    			target.right = split2;
    			target.weight = split1.data.length();
    			Node rightNode = target.right;
    			target.right = null;
    			target.parent.weight -= rightNode.data.length();
    		}
    	}
		return null;
    }
    
	/**
	 * main split, split node on rope's index position, save the splitted node on tempn
	 * @author Tianze Liang
	 */
    public void splits(Node root, int index) {
    	Node node = searchNode(root, index);
    	int tempi = searchi;
    	
    	String str1 = node.data.substring(0, tempi);
    	String str2 = node.data.substring(tempi);
    	
    	Node node0 = new Node(str1);
    	Node node1 = new Node(str2);
    	
    	node.weight = node0.data.length();
    	node.left = node0;
    	node.right = node1;
    	node0.parent = node;
    	node1.parent = node;
    	Node[] l2 = split(root, index);
    	Node[] l1 = split(root, 0);
    	node0.printNode(node0);
    	node1.printNode(node1);
    	templ1=l1;
    	templ2=l2;
    	tempn=node;
    	//tempn2=node1;
    }
    
	/**
	 * another way to implement insert method
	 * @author Tianze Liang
	 */
    public void anotherinsert(String indata, int index) {
    	splits(root, index);
    	Node[] newrope = new Node[2];
    	newrope[0]=root;
    	newrope[1]=tempn;
    	Node inRope = new Node(indata);
    	concatenation(root,inRope);
    	concatenation(tempn,root);
    }
    
	/**append char after another one
	 * @author Shaobo Li
	 */
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
    
	/**insert char to node
	 * @author Shaobo Li
	 */
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

	/**extract char in a specific index
	 * @author Shaobo Li
	 */
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

  /**balance the rope
	 * @author Xu Nan
	 */
    public Node balance(Node rootnode){
		List<Node>ls=new ArrayList<Node>();
		inorder(root,ls);
		return construct(ls,0,ls.size()-1);
	}
	public void inorder(Node root,List<Node>ls) {
		if(root==null){
			return;
		}
	inorder(root->left,ls);
	ls.add(root);
	inorder(root.right,ls);
}
    
	/**delete from start index to end index
	 * @author Xu Nan
	 */
    public void delete(int indexStart, int indexEnd) {
		Node[] tmp1=split(root,indexStart);
		Node[] tmp2=split(root,indexEnd);
		concatenation(tmp1[0], tmp2[1]);
    }
    
    
}

