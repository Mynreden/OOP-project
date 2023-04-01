public class Point {
    private int x;
    private int y;


    public Point(int x, int y){
        this.x = x;
        this.y = y;

    }
    Point(){

    }

    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
    this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public double distance(int x1, int x2, int y1, int y2){
        return Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
    }



}

