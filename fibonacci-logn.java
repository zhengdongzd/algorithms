package fibonacci-logn;

public class fibonacci-logn {

//    /* function that returns nth Fibonacci number */
//    static long fib(long n){
//        long F[][] = new long[][]{{1,1},{1,0}};
//        if (n == 0)
//            return 0;
//        power(F, n-1);
//        return F[0][0];
//    }
//
    static void multiply(long F[][], long M[][]){
        long e00 =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
        long e01 =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
        long e10 =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
        long e11 =  F[1][0]*M[0][1] + F[1][1]*M[1][1];

        F[0][0] = e00;
        F[0][1] = e01;
        F[1][0] = e10;
        F[1][1] = e11;
    }

    /* Optimized version of power() in method 4 */
    static void power(long F[][], long n){
        if( n == 0 || n == 1)
            return;
        long M[][] = new long[][]{{1,1},{1,0}};

        power(F, n/2);
        multiply(F, F);

        if (n%2 != 0)
           multiply(F, M);
    }

    static long fib2(long A, long B, long N){
        // Here d = 1000000007;
        // we use the property that ( a % d + b % d) % d = (a + b) % d
        // so we calculate as the fibonacci numbers and at last we mod d.
        long mod = 1000000007;
        long result =-1;
        if(N == 0)
            result = A;
        else if(N == 1)
            result = B;
        else{
            long S[][] = new long[][]{{B,A},{1,0}};
            long F[][] = new long[][]{{1,1},{1,0}};
            power(F, N-1);
            multiply(S, F);
            result = S[0][0];
        }
        return result % 1000000007;
    }


    static long fib(long A, long B, long N){
        // Here d = 1000000007;
        // we use the property that ( a % d + b % d) % d = (a + b) % d
        // so we calculate as the fibonacci numbers and at last we mod d.
        long mod = 1000000007;
        long result =-1;
        if(N == 0)
            result = A;
        else if(N==1)
            result = B;
        else
            result = fib(A, B, N-1) + fib(A, B, N-2);
        return result % 1000000007;
    }

    public static void main (String args[]){
      System.out.println(fib(1800670007,1002107407,20));
      System.out.println(fib2(1800670007,1002107407,20));
}

}
