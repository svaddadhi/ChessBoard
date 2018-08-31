/**
 * Seshasai Vishal Vaddadhi
 * Prof: Sheldon Finklestein
 * CMPS12B
 * HW2
 */
public class ChessPiece {
	public int row;
	public int column;
	public int color;
	public char piece;
	
	
	//overall diagonal method for the queen and bishop
	public boolean diagonalAttack(ChessPiece cp){
		if(downRightDiagonal(cp)){
			return true;
		}
		if(downLeftDiagonal(cp)){
			return true;
		}
		if(upLeftDiagonal(cp)){
			return true;
		}
		if(upRightDiagonal(cp)){
			return true;
		}
		return false;
	}
	
	
	public boolean downRightDiagonal(ChessPiece cp){
		int counter=0;
		int r=0;
		int c=0;
		while(counter <= 8){
			c++;
			r--;
			if(r + row == cp.row && c + column == cp.column) {
				return true;
			}
			else{
				counter ++;
			}
		}
		return false;
	}
	
	//column attack for the rook and queen
	public boolean columnAttack(ChessPiece cp){
		if(column == cp.column ){
			return true;
		}
		return false;
	}
	
	//row attack for the rook and queen
	public boolean rowAttack(ChessPiece cp){
		if(row == cp.row ){
			return true;
		}
		return false;
	}
	
	//single attack for the king piece 
	public boolean singleAttack(ChessPiece cp){
		if(row + 1 == cp.row && column + 1 == cp.column){
			return true;
		}
		if(row - 1 == cp.row && column - 1 == cp.column){
			return true;
		}
		if(row == cp.row && column + 1 == cp.column){
			return true;
		}
		if(row == cp.row && column - 1 == cp.column){
			return true;
		}
		if(row + 1 == cp.row && column == cp.column){
			return true;
		}
		if(row - 1 == cp.row && column == cp.column){
			return true;
		}
		if(row - 1 == cp.row && column + 1 == cp.column){
			return true;
		}
		if(row + 1 == cp.row && column - 1 == cp.column){
			return true;
		}
		return false;	
	}
	
	public boolean upLeftDiagonal(ChessPiece cp){
		int counter=0;
		int r=0;
		int c=0;
		while(counter <= 8){
			c--;
			r++;
			if(r + row == cp.row && c + column == cp.column) {
				return true;
			}
			else{
				counter ++;
			}
		}
		return false;
	}
	
	public boolean upRightDiagonal(ChessPiece cp){
		int counter=0;
		int r=0;
		int c=0;
		while(counter <= 8){
			c++;
			r++;
			if(r + row == cp.row && c + column == cp.column) {
				return true;
			}
			else{
				counter ++;
			}
		}
		return false;
	}
	
	public boolean downLeftDiagonal(ChessPiece cp){
		int counter=0;
		int r=0;
		int c=0;
		while(counter <= 8){
			c--;
			r--;
			if(r + row == cp.row && c + column == cp.column) {
				return true;
			}
			else{
				counter ++;
			}
		}
		return false;
	}
	
	public boolean isAttacking(ChessPiece p){
		return false;
	}
}
