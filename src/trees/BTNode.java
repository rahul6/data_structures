package trees;

public class BTNode<E> implements BTPosition<E> {

	private E element; // represents the element stored at this node
	
	private BTPosition<E> left , right , parent ;
	
	
	  /** Default constructor */
	  public BTNode() { }
	
	  /** Main constructor */
	  public BTNode(E element, BTPosition<E> parent, 
			  BTPosition<E> left, BTPosition<E> right) { 
		  setElement(element);
		  setParent(parent);
		  setLeft(left);
		  setRight(right);
	  }	
	

	@Override
	public E element() {
		return element;
	}

	@Override
	public void setElement(E o) {
		element = o;		
	}

	@Override
	public BTPosition<E> getLeft() {
		
		return left;
	}

	@Override
	public BTPosition<E> getRight() {
		
		return right;
	}

	@Override
	public BTPosition<E> getParent() {
		
		return parent;
	}

	@Override
	public void setLeft(BTPosition<E> v) {
		
		left = v;	
	}

	@Override
	public void setRight(BTPosition<E> v) {

		right = v;			
	}

	@Override
	public void setParent(BTPosition<E> v) {
		
		parent = v;
	}

}
