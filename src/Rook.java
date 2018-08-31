/**
 * Seshasai Vishal Vaddadhi
 * Prof: Sheldon Finklestein
 * CMPS12B
 * HW2
 */
public class Rook extends ChessPiece {
	public Rook(int column, int row, int color){
		this.row = row;
		this.column = column;
		this.color = color;
		piece = 'r';
	}
	
	public boolean columnAttack(ChessPiece cp){
		if(column == cp.column ){
			return true;
		}
		return false;
	}
	
	public boolean rowAttack(ChessPiece cp){
		if(row == cp.row ){
			return true;
		}
		return false;
	}
	
	public boolean isAttacking(ChessPiece p){
		if(columnAttack(p)){
			return true;
		}
		if(rowAttack(p)){
			return true;
		}
		return false;
		
	}

}
