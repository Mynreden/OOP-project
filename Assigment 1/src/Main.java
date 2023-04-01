import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("C:/Users/kabdo/Documents/file1.txt.txt");
        Scanner sc1 = new Scanner(file1);
        File file2= new File("C:/Users/kabdo/Documents/file2.txt.txt");
        Scanner sc2 = new Scanner(file2);
        int x, y;
        Point points1 = new Point();
        Point points2 = new Point();
        Shape shape1 = new Shape();
        Shape shape2 = new Shape();
        while (sc1.hasNextInt()) {
            x = sc1.nextInt();
            y = sc1.nextInt();
            points1.setX(x);
            points1.setY(y);
            shape1.addPoints(points1);
            points1 = new Point();

        }
        System.out.println("Perimeter1" +": " + shape1.calculatePerimeter());
        System.out.println("Averagelength1: " + shape1.Averagelength());
        System.out.println("MaxLength1:"+ shape1.MaxLength());
        System.out.println(shape1.getPoints());
        while (sc2.hasNextInt()) {
            x = sc2.nextInt();
            y = sc2.nextInt();
            points2.setX(x);
            points2.setY(y);
            shape2.addPoints(points2);
            points2 = new Point();

        }
        System.out.println("Perimeter2" + ": " + shape2.calculatePerimeter());
        System.out.println("Averagelength2"  + ": " + shape2.Averagelength());
        System.out.println("MaxLength2:"+ shape2.MaxLength());
        System.out.println(shape2.getPoints());
    }
}


