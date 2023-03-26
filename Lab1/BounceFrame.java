import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        final JLabel score = new JLabel("Score: " + Score.score);
        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");
        JButton buttonPriorityTest = new JButton("Priority Test");
        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Ball b = new Ball(canvas, score, false, Color.darkGray);
                canvas.add(b);

                BallThread thread = new BallThread(b);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });
        buttonPriorityTest.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Ball b;
                BallThread thread;

                for (int i = 0; i < 20; i++) {
                    b = new Ball(canvas, score, true, Color.cyan);
                    canvas.add(b);

                    thread = new BallThread(b);
                    thread.setPriority(Thread.MIN_PRIORITY);
                    thread.start();
                    System.out.println("Thread name = " +
                            thread.getName());
                }

                b = new Ball(canvas, score, true, Color.red);
                canvas.add(b);

                BallThread threadHigh = new BallThread(b);
                threadHigh.setPriority(Thread.MAX_PRIORITY);
                threadHigh.start();
                System.out.println("Thread name = " +
                        threadHigh.getName());
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        buttonPanel.add(buttonPriorityTest);
        buttonPanel.add(score);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
