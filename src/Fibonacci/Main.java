package Fibonacci;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Thread> frThreads; // arraylist for FibRunnable Threads
    public static void main(String[] args) {
        frThreads = new ArrayList<>();
        int num = 20; // no. of fibonacci numbers input idk
        FibRunnable.results = new int[num]; // initialize results array to have [num] items

        for(int i=1; i <= num; i++){ // for loop from 1 to num
            frThreads.add(new Thread(new FibRunnable(i)));
            // ^ create new FibRunabble threads where n = i so
            // (1st added thread has n=1, 2nd has n=2, 3rd has n=3 etc...)
        }
        Thread lastThread = frThreads.get(frThreads.size()-1); // get last thread from arraylist
        lastThread.start(); // start last thread
        try {
            lastThread.join(); // wait until last thread done (means all other threads are done)
        } catch (InterruptedException e) {}
        System.out.println("yay finish"); // finish wow
    }
}
