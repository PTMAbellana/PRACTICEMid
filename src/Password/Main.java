package Password;

import java.util.ArrayList;

public class Main {
    private static final char[] VOWELS = {'a','e','i','o','u'}; // constant array of vowels para ma iterate ra
    public static void main(String[] args) {
        Checker.password = "gwapo"; // set password
        ArrayList<Thread> checkerThreads = new ArrayList<>(); // arraylist for checker threads
        for(int i=0; i<Checker.password.length(); i++){ // iterate (password length) number of times
            for(int j=0; j<5; j++){ // iterate through VOWELS array
                Checker c = new Checker(VOWELS[j],i);
                // ^ make new checker with jth vowel at the ith position in the string
                // example:  Checker( VOWEL[3], 4 ) => Checker( 'o', 4 )
                // would check with the letter 'o' at the 5th letter of the string
                Thread t = new Thread(c);   // make new thread from checker
                checkerThreads.add(t);      // add thread to array list
                t.start();                  // start the thread
            }
        }
        for( Thread t : checkerThreads){
            try {
                t.join();
            } catch (InterruptedException e) {}
        }
        // ^^^^ wait for all threads to finish
        System.out.println(" you are have been hacked "); // done
    }

}
