package Perfect;
// NOTE !!! dili very uneven ang pag distribute pag random lng mo or smth idk lol
public class Main {
    public static double[] progresses; // array to keep track of each thread's progress
    public static Thread[] threads; // array for threads

    public static void main(String[] args) {
        int threadCount = 5;            // set threadCount
        int num = 9000;                    // set num
        progresses = new double[num];   // initialize progresses array
        threads = new Thread[num];      // initialize threads array

        int k = num / threadCount;  // calculate # of numbers per thread
        for(int i=0; i < threadCount; i++){
            PerfectRunnable pr;
            if(i < threadCount - 1) // check if it is not the last iteration
                pr = new PerfectRunnable(i*k, (i+1)*k - 1, i); // make new runnable that will process k amount of numbers
            else
                pr = new PerfectRunnable(i*k, num, i); // make new runnable that will process k amount of numbers plus extra
            Thread t = new Thread(pr); // make new thread from the runnable
            threads[i] = t; // add our new thread to threads array at index i
            t.start(); //start the thread;
        }
    }
}
