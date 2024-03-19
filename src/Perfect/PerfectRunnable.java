package Perfect;

public class PerfectRunnable implements Runnable{
    private int start, end, totalNums, threadIndex;
    private double processed=0.0;
    public PerfectRunnable(int start, int end, int threadIndex){
        this.start = start;
        this.end = end;
        this.threadIndex = threadIndex;
        totalNums = end-start+1;
    }
    public void run(){
        for(int i=start; i<=end; i++){ // iterate from start to end
            if(isPerfect(i)) { // if perfect
                System.out.println(i + " is perfect!"); // print number
            }
            processed += 1; //update processed;
            //System.out.println(processed+"/"+totalNums+" = " +processed/totalNums); // print progress daw
            Main.progresses[threadIndex] = processed / totalNums; // calculate progress and update it in the static array
        }

    }
    private static boolean isPerfect(int n){
        if(n<=1) {
            return false;
        }
        int sum = 1; // variable for sum of divisors, starts at 1 because 1 is always factor
        for(int i=2; i*i <= n; i++) { // find all divisors and add to sum, starts at 2 because sum is already initially 1
            if(n % i==0) { // check if divisor
                if(i * i != n)
                    sum += i + n/i;
                else
                    sum += i;
            }
        }
        if(sum == n) // if sum == n then it is a perfect number
            return true;

        return false;
    }
}
