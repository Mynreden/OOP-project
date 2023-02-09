package com.company.identification;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;
import com.company.identification.Registration;
import com.company.identification.login;
public class identification {
    protected String username;
    protected String password;

    public static void identification(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Choos action nuber");
        System.out.println("1.Sign in" + "\n" + "2.Sign on" );

            int c = scan.nextInt();

            if (c == 1) {
                Registration.registration();
            }

            else if (c == 2) {
                login.login();
            }
            else{
                System.out.println("Please, select action only 1 or 2. :)");
                identification();
                return;
            }

    }
}
