package rope593;


/**
 * @author Tianze Liang
 */
public class Test {
	static String[] data;
	public static void main(String[] args) {
		data = new String[10240];
		generateTestData();
//		for(int i = 0; i<512;i++)
//			data[i]="xy";
//		for(int i = 512; i<1024;i++)
//			data[i]="yx";
		RopeStructure test = new RopeStructure(data);
		test.printRope(test.root);
		int length = test.length(test.root);
		System.out.println("");
		System.out.println(length);
		System.out.println(test.root.weight);
		char search1 = test.search(test.root, 513);
		char search2 = test.search(test.root, 256);
		System.out.println(search1 + " " + search2);
	}
	
	public static void generateTestData() {//给String[] data里每个位置添加大小为1024的string
		for(int i = 0 ; i< 10240; i++) {
			data[i] = "aaaabbbbccccddddeeeeffffgggghhhh";
		}
	}
	
}
