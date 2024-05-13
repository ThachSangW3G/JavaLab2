package bai11;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.Random;

public class bai11 extends JPanel {
    private static final int NUM_STARS = 20;
    private static final int CIRCLE_RADIUS = 200;

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        Random rand = new Random();

        for (int i = 0; i < NUM_STARS; i++) {
            double angle = 2 * Math.PI * i / NUM_STARS;
            int x = centerX + (int) (CIRCLE_RADIUS * Math.cos(angle));
            int y = centerY + (int) (CIRCLE_RADIUS * Math.sin(angle));
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            g.setColor(color);
            g.fill(createStar( x, y,30, 80,5,0));
        }
    }

    private static Shape createStar(double centerX, double centerY,
                                    double innerRadius, double outerRadius, int numRays,
                                    double startAngleRad)
    {
        Path2D path = new Path2D.Double();
        double deltaAngleRad = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++)
        {
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0)
            {
                relX *= outerRadius;
                relY *= outerRadius;
            }
            else
            {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0)
            {
                path.moveTo(centerX + relX, centerY + relY);
            }
            else
            {
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Star Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new bai11());
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
