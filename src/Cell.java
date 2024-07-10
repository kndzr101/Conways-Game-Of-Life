import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Cell extends JPanel {
    public boolean status;

    public Cell() {
        Random rand = new Random();
        this.status = rand.nextBoolean();
    }

    public void changeStatus() {
        this.status = !this.status;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = Math.min(getWidth(), getHeight()) - 2;

        g.setColor(Color.YELLOW);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        if (status) {
            g.setColor(Color.BLACK);
            g.fillRect(1, 1, size, size);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(1, 1, size, size);
        }
    }
}
