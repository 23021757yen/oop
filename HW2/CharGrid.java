// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int min_row=0;
        int max_row=0;
        int min_col=0;
        int max_col=0;
        boolean flag =false;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==ch) {
                    flag=true;
                    min_row=Math.min(min_row,i);
                    max_row=Math.max(max_row,i);
                    min_col=Math.min(min_col,j);
                    max_col=Math.max(max_col,j);
                }
            }
        }
        if(flag==false) {
            return 0;
        }
        else if(min_row==max_row && min_col==max_col) {
            return 1;
        }
        else if(min_row==max_row) {
            return max_col-min_col+1;
        }
        else if(min_col==max_col) {
            return max_row-min_row+1;
        }
        else if(min_row<max_row&&min_col<max_col) {
            return ((max_row-min_row)+1)*((max_col-min_col)+1);
        }
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     * @return number of + in grid
     */
    private boolean checkThap(int x, int y) {
        int armLength = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        int left = 0;

        while (x - armLength >= 0 && y - armLength >= 0
                && x + armLength < grid.length && y + armLength < grid[0].length) {
            if (grid[x + armLength][y] == grid[x][y]) {
                right++;
            }
            if (grid[x - armLength][y] == grid[x][y]) {
                left++;
            }
            if (grid[x][y + armLength] == grid[x][y]) {
                up++;
            }
            if (grid[x][y - armLength] == grid[x][y]) {
                down++;
            }
            if (right == left && left == up && up == down) {
                armLength++;
            } else {
                return false;
            }
        }
        if (x - armLength >= 0 && grid[x - armLength][y] == grid[x][y]) {
            return false;
        }
        if (x + armLength < grid.length && grid[x + armLength][y] == grid[x][y]) {
            return false;
        }
        if (y - armLength >= 0 && grid[x][y - armLength] == grid[x][y]) {
            return false;
        }
        if (y + armLength < grid[0].length && grid[x][y + armLength] == grid[x][y]) {
            return false;
        }
        return armLength > 1;
    }

    public int countPlus() {
        int count = 0;
        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[i].length;j++) {
                if(checkThap(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }


}
