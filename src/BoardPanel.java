import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    static final int cols = 30;
    static final int rows = 20;
    public Cell[][] grid = new Cell[rows][cols];

    public BoardPanel() {
        setLayout(new GridLayout(rows, cols));
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = new Cell();
                add(grid[row][col]);
            }
        }
    }


    public BoardPanel(BoardPanel other) {
        setLayout(new GridLayout(rows, cols));
        this.grid = new Cell[other.grid.length][other.grid[0].length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.grid[row][col] = new Cell();
                this.grid[row][col].status = other.grid[row][col].status;
                add(this.grid[row][col]);
            }
        }
    }

    public int countNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int currRow = (row + i + rows) % rows;
                int currCol = (col + j + cols) % cols;
                if (grid[currRow][currCol].status) {
                    count++;
                }
            }
        }
        return count;
    }
}
