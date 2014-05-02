package trees;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedBinaryTree<E> implements BinaryTree<E>{

	protected static LinkedList ll;
	protected static LinkedList pl;
	protected static int arrayPos = 0;
	protected static int arraySize = 0;
	protected BTPosition<E> root;	// reference to the root

	protected int size;		// number of nodes

	//  Creates an empty binary tree.
	public LinkedBinaryTree() { 		    
	root = null;  // start with an empty tree
	size = 0;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
				
		  BTPosition left = null;
		  BTPosition right = null;
		  		  
		  ll = new LinkedList(); // to fill the tree in BF way
		  pl = new LinkedList(); // to print the tree in BF way
		  
		  LinkedBinaryTree bt = new LinkedBinaryTree();
		  
		  Scanner sc =  new Scanner(System.in);
		  
		  System.out.println("Binay Tree Initialized \n");	  
		  System.out.println("Enter the no. of nodes you want to create in the tree: \n");
		 
		  arraySize = sc.nextInt() ;		  
		  int[] treeElement = new int[arraySize];	  
		  
		  for(int i = 0 ; i < arraySize ; i++ ){
			  System.out.println("Enter the integer value to be stored at the nodes - "+i+" \n");
			  treeElement[i] = sc.nextInt();
		  }
		  		  		
		  bt.constructTree(bt , treeElement);
		  	 
	}
	
	  public void printTree(LinkedList pl , LinkedBinaryTree bt , BTPosition<E> pos)
			    throws InvalidPositionException {
		  	  
		  if(pos.element() != null){		  	  
			  if(pos.getParent() == null){
				  System.out.println("Root element is " + pos.element());
			  } else {
				  System.out.println("Element = " +pos.element()+ " --> Parent  = "+ pos.getParent().element());	  
			  
			  }
		  }  
		  
		  if(bt.hasLeft(pos)){
			  pl.add(pos.getLeft()); 
		  }
		  if(bt.hasRight(pos)){
			  pl.add(pos.getRight()); 
		  }
		   
		  if(!pl.isEmpty()){
			  BTPosition<E> nextpos = (BTPosition<E>)pl.poll();	
			  printTree(pl , bt, nextpos);
		  }
	  }		
	
	  public void constructTree(LinkedBinaryTree bt, int[]  treeElement)
	    throws InvalidPositionException {
		  
		  try{
			  bt.root(); 			  
		  } catch(EmptyTreeException e){
			  bt.addRoot(treeElement[arrayPos]);
			  arrayPos ++;			  
			  ll.add(bt.insertLeft(bt.root, treeElement[arrayPos]));
			  arrayPos ++;
			  ll.add(bt.insertRight(bt.root, treeElement[arrayPos]));
			  arrayPos ++;
			  while(arrayPos < arraySize){
				  fillTree(this, treeElement);
			  }	
			  
			  printTree(pl , bt, bt.root);
		  }
	  }		
	  
		public void fillTree(LinkedBinaryTree bt , int[]  treeElement) {
			
		  	BTNode<E> ee = (BTNode<E>)ll.poll();		  	
		  	BTPosition<E> ln = bt.createNode(treeElement[arrayPos], ee, null, null);
		  	arrayPos ++;
		  	BTPosition<E> rn = bt.createNode(treeElement[arrayPos], ee, null, null);
		  	arrayPos ++;
			
		  	ll.add(ln);
		  	ll.add(rn);
		  	
		  	ee.setLeft(ln);		  	
		  	ee.setRight(rn);
		}	
			 	
	  // Adds a root node to an empty tree 
	  public Position<E> addRoot(E e) {
	    if(!isEmpty())
	      System.out.println("Tree already has a root");
	    size = 1;
	    root = createNode(e,null,null,null);
	    return root;
	  }	
	
	 // Create a new Node
	  protected BTPosition<E> createNode(E element, BTPosition<E> parent, 
					  BTPosition<E> left, BTPosition<E> right) {
	    return new BTNode<E>(element,parent,left,right); 
	    }
	  
	  
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0); 
	}

	protected BTPosition<E> checkPosition(Position<E> v) 
	throws InvalidPositionException {
		if (v == null || !(v instanceof BTPosition))
		throw new InvalidPositionException("The position is invalid");
		return (BTPosition<E>) v;
	}

	  // Return the left child of a node
	@Override
	public Position<E> left(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {

	    BTPosition<E> vv = checkPosition(v);
	    Position<E> leftPos = vv.getLeft();
	    if (leftPos == null)
	      throw new BoundaryViolationException("No left child");
	    return leftPos;		
			
	}

	// Return the right child of a node
	@Override
	public Position<E> right(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {

	    BTPosition<E> vv = checkPosition(v);
	    Position<E> rightPos = vv.getRight();
	    if (rightPos == null)
	      throw new BoundaryViolationException("No right child");
	    return rightPos;
		
	}

	 // Returns if a node has a left child.
	@Override
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
	    BTPosition<E> vv = checkPosition(v);
	    return (vv.getLeft() != null);
	}

	 // Returns if a node has a left child.
	@Override
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
	    BTPosition<E> vv = checkPosition(v);
	    return (vv.getRight() != null);
	}

	@Override
	public Position<E> root() throws EmptyTreeException {
	    if (root == null)
	        throw new EmptyTreeException("The tree is empty");
	      return root;
	}

	@Override
	public Position<E> parent(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		
	        BTPosition<E> vv = checkPosition(v);
	        Position<E> parentPos = vv.getParent();
	        if (parentPos == null)
	          throw new BoundaryViolationException("No parent");
	        return parentPos; 
	}

	@Override
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
	    checkPosition(v);
	    return (v == root()); 
	}
	
	  // Inserts a left child at a given node.
	
	  public Position<E>  insertLeft(Position<E> v, E e)
	    throws InvalidPositionException {
	    BTPosition<E> vv = checkPosition(v);
	    Position<E> leftPos = vv.getLeft();
	    if (leftPos != null)
	      throw new InvalidPositionException("Node already has a left child");
	    BTPosition<E> leftNode = createNode(e, vv, null, null);
	    vv.setLeft(leftNode);
	    size++;
	    return leftNode;
	  }

	  // Inserts a right child at a given node.
	  
	  public Position<E>  insertRight(Position<E> v, E e)
	    throws InvalidPositionException {
	    BTPosition<E> vv = checkPosition(v);
	    Position<E> rightPos = vv.getRight();
	    if (rightPos != null)
	      throw new InvalidPositionException("Node already has a right child");
	    BTPosition<E> rightNode = createNode(e, vv, null, null);
	    vv.setRight(rightNode);
	    size++;
	    return rightNode;
	  }	
	

}
