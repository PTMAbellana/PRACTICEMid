package Password;

public class Checker implements Runnable{

    public static boolean found = false;    // static found variable
    public static String password;
    private final int vowel_position;
    private final char vowel;
    public Checker(char vowel, int vowel_position){ // constructor
        this.vowel = vowel;
        this.vowel_position = vowel_position;
    }
    private String check(String atk){
        return atk.substring(0,vowel_position) + vowel + atk.substring(vowel_position);
        // inserts vowel into atk string with proper position
        // example:  vowel='a', vowel_position=2 ,atk = "gwpo"
        // output = "gw" + 'a' + "po"
        //        = "gwapo"
    }
    public void run(){
        int len = password.length(); //
        String atk = "a".repeat(len-1);
        // idea is to have atk of length len-1 and insert our vowel only when checking
        // see check() function comments for example
        while (!found && !check(atk).equals(password)) { // slightly modified (?) version sa kato code sa pwchecker
            System.out.println(check(atk));
            int i;
            for (i = atk.length()-1; i >= 0 && atk.charAt(i) == 'z'; i--);
            if (i < 0) return;
            String first = atk.substring(0, i);
            char next = (char) (atk.charAt(i) + 1);
            String after = "a".repeat(len - i - 2);
            atk = first + next + after;
        }
        if (check(atk).equals(password)) { // we need an if statement to check if this thread actually found the password or if the above loop just stopped because pw has been found elsewhere
            found = true; // check global found variable to true
            System.out.println("Found: " + check(atk));
        }


    }
}
// ignore idk
//        int len = password.length();
//        StringBuilder atk = new StringBuilder();
//        atk.append("a".repeat(len-1));
//        atk.insert(vowel_position, vowel);
//        while(!Main.found && !(atk.toString().equals(password))){
//            atk.deleteCharAt(vowel_position);
//
//            //  do thing ???
//
//            atk.insert(vowel_position, vowel);
//        }
