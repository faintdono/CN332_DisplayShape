import org.beryx.awt.color.ColorFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class drawingCanvas extends JComponent {

    ArrayList<Shape> shapeObj;

    public drawingCanvas(ArrayList<Shape> shapeObj) {
        this.shapeObj = shapeObj;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < shapeObj.size(); i++) {

            if (shapeObj.get(i).toString().equals("Square")) {
                Square square = (Square) shapeObj.get(i);
                Rectangle2D.Double s = new Rectangle2D.Double(
                        square.getX() * 50,
                        square.getY() * 50,
                        square.getWidth() * 5,
                        square.getWidth() * 5);

                // parameter in dataframe are too low need to multiply it to show that code can
                // work perfectly

                Color c = ColorFactory.valueOf(square.getColor());
                g2d.setColor(c);
                g2d.fill(s);

            } else if (shapeObj.get(i).toString().equals("Circle")) {
                Circle circle = (Circle) shapeObj.get(i);
                Ellipse2D.Double e = new Ellipse2D.Double(
                        circle.getX() * 50,
                        circle.getY() * 50,
                        circle.getRadius() * 5,
                        circle.getRadius() * 5);

                // parameter in dataframe are too low need to multiply it to show that code can
                // work perfectly

                Color c = ColorFactory.valueOf(circle.getColor());
                g2d.setColor(c);
                g2d.fill(e);

            } else if (shapeObj.get(i).toString().equals("Rectangle")) {
                Rectangle rectangle = (Rectangle) shapeObj.get(i);
                Rectangle2D.Double r = new Rectangle2D.Double(
                        rectangle.getX() * 1,
                        rectangle.getY() * 1,
                        rectangle.getWidth() * 5,
                        rectangle.getHeight() * 5);

                // parameter in dataframe are too low need to multiply it to show that code can
                // work perfectly

                Color c = ColorFactory.valueOf(rectangle.getColor());
                g2d.setColor(c);
                g2d.fill(r);

            } else if (shapeObj.get(i).toString().equals("Triangle")) {
                Triangle t = (Triangle) shapeObj.get(i);
                Path2D.Double p = new Path2D.Double();
                p.moveTo((t.getp1_x() + t.getX()) * 6, (t.getp1_y() + t.getY()) * 6);
                p.lineTo((t.getp2_x() + t.getX()) * 6, (t.getp2_y() + t.getY()) * 6);
                p.lineTo((t.getp3_x() + t.getX()) * 6, (t.getp3_y() + t.getY()) * 6);
                p.closePath();

                // parameter in dataframe are too low need to multiply it to show that code can
                // work perfectly

                Color c = ColorFactory.valueOf("BLACK");
                g2d.setColor(c);
                g2d.fill(p);
            }
        }
    }
}
