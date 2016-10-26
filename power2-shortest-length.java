// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class power2-shortest-length {
    public int power2-shortest-length(int[] A) {
        // This algorithm is O(n) in time complexity, O(1) in space complexity
        // (while the task asks for O(nlogn) alg, not sure if my solution could deal with all the possible cases)
        // First I iterate the whole array to get the sum of the power for every element
        // Since we know in computer the integer is represented in binary (0,1), then I use the bit manipulation
        // to count the number of 1s shown up in the sum, it's also the shortest length we want to calculate. 
        long sum = 0;
        
        for(int a: A)
            sum += (long)Math.pow(2,a);
        
        long count = 0;
        
        while(sum != 0){
            long k = sum & 1;
            count = count + k;
            sum = sum >> 1;
        }
        
        return (int)count;
    }
}