import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private Component canvas;
    private JLabel score;
    private static final int POCKET_SIZE = 30;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private final Color color;
    private final boolean priorityTest;


    public Ball(Component c, JLabel score, boolean priorityTest, Color color) {
        this.canvas = c;
        this.score = score;
        this.color = color;
        this.priorityTest = priorityTest;

        if (priorityTest) {
            x = 50;
            y = 50;
        } else if (Math.random() < 0.5) {
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        } else {
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public static void f() {
        int a = 0;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));

    }

    public boolean move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
        if (isInPocket() && !priorityTest) {
            ((BallCanvas)this.canvas).remove(this);
            this.canvas.repaint();
            Score.score += 1;
            score.setText("Score: " + Score.score);
            return true;
        }
        return false;
    }

    public boolean isInPocket() {
        if (x <= (POCKET_SIZE - XSIZE)) {
            if (y <= (POCKET_SIZE - YSIZE) || y >= (this.canvas.getHeight() - POCKET_SIZE)) {
                return true;
            }
        }
        if (x >= (this.canvas.getWidth() - POCKET_SIZE) && y >= (this.canvas.getHeight() - POCKET_SIZE)) {
            if (y >= (this.canvas.getHeight() - POCKET_SIZE) || y <= (POCKET_SIZE - YSIZE)) {
                return true;
            }
        }
        return false;
    }
}
