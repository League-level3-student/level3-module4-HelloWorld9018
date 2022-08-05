package _04_Maze_Maker;
import java.awt.Graphics;

public class Maze {
    // 1. Create a 2D array of cells. Don't initialize it.
    Cell[][] myCells;
    private int rows;
    private int cols;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        // 2. Initialize the cells array using the rows and cols variables
        myCells = new Cell[rows][cols];
        for(int r = 0; r< rows; r++) {
        	for(int c = 0; c< cols; c++)
        	myCells[r][c] = new Cell(r,c);
        }
        // 3. Iterate through each cell and initialize it
        //    using row and col as the cell location

    }

    // 4. This method iterates through the cells and draws them
    public void draw(Graphics g) {
    	 for(int r = 0; r< rows; r++) {
         	for(int c = 0; c< cols; c++)
         		myCells[r][c].draw(g);
         }
    }

    // 5. This method returns the selected cell
    public Cell getCell(int row, int col){
    	return myCells[row][col];
        
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
