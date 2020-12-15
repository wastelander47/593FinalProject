import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

//   Large scale alternatives to strings: rope
//   Implement rope and create tests, benchmarking
//   load 100Mb+
//   insert 1 char, 2 chars, … 200 chars in the middle of 100Mb rope
//   save
//   delete 1 char, 2 chars .. 200 chars in the middle.
//   delete a range 1k to 20k chars.
//   extract a screenful of text (a rectangular window at the start, end and middle

class Rope implements ActionListener {

    static private JButton load, insert, save, delete, extract;
    static private JFrame frame = new JFrame("ROPE_TEXT");
    static private JTextField textField = new JTextField();
    static Rope r = new Rope();
    static RopeStructure rs = new RopeStructure();

    public static void main(String[] args) {

        /**
         * the windows
         */

        textField.setBounds(50, 50, 600, 150);
        // textField.setEditable(true);
        // set size for buttons
        load = new JButton("load");
        load.setBounds(100, 400, 100, 50);
        load.addActionListener(r);

        insert = new JButton("Insert");
        insert.setBounds(200, 450, 100, 50);
        insert.addActionListener(r);

        save = new JButton("Save");
        save.setBounds(300, 500, 100, 50);
        save.addActionListener(r);

        delete = new JButton("Delete");
        delete.setBounds(400, 550, 100, 50);
        delete.addActionListener(r);

        extract = new JButton("Extract");
        extract.setBounds(500, 600, 100, 50);
        extract.addActionListener(r);

        frame.setSize(new Dimension(750, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        // textField.setText(textField.getText());

        // add components to frame.
        frame.add(load);
        frame.add(insert);
        frame.add(save);
        frame.add(delete);
        frame.add(extract);
        frame.add(textField);

        /**
         * file
         */
        // File file = new File("text.txt");
        // PrintWriter out = new PrintWriter("text.txt");

    }

    // get action from buttoms (load insert delete extract)
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == load) {

            rs.append(textField.getText());
            // textField.setText(textField.getText());
            rs.printRoot();
        } else if (e.getSource() == insert) {

            // rs.insert(textField.getText(), index);
            System.out.println(e.getActionCommand());
        } else if (e.getSource() == delete) {
            System.out.println(e.getActionCommand());
        } else if (e.getSource() == save) {
            System.out.println(e.getActionCommand());
        } else if (e.getSource() == extract) {
            System.out.println(e.getActionCommand());
        } else {
            System.err.println("No action!");
        }
    }
}

/**
 * the tree model using here is binary tree.
 */
class RopeStructure {
    Node root;

    public RopeStructure() {
        root = new Node();
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
}

// Node for constrcuting "Rope tree"
class Node {

    int weight = 0;
    String data = null;
    public Node left = null;
    public Node right = null;

    public Node(String data) {
        this.data = data;
        this.weight = data.length();
    }

    public Node() {
        this.data = null;
        this.weight = 0;
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