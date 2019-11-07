package exercise;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComponent;
import exercise.PieDrawing;

/**
 * PanelDisplay for keeping and displaying score and hint
 *
 * @author ypchui
 */
public class PanelDisplay {

    private JFrame window;
    private PieDrawing hintFigure;
    private JLabel scoreLabel;
    private int score;

    public PanelDisplay() {
        score = 0;

        window = new JFrame("Panel");

        JLabel scoreTitle = new JLabel("<html><h1 style='color:red;'>Score</h1></html>");
        scoreTitle.setBounds(20, 0, 150, 100);
        window.getContentPane().add(scoreTitle);

        scoreLabel = new JLabel("<html><h2 style='color:blue;'>" + score + " / 10" + "</h2></html>");
        scoreLabel.setBounds(200, 0, 100, 100);
        window.getContentPane().add(scoreLabel);

        hintFigure = new PieDrawing(0, 1, ' ', 0, 1);
        hintFigure.setBounds(200, 100, 300, 100);
        window.getContentPane().add(hintFigure);
        this.updateHints(0, 2, ' ', 0, 4);

        window.setSize(515, 300);
        window.setLocation(50, 20);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int newScore) {
        System.out.println(this.getClass().getSimpleName() + " instance method setScore(" + newScore + ")");
        score = newScore;
        scoreLabel.setText("<html><h2 style='color:blue;'>" + score + " / 10" + "</h2></html>");
    }

    public void updateHints(int a, int b, char op, int c, int d) {
        System.out.println(this.getClass().getSimpleName() + " instance method updateHints( ... )");
        PieDrawing hintFigureOld = hintFigure;

        hintFigure = new PieDrawing(a, b, op, c, d);
        hintFigure.setBounds(200, 100, 300, 100);
        window.getContentPane().add(hintFigure);
        window.getContentPane().remove(hintFigureOld);

        window.revalidate();
        window.repaint();
    }
}