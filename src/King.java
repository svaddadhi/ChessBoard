/**
 * Seshasai Vishal Vaddadhi
 * Prof: Sheldon Finklestein
 * CMPS12B
 * HW2
 */
public class King extends ChessPiece {
	public King(int column, int row, int color){
		this.row = row;
		this.column = column;
		this.color = color;
		piece = 'k';
	}
	
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
	
	public boolean isAttacking(ChessPiece p){
		if(singleAttack(p)){
			return true;
		}
		return false;
	}

}
