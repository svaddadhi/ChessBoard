/**
 * Seshasai Vishal Vaddadhi
 * Prof: Sheldon Finklestein
 * CMPS12B
 * HW2
 */
public class Queen extends ChessPiece {
	public Queen(int column, int row, int color){
		this.row = row;
		this.column = column;
		this.color = color;
		piece = 'q';
		
	}

	public boolean isAttacking(ChessPiece p){
		if(columnAttack(p)){
			return true;
		}
		if(rowAttack(p)){
			return true;
		}
		if(diagonalAttack(p)){
			return true;
		}
		return false;
		
	}
	
	

}
