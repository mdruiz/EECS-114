
public class BST {
	private static class BinaryNode {
		private int height;
		private int depth;
		private int inorder_pos;
		private int value;
	    private BinaryNode left;
	    private BinaryNode right;
	    
	    public BinaryNode(int newVal) {
	    	this.value = newVal;
	    	this.height = 0;
	    	this.depth = 0;
	    	this.inorder_pos = 0;
	    	
	    }
	     
	    private static BinaryNode insert(int value, BinaryNode t) {
	       // Your Implementation here. See course slides Lecture 7
	    	if (t == null){
	    		 t = new BinaryNode(value);
	    		 return t;
	    	}
	    	else if (value < t.value){
	    		t.left = insert(value , t.left);
	    	}
	    	else if (value > t.value){
	    		t.right = insert(value, t.right);
	    	}
	    	
	    	return t;
	   
	    }
	    
	    private static BinaryNode remove(int value, BinaryNode t) {
	      // Your Implementation here. See course slides Lecture 7
	    	
	    	return  null;
	    }
	    
	    private static void display(BinaryNode t) {
	      // Your Implementation here
	    	if(t != null){
	    		display(t.right);
	    		for(int i=0;i<t.depth; i++){
	    			System.out.print("  ");
	    		}
	    		System.out.println(t.value +" ");
	    		display(t.left);
	    	}
	    }
	    
	    private static void inorder(BinaryNode node){
	    	if(node != null){
	    		inorder(node.left);
	    		System.out.print(node.value +" ");
	    		inorder(node.right);
	    	}
	    }
	    
	    private static void postorder(BinaryNode node){
	    	if(node != null){
	    		postorder(node.left);
	    		postorder(node.right);
	    		System.out.print(node.value +" ");
	    	}
		}
	    
	    private static void preorder(BinaryNode node){
	    	if(node != null){
	    		System.out.print(node.value +" ");
	    		preorder(node.left);
	    		preorder(node.right);
	    	}
	    }  

	    private static void updateHeight(BinaryNode node){
	    	if(node != null){
	    		node.height = curr_height;
				curr_height --;
	    		updateHeight(node.left);
	    		updateHeight(node.right);
				curr_height ++;
	    	}
		}
		
		private static void updateDepth(BinaryNode node){
			if(node != null){
				node.depth = curr_depth;
				curr_depth ++;
	    		updateDepth(node.left);
	    		updateDepth(node.right);
	    		curr_depth --;
	    	}
			if (max_depth < curr_depth){
				max_depth = curr_depth;
			}
		}
		
		private static void updatePos(BinaryNode node){
			if(node != null){
	    		updatePos(node.left);
	    		node.inorder_pos = curr_pos++;
	    		updatePos(node.right);
	    	}
		}
		
		private static void printHeight(BinaryNode node){
			if(node != null){
	    		printHeight(node.left);
	    		System.out.println("Key: "+node.value+"	Height: "+node.height);
	    		printHeight(node.right);
	    	}
		}
		
		private static void printDepth(BinaryNode node){
			if(node != null){
	    		printDepth(node.left);
	    		System.out.println("Key: "+node.value+"	Depth: "+node.depth);
	    		printDepth(node.right);
	    	}
		}
		
		private static void printPos(BinaryNode node){
			if(node != null){
	    		printPos(node.left);
	    		System.out.println("Key: "+node.value+"	Inorder Position: "+node.inorder_pos);
	    		printPos(node.right);
	    	}
		}
	} // end of BinaryNode class
	   
	private static int curr_depth;
	private static int curr_pos;
	private static int curr_height;
	private static int max_depth;
	private BinaryNode root = null;
	   
	public void insert(int value) { 
		root = BinaryNode.insert(value, root);	
	}
	   
	public void remove(int value) {
		root = BinaryNode.remove(value, root);
	}
	   
	public void display() { 
		System.out.println("Printing BST tree ...");
		BinaryNode.display(root); 
	}
	
	public void inorder(){
		System.out.print("Inorder traversal: ");
		BinaryNode.inorder(root);
		System.out.println();
	}
	
	public void postorder(){
		System.out.print("Postorder traversal: ");
		BinaryNode.postorder(root);
		System.out.println();
	}
	
	public void preorder(){
		System.out.print("Preorder traversal: ");
		BinaryNode.preorder(root);
		System.out.println();
	}
	
	public void updateHeight(){
		curr_height = max_depth -1;
		BinaryNode.updateHeight(root);
	}
	
	public void updateDepth(){
		curr_depth = 0;
		BinaryNode.updateDepth(root);
	}
	
	public void updatePos(){
		curr_pos = 1;
		BinaryNode.updatePos(root);
	}
	
	public void printHeight(){
		System.out.println("Printing height: ");
		BinaryNode.printHeight(root);
	}
	
	public void printDepth(){
		System.out.println("Printing depth: ");
		BinaryNode.printDepth(root);
	}
	
	public void printPos(){
		System.out.println("Printing inorder position: ");
		BinaryNode.printPos(root);
	}

}
