import javax.swing.*;


public class GameOfLife extends JFrame {
    private BoardPanel boardPanel;
    private JPanel panelMain;

    public GameOfLife() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        boardPanel = new BoardPanel();
        JScrollPane scrollPane = new JScrollPane(boardPanel);
        add(scrollPane);


        new Timer(1000, e -> game()).start();

        setVisible(true);
    }

    void game() {
        BoardPanel old = new BoardPanel(boardPanel);
        for (int i = 0; i < BoardPanel.rows; i++) {
            for (int j = 0; j < BoardPanel.cols; j++) {
                int neighCount = old.countNeighbors(i, j);
                if (old.grid[i][j].status) {
                    if (neighCount != 2 && neighCount != 3) {
                        boardPanel.grid[i][j].changeStatus();
                    }
                } else {
                    if (neighCount == 3) {
                        boardPanel.grid[i][j].changeStatus();
                    }
                }
            }
        }
        boardPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameOfLife::new);
    }
}
