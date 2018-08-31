/**
 * Seshasai Vishal Vaddadhi
 * Prof: Sheldon Finklestein
 * CMPS12B
 * HW2
 */
public class LinkedList {
	public Node head;
	
	public LinkedList(){
		head = null;
	}
	
	public void insert(ChessPiece cp){
		Node latest = new Node(cp);
		latest.next = head;
		head = latest;
	}
}
