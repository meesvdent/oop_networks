package drawIt;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @invar | getNeighbors().stream().allMatch(neighbor -> neighbor != null && neighbor.getNeighbors().contains(this))
 * @invar | getNeighbors() != null
 */
public class Node {
	
	/**
	 * @invar | getNeighbors().stream().allMatch(neighbor -> neighbor != null && neighbor.getNeighbors().contains(this))
	 * @invar | getNeighbors() != null
	 * @representationObject
	 * @peerObject
	 */
	HashSet<Node> neighbors;

	/**
	 * @post | this.getNeighbors().isEmpty()
	 */
	public Node() {
		this.neighbors = new HashSet<Node>();
	}
	
	/**
	 * @throws IllegalArgumentException | neighbor == null
	 * @mutates | this
	 * @post | this.getNeighbors().contains(neighbor) && neighbor.getNeighbors().contains(this)
	 */
	public void addNeighbors(Node neighbor) {
		if(neighbor == null) {
			throw new IllegalArgumentException("neighbor is null");
		} 
		this.neighbors.add(neighbor);
		neighbor.addNeighbors(this);
	}
	
	public Set<Node> getNeighbors(){
		return Set.copyOf(this.neighbors);
	}
	
	
	public void removeNeighbor(Node neighbor) {
		this.neighbors.remove(neighbor);
		neighbor.removeNeighbor(this);
	}
	
	

}
