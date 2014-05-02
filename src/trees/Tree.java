package trees;

public interface Tree<E> {

	// Give the no. of nodes in the tree
	public int size();
	
	// Check if Tree is empty
	public boolean isEmpty();

	// Returns the root of the tree. 
	public Position<E> root() throws EmptyTreeException;
	
	// Returns the parent of a given node.
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException;

	// Returns whether a given node is the root of the tree. 
	public boolean isRoot(Position<E> v) throws InvalidPositionException;
	
}


