import java.sql.SQLOutput;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;

public class Shape {
    private ArrayList<Point> points = new ArrayList<>();

    public void addPoints(Point point) { points.add(point);
    }

    public double calculatePerimeter() {
        double sum = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            sum += points.get(i).distance(points.get(i).getX(), points.get(i + 1).getX(), points.get(i).getY(), points.get(i + 1).getY());
        }
        sum += points.get(0).distance(points.get(0).getX(), points.get(points.size() - 1).getX(), points.get(0).getY(), points.get(points.size() - 1).getY());
        return sum;
    }

    public double Averagelength() {
        double Averagelength = calculatePerimeter() / points.size();
        return Averagelength;
    }

    public double MaxLength() {
        double max = points.get(0).distance(points.get(0).getX(), points.get(1).getX(), points.get(0).getY(), points.get(1).getY());
        for (int i = 1; i < points.size()-1; i++) {
            if (max < points.get(i).distance(points.get(i).getX(), points.get(i + 1).getX(), points.get(i).getY(), points.get(i + 1).getY())) {
                max = points.get(i).distance(points.get(i).getX(), points.get(i + 1).getX(), points.get(i).getY(), points.get(i + 1).getY());
            }
        }
        return max;
    }
    public String getPoints(){
        int[][] getPoints = new int[points.size()][2];
        for (int i = 0; i < points.size(); i++) {
                getPoints[i][0] = points.get(i).getX();
                getPoints[i][1] = points.get(i).getY();
        }
        return Arrays.deepToString(getPoints);
    }
}




