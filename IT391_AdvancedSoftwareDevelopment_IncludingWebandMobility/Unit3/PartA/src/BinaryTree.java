public class BinaryTree {
  Node root;
  	BinaryTree(){
  		root = null;
  }

  static class Node{
    int value;
    Node left;
    Node right;
    Node(int value){
      this.value = value;
      left = null;
      right = null;        
    }
    public void displayData(){
      System.out.print(value + " ");
    }
  }
  
  public Node insert(Node node, int value){
	  if(node == null){
	     return new Node(value);
	  }
	    
	  if(value < node.value){
	      node.left = insert(node.left, value);
	  }
	    
	  else if(value > node.value){
	      node.right = insert(node.right, value);
	  }
	  return node;
  }
    
  public void insert(int i){
    root = insert(root, i);
  }
    
  public void inOrder(Node node){
    if(node != null){
      inOrder(node.left);
      node.displayData();
      inOrder(node.right);
    }
  }
}