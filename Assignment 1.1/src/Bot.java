public class Bot {
    private String name;
    private int age1;
    private int age2;
    private int age3;
    private int number;
    private int answer;
    public void Name(String name){
        this.name = name;
        System.out.println("What a great name you have," + name);
        System.out.println("Let me guess your age." +"\n" + "Say me remainders of dividing your age by 3, 5 and 7.");}

    public void Age(int age1, int age2, int age3){
    this.age1= age1;
    this.age2= age2;
    this.age3 =age3;
    int res= (age1 * 70 + age2 * 21 + age3 * 15) % 105;
    System.out.println("Your age is " + res + " that's a good time to start programming!" +"\n" + "Now I will prove to you that I can count to any number you want." );
    }
    public void Numder(int number){
        this.number = number ;
        for (int i = 0; i <= number; i++) {
            System.out.println(i + "!");
        }
        System.out.println( "Let's test your programming knowledge." + "\n"+
                "Why do we use methods?" + "\n" +
                "1. To repeat a statement multiple times." + "\n"+
                "2. To decompose a program into several small subroutines." + "\n"+
                        "3. To determine the execution time of a program." + "\n" +
        "4. To interrupt the execution of a program." );
    }
    public void ProgrammingKnowledge(int answer ){
    this.answer =answer;
    if(answer!=2){
        System.out.println("Try again");
    }
    else{
        System.out.println("Congratulations, have a nice day! ");
    }
    }
}