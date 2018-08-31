/**
 * Seshasai Vishal Vaddadhi
 * Prof: Sheldon Finklestein
 * CMPS12B
 * HW2
 */
public class Bishop extends ChessPiece {
	public Bishop(int column, int row, int color){
		this.row = row;
		this.column = column;
		this.color = color;
		piece = 'b';
	}
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
	
	public boolean isAttacking(ChessPiece p){
		if(diagonalAttack(p)){
			return true;
		}
		return false;
		
	}


}
