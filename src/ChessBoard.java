/**
 * Seshasai Vishal Vaddadhi
 * Prof: Sheldon Finklestein
 * CMPS12B
 * HW2
 */
import java.io.*;
import java.util.Scanner;

public class ChessBoard{
	
	public static char typeOfPiece;
	public static int teamColor;
	public static int queryColumn;
	public static int queryRow;
	
	public static LinkedList pieces = new LinkedList();
	
	
	
	
	public static void main(String[] args) throws IOException{
	if(args.length < 2){
		 System.out.println("Usage: java –jar ChessBoard.jar <input file> <output file>");
		 System.exit(1);
	}
		 Scanner in = new Scanner(new File(args[0]));
		 PrintWriter out = new PrintWriter(new File(args[1]));
		 
		 while( in.hasNextLine() ){
			 // trim leading and trailing spaces, then add one trailing space so
			 // split works on blank lines
			 String line = in.nextLine().trim();
			 
			 String[] tokens = line.split("\\s+"); 
			 
			 if(tokens[1].length() < 2){//this if statement takes care of checking the colon after the first
				 						//two coordinates in the input file, or just an invalid input
				 out.println("Invalid "); continue;
			 	}
			 tokens[1] = Character.toString(tokens[1].charAt(0));
			 checkPieces(tokens);
			 if(verifyBoard()){
			 }
			 else{
				 out.println("Invalid");
				 pieces.head = null;
				 continue;
			 }
			 if(findPiece(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]))){
				 if(teamColor == 0){// we set black to 0 so if the piece is black it will print the char in
					 				//uppercase
					 out.print(Character.toUpperCase(typeOfPiece));
				 }
				 else{
					 out.print(typeOfPiece);
				 }
				 if(isUnderAttack()){//once the piece is found if it is attacking then print y
					 out.println(" y");
					 pieces.head = null;
				 }
				 else{
					 out.println(" n");//if not then print n
					 pieces.head = null;
				 }
			 }
			 else{
				 out.println("-");
				 pieces.head = null;
			 }
		 }
		in.close();
		out.close();
	}
	/**
	 * This method is used to check if the piece we found is attacking any other piece 
	 * given in the input. 
	 * @return
	 */
	
	public static boolean isUnderAttack(){
		//created a new current object to use to go through the linked list to 
		//check for the attacking pieces
		Node curr = new Node();
		curr = pieces.head;
		ChessPiece query;
		switch(typeOfPiece){
		
		//used the switch case from the check piece method and modified it to take in 
		//query objects of the different pieces.
		case 'q': query = new Queen((queryColumn), (queryRow), 1);
		break;
		case 'k': query = new King((queryColumn), (queryRow), 1);
		
		break;
		case 'b': query = new Bishop((queryColumn), (queryRow), 1);
		
		break;
		case 'r': query = new Rook((queryColumn), (queryRow), 1);
		
		break;
		case 'Q': query = new Queen((queryColumn), (queryRow), 0);
	
		break;
		case 'K': query = new King((queryColumn), (queryRow), 0);
		
		break;
		case 'B': query = new Bishop((queryColumn), (queryRow), 0);
		
		break;
		case 'R': query = new Rook((queryColumn), (queryRow), 0);
		break;
		
		default:
			query = new Rook((queryColumn), (queryRow), 0);
	}
		//we will keep going as long as curr isn't null, because if it equal to null
		//then we recahed the end of the list
		while(curr != null){
			if(query.column == curr.cp.column && query.row == curr.cp.row){
				curr = curr.next;
				continue;
			}
			//utilizing the siwtch case we are calling the attacking method for the 
			//piece that curr is pointing to
			if(query.isAttacking(curr.cp)){
				if(teamColor != curr.cp.color){ //if the team colors are different and the piece is attacking then
												//we know that the piece is being attacked
					return true;
				}
			}
			curr = curr.next;
		}
		return false;
	}
	
	
	public static boolean findPiece(int column, int row ){
		Node curr = new Node();//starting a new searching pointer
		curr = pieces.head;//Initializing it to the beginning of the linked list
		while(curr != null){ //conditional for checking if the curr has gotten to the end of the list or not
			if(curr.cp.column == column && curr.cp.row == row){ //checking if the curr piece is at the coordinates given
				teamColor = curr.cp.color;
				if(teamColor == 0){
					typeOfPiece = Character.toUpperCase(curr.cp.piece);
				}
				else{
				typeOfPiece = curr.cp.piece;
				}
				queryColumn = curr.cp.column;
				queryRow = curr.cp.row;
				return true;
			}
			else{
				curr = curr.next;//if it doesn't equal to the coordinates then go on to the next piece
			}
		}
		return false;
		
	}
	/**
	 * This method is used to verify if we have two of the same pieces on the same square
	 * @return
	 */
	public static boolean verifyBoard(){
		int i =0;
		Node curr1 = new Node();//using two curr's to run through the list and check the pieces
		Node curr2 = new Node();
		curr1 = moveCurrTo(i);
		curr2 = moveCurrTo(i+1);
		while(curr1.next != null){//if curr1 is equal to null that means we reached the end of the list
			while(curr2 != null){//if curr2 reaches null we move up curr1 by one and start comparing using
								 // curr2
				//if it is equal to the coordinates given then we are going to break out of the loop
				if(curr1.cp.column == curr2.cp.column && curr1.cp.row == curr2.cp.row){//
					return false;
				}
				else{
					curr2 = curr2.next;//if not then we are going to 
				}
			}
			i++;
			curr1 = moveCurrTo(i);//then we move curr1 up one as the new "head"
			curr2 = moveCurrTo(i+1);//move curr2 up one and then compare all of them with the new curr1
		}
		return true;
		
	}
	
	/**
	 * This method is used to run moved through the linked list
	 * @param m
	 * @return
	 */
	public static Node moveCurrTo(int n){
		Node curr = new Node();
		curr = pieces.head;
		for(int i = 0; i < n; i++){
			curr = curr.next;
		}
		return curr;
	}
	/**
	 * This method us used to check the pieces as well as insert them
	 * @param tokens
	 */
	public static void checkPieces(String[] tokens){
		// black = 0, white = 1
		for(int i = 2; i < tokens.length; i+=3){//for loop goes through input given, every other number since 
												// its a letter then number number letter
			switch(tokens[i]){
				case "q": Queen q = new Queen(Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2]), 1);
				pieces.insert(q);
				break;
				case "k": King k = new King(Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2]), 1);
				pieces.insert(k);
				break;
				case "b": Bishop b = new Bishop(Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2]), 1);
				pieces.insert(b);
				break;
				case "r": Rook r = new Rook(Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2]), 1);
				pieces.insert(r);
				break;
				case "Q": Queen wq = new Queen(Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2]), 0);
				pieces.insert(wq);
				break;
				case "K": King wk = new King(Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2]), 0);
				pieces.insert(wk);
				break;
				case "B": Bishop wb = new Bishop(Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2]), 0);
				pieces.insert(wb);
				break;
				case "R": Rook wr = new Rook(Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2]), 0);
				pieces.insert(wr);
				break;
			}
		}
	}
}
