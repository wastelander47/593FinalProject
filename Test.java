package rope593;

public class Test {
	static String[] data;
	public static void main(String[] args) {
		data = new String[1024];
		generateTestData();
		RopeStructure test = new RopeStructure(data);
		test.printRope(test.root);
		
	}
	
	
	
	public static void generateTestData() {//��String[] data��ÿ��λ����Ӵ�СΪ1024��string
		
	}
	
}
