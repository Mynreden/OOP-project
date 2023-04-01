import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! My name is AssistantBot." + "\n" + "I was created in 2020." + "\n" + "Please, remind me your name. ");
        Bot bot = new Bot();
        bot.Name(scan.nextLine());
        bot.Age(scan.nextInt(), scan.nextInt(), scan.nextInt());
        bot.Numder(scan.nextInt());
        int answer;
        do {
            answer= scan.nextInt();
            bot.ProgrammingKnowledge(answer);
        }
        while (answer != 2);
    }
}