import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Comparable;
public class Person implements Comparable<Person> , Payable {
    private int id;
    protected String name;
    protected String surname;
    private static int id_gen = 1;

    public Person() {
    }
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        id = id_gen++;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String toString() {
        return (id + "." + name + surname);
    }

    public double getPaymentAmount() {
        return 0;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getPaymentAmount() == o.getPaymentAmount()) {
            return 0;
        } else if (this.getPaymentAmount() < o.getPaymentAmount()) {
            return -1;
        } else {
            return 1;
        }
    }
}
