//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

import java.util.ArrayList;
import java.util.List;

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {

	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		List< boolean[]> newRows = new ArrayList< >();
		for(boolean[] row : grid){
			boolean flag =true;
			for(boolean c : row){
				if(c){
					flag = false;
					break;
				}
			}
			if(!flag){
				newRows.add(row);
			}
		}
		grid = new boolean [newRows.size()][];
		for(int i = 0; i < newRows.size(); i++){
			grid[i]= newRows.get(i);
		}
	}

	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; // YOUR CODE HERE
	}
}
