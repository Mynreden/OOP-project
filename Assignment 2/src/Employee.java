public class Employee extends Person {
    private String position;
    private double salary;
    public Employee(String name, String surname, String position , double salary){
        super(name, surname);
        this.position =position;
        this.salary =salary;

    }
    @Override
    public String toString(){
        return ("Employee: " + getId() + ". "+ name + " " +surname);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getPaymentAmount() {
        return getSalary();
    }

}
