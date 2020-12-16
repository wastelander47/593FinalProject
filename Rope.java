package rope593;


import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

//   Large scale alternatives to strings: rope
//   Implement rope and create tests, benchmarking
//   load 100Mb+
//   insert 1 char, 2 chars, ... 200 chars in the middle of 100Mb rope
//   save
//   delete 1 char, 2 chars .. 200 chars in the middle.
//   delete a range 1k to 20k chars.
//   extract a screenful of text (a rectangular window at the start, end and middle

/**
 * @author Shaobo Li
 */

public class Rope implements ActionListener {

    static private JButton load, insert, save, delete, extract;
    static private JFrame frame = new JFrame("ROPE_TEXT");
    static private JLabel textstart = new JLabel("START");
    static private JLabel textmiddle = new JLabel("MIDDLE");
    static private JLabel textend = new JLabel("END");
    static Rope r = new Rope();
    static RopeStructure rs = new RopeStructure();

    public static void main(String[] args) {

        /**
         * the windows
         */

        textstart.setBounds(50, 25, 100, 150);
        textmiddle.setBounds(50, 50, 100, 150);
        textend.setBounds(50, 75, 100, 150);
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
        frame.add(textstart);
        frame.add(textmiddle);
        frame.add(textend);

//        /**
//         * Scanner
//         */
//        Scanner sc = new Scanner(System.in);
        // File file = new File("text.txt");
        // PrintWriter out = new PrintWriter("text.txt");

    }

    String test = "SHOWIT!";
    // get action from buttoms (load insert delete extract)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == load) {
            rs.append(test);
            textstart.setText(test);
            rs.printRoot();
        } else if (e.getSource() == insert) {
        	//rs.insert();
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
