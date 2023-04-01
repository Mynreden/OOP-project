public class Student extends Person {
    private double gpa;
    public Student(String name, String surname, double gpa) {
        super(name, surname);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    @Override
    public String toString(){
        return ("Student:" +" " + getId() + ". "+ name + " " +surname);
    }

    public double getPaymentAmount() {
        if(getGpa()>2.67){
            return 36660.00;
        }else {
            return 0;
        }
    }

}
