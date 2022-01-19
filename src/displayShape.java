import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class displayShape {

    public static void main(String[] args) throws SQLException {

        connectionManager mariaDB = new connectionManager();
        ArrayList<String[]> dataArray = mariaDB.getqueryall();
        int dateArrayLength = dataArray.size();
        ArrayList<Shape> shapeObj = new ArrayList<Shape>();

        for (int i = 0; i < dateArrayLength; i++) {

            String[] data = dataArray.get(i);

            if (data[2].equals("square")) {
                String[] location = data[1].split(",");
                Double x = Double.parseDouble(location[0]);
                Double y = Double.parseDouble(location[1]);
                Double width = Double.parseDouble(data[3]);
                String color = data[6];
                Square s = new Square(width, x, y, color);
                shapeObj.add(s);

            } else if (data[2].equals("circle")) {
                String[] location = data[1].split(",");
                Double x = Double.parseDouble(location[0]);
                Double y = Double.parseDouble(location[1]);
                Double radius = Double.parseDouble(data[3]);
                String color = data[6];
                Circle c = new Circle(radius, x, y, color);
                shapeObj.add(c);

            } else if (data[2].equals("rectangle")) {
                String[] location = data[1].split(",");
                Double x = Double.parseDouble(location[0]);
                Double y = Double.parseDouble(location[1]);
                Double width = Double.parseDouble(data[3]);
                Double height = Double.parseDouble(data[4]);
                String color = data[6];
                Rectangle r = new Rectangle(width, height, x, y, color);
                shapeObj.add(r);

            } else if (data[2].equals("triangle")) {
                String[] location = data[1].split(",");
                Double x = Double.parseDouble(location[0]);
                Double y = Double.parseDouble(location[1]);
                String param1 = data[3];
                String param2 = data[4];
                String param3 = data[5];
                String color = data[6];
                Triangle t = new Triangle(param1, param2, param3, x, y, color);
                shapeObj.add(t);

            }
        }
        JFrame f = new JFrame();
        drawingCanvas dc = new drawingCanvas(shapeObj);
        f.setSize(1280, 720);
        f.setTitle("Drawing in JAVA");
        f.add(dc);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
