package rope593;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Tianze Liang
 */
public class Test implements ActionListener{
	
    static private JButton load, insert, save, delete, extract;
    static private JFrame frame = new JFrame("ROPE_TEXT");
    static private JLabel textstart = new JLabel("START");
    static private JLabel textmiddle = new JLabel("MIDDLE");
    static private JLabel textend = new JLabel("END");
    static Test r = new Test();
    static RopeStructure rs = new RopeStructure();
	
	
    
    
	static String[] data;
	static String start;
	static String end;
	static String middle;
	
	public static void main(String[] args) {
		data = new String[10480];
		generateTestData();
//		for(int i = 0; i<512;i++)
//			data[i]="xy";
//		for(int i = 512; i<1024;i++)
//			data[i]="yx";
		//long time1= System.currentTimeMillis();
		RopeStructure test = new RopeStructure(data);
		//long time2= System.currentTimeMillis()-time1;
		//System.out.println("rope generate time:" + time2);
		//long time3= System.currentTimeMillis();
		test.printRope(test.root);
		//long time4= System.currentTimeMillis()-time1;
		//System.out.println("rope printer time:" + time2);
		int length = test.length(test.root);
		System.out.println("");
		System.out.println(length);
		System.out.println(test.root.weight);
		char search1 = test.search(test.root, 12);
		char search2 = test.search(test.root, 13);
		System.out.println(search1 + " " + search2);
		int halflength = test.content.size()/2;
		System.out.println(halflength);
		//delete 1 char, 2 chars .. 200 chars in the middle.
		test.delete(256,257);
		//test.delete(halflength,halflength+2);
		test.printRope(test.root);
		
		start = test.content.get(0);
		end = test.content.get(test.content.size()-1);
		middle = test.content.get(test.content.size()/2);
		System.out.println(start);
		System.out.println(middle);
		System.out.println(end);
		
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

//        insert = new JButton("Insert");
//        insert.setBounds(200, 450, 100, 50);
//        insert.addActionListener(r);
//
//        save = new JButton("Save");
//        save.setBounds(300, 500, 100, 50);
//        save.addActionListener(r);
//
//        delete = new JButton("Delete");
//        delete.setBounds(400, 550, 100, 50);
//        delete.addActionListener(r);
//
//        extract = new JButton("Extract");
//        extract.setBounds(500, 600, 100, 50);
//        extract.addActionListener(r);

        frame.setSize(new Dimension(750, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        // textField.setText(textField.getText());

        // add components to frame.
        frame.add(load);
//        frame.add(insert);
//        frame.add(save);
//        frame.add(delete);
//        frame.add(extract);
        frame.add(textstart);
        frame.add(textmiddle);
        frame.add(textend);
	}
	
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == load) {
            //rs.append(start);
            //rs.append(middle);
            //rs.append(end);
            textstart.setText(start);
            textmiddle.setText(middle);
            textend.setText(end);
            //rs.printRoot();
//        } else if (e.getSource() == insert) {
//        	//rs.insert();
//            // rs.insert(textField.getText(), index);
//            System.out.println(e.getActionCommand());
//        } else if (e.getSource() == delete) {
//            System.out.println(e.getActionCommand());
//        } else if (e.getSource() == save) {
//            System.out.println(e.getActionCommand());
//        } else if (e.getSource() == extract) {
//            System.out.println(e.getActionCommand());
        } else {
            System.err.println("No action!");
        }
    }
	
	public static void generateTestData() {//给String[] data里每个位置添加大小为1024的string
		long time1= System.currentTimeMillis();
		for(int i = 0 ; i< 10480; i++) {
			//a 32*16 string
			data[i] = "aaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhhaaaabbbbccccddddeeeeffffgggghhhh";
		}
		long time2= System.currentTimeMillis()-time1;
		System.out.println("data generate time:" + time2);
	}
	
}
