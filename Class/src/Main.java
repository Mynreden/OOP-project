public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(5 ,3,5);

        System.out.println("Triangle perimeter with parameters " + triangle.getA()  + ", " + triangle.getB()+ ", " + triangle.getC() + " is " + triangle.getPerimeter());
    }
}