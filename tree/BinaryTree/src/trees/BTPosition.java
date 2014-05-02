package trees;

public interface BTPosition<E> extends Position<E> {
	
	// set element
	public void setElement(E o);
	
	// get the left node
	public BTPosition<E> getLeft(); 
	
	// get the right node
	public BTPosition<E> getRight(); 
	
	// get the parent node
	public BTPosition<E> getParent(); 
	
	// set the left node	
	public void setLeft(BTPosition<E> v);
	
	// set the right node
	
	public void setRight(BTPosition<E> v); 
	
	// set the parent node
	public void setParent(BTPosition<E> v);

}
