package Fibonacci;

// NOTE !!! this would be better if 0 index ang pag assign sa n
// but 1 index mn sa instructions so u have to deal with -1s everywhere if in ana jud
// example:
// results[n  ] = results[n-1] + results[n-2] if 0 index
// results[n-1] = results[n-2] + results[n-3] sa 1 index
public class FibRunnable implements Runnable{
    public static int[] results; // static array to store results
    int n;
    public FibRunnable(int n){
        this.n=n;
    }
    public void run(){
        if(n == 1){ // base case (1st num is 0)
            results[0] = 0;
            System.out.println("1 : 0");
            return;
        }
        if(n == 2){ // base case (2nd num is 1)
            results[1] = 1;
            System.out.println("2 : 1");
            return;
        }

        Thread prev1 = Main.frThreads.get(n-3); // get thread of n-2
        Thread prev2 = Main.frThreads.get(n-2); // get thread of n-1

        try{
            prev1.start(); // start n-1 and n-2 threads
            prev2.start();
        } catch(IllegalThreadStateException e){}// do nothing if already started

        try {
            prev1.join(); // wait until 2 threads are done
            prev2.join();
        } catch (InterruptedException e) {}

        int res = results[n-2] + results[n-3];  // calculate res [ f(n) = f(n-1) + f(n-2) ]
        results[n-1] = res;                     // set results array value
        System.out.println(n + " : " + res);    // print current n and result
    }
}

