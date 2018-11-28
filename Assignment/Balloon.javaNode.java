/**
 * A node in the BinaryTree. It contains a reference to a Aircraft object
 * associated with the node and references to the left and right Node objects
 * that are below the node. You do not need to modify this code at all.
 */

public class Node {

	private Aircraft	aircraft = null;	// The Aircraft stored at this node
	private Node	left = null;	// The left node of this node
	private Node	right = null;	// The right node of this node
	
	/**
	 * Default constructor that initialises the node with
	 * a Page associated with this node.
	 * 
	 * @param c	The content of the node
	 */
	public Node(Aircraft a)
	{
		aircraft = a;
	}
	
	/**
	 * Set the left reference of this node to 'n'
	 *  
	 * @param n	A reference to the new left node
	 */
	public void setLeft(Node n)
	{
		left = n;
	}
	
	/**
	 * Set the right reference of this node to 'n'
	 *  
	 * @param n	A reference to the new right node
	 */
	public void setRight(Node n)
	{
		right = n;
	}

	// Get properties of the node
	public Aircraft getAircraft() { return aircraft; }
	public String getAircraftName() { return aircraft.getName(); }
	public boolean hasLeft() { return left != null; }
	public boolean hasRight() { return right != null; }
	public Node left() { return left; }
	public Node right() { return right; }
	
	public int compareTo(Node pn) { return getAircraftName().compareTo(pn.getAircraftName()); }
	public String toString() { return getAircraftName(); }
	
}
