
public class Main {
	public static void main(String[] args) {
		BST t = new BST();
		int size = 7;
		int a[] = {4,2,6,1,3,5,7};
		
		System.out.println("Inserting...");
		for(int i = 0; i < size; i++) {
			System.out.println(a[i]);
		    t.insert(a[i]);
		}
		t.updatePos();
		t.updateDepth();
		t.updateHeight();
		
		System.out.println("BST...");
		t.preorder();
		t.inorder();
		t.postorder();
		t.printHeight();
		t.printDepth();
		t.printPos();
//		t.remove(4);
		t.display();
	}
}
