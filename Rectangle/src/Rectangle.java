
    public class Rectangle {
        private double a;
        private double b;
        private double c;
        private double d;

        public Rectangle(double a, double b, double c, double d){
            this(); //calling no arg constructor
            setA(a);
            setA(b);
            setA(c);
            setD(d);
        }

        public Rectangle() {

        }

        public void setA(double a) {
            this.a = a;
        }
        public void setD(double d) {
            this.d = d;
        }
        public void setB(double b) {
            this.b = b;
        }
        public void setC(double c) {
            this.c = c;
        }
        public double getA() {
            return a;
        }

        public double getD() {
            return d;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }
        public double getPerimeter(){
            return (a+b+c+d);
        }
    }

