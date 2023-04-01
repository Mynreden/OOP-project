import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class Main {
    public static ArrayList<Person> person = new ArrayList<>();

    public static void main(String[] args) {

        Employee employee1 = new Employee("Erzhan", "Kabdolla", "Programmer", 3600000);
        Employee employee2 = new Employee("Baktybek", "Sagidolla", "Boss", 200000);
        Student student1 = new Student("Pora", "Dora", 2.22);
        Student student2 = new Student("Ora", "Pora", 3.55);
        person.add(employee1);
        person.add(employee2);
        person.add(student1);
        person.add(student2);
          Collections.sort(person );
        Iterator<Person> iterator = person.iterator();
        printData(iterator);
    }
    public static void printData(Iterator<Person> iterator){
         for(int i=0 ;iterator.hasNext();i++){
            System.out.println(iterator.next() + " earns " + person.get(i).getPaymentAmount()+ " tenge");
        }
    }
}