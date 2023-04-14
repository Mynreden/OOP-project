public class Assigment1 {
    /*
    Problem 1.
    You are given a number “n” and an array of “n” elements,
    write the function that returns minimum of them.
    */
    public static int min(int[] arr){
        int[] newArray = new int[arr.length - 1];
        if(1==arr.length){
            return arr[0];
        }
        if(arr[0]<arr[1]){
            int temp = arr[0];
            arr[0]= arr[1];
            arr[1]=temp;
        }
        for (int i = 1; i < arr.length; i++) {
            newArray[i - 1] = arr[i];
        }
        return min(newArray);

    }
    /*
    Problem 2.
     You are given a number “n” and an array of “n” elements,
     write the function that returns average of them*/
    public static double average(int[] arr,int sum,int k){
        if(k==arr.length){
            return sum/ arr.length;
        }
        sum=sum+arr[k];
        double res = average(arr,sum,++k);
        return res;

    }
    /*
    Problem 3.
    You are given a number “n”, write the function for checking
    whether“n” is prime.
    */
    public static void isPrime(int n){
        if(n%2==0){
            System.out.println("Problem 3. " + n + " is prime");
        }
        else{
            System.out.println("Problem 3. " + n + " is not  prime");
        }
    }
    /*
    Problem 4.
    You are given a number “n”, write the program using recursion for
    finding “n!”
    */
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        int factor = factorial(n-1)*n;
        return factor;
    }
    /*
    Problem 5.
    You are given a number “n”, write the function for finding n-th
    elements in Fibonacci sequence using recursion. (Fn = Fn-1+ Fn-2).
    F0= 0, F1 = 1.
    */
    public static int fibonacci(int n){
        if(n==0 || n == 1){
            return n;
        }
        int fib = fibonacci(n-2)+fibonacci(n-1);
        return fib;
    }
    /*
    Problem 6.
    You are given numbers “a” and “n”, write the function that
    returns “an”.
    */
    public static int pow(int a, int n){
        if(n==0){
            return 1;
        }
        int res = a*pow(a,n-1);
        return res;
    }

    /*
    Problem 7.
    You are given a string consisting of M distinct symbols. Print
    all the permutations (all possible variants) of the symbols of this
    string.
    */

    public static void permutations(String str){
        permutations("",str);
    }
    private static void permutations(String permutations, String str ){
        if(0==str.length()){
            System.out.println(permutations);
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                permutations(permutations+str.charAt(i),
                        str.substring(0,i)+str.substring(i+1,str.length()));
            }
        }

    }

    /*
    Problem 8.
    You are given a string “s”, write the function for checking
    whether “s” is all consists of digits.
    */

    public static boolean allDigits(String str){
        if(str.length()==0){
            return true;
        }
        if(!(str.charAt(0)<=59 && str.charAt(0)>=49)){
            return false;
        }
        return allDigits(str.substring(1,str.length()));
    }
    /*
    Problem 9.
    You are given numbers “n” and “k”, write the program that
    finds binomial coefficient
    */
    public static int binomialCoefficient(int n, int k){
        try{
            if (n < k) {
                throw new IllegalArgumentException("n must be greater than or equal to k");
            }
            if(k==0 || (k==n)){
                return 1;
            }
            int res = binomialCoefficient(n-1,k-1)+ binomialCoefficient(n-1,k);
            return res;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    /*
    Problem 10.
    You are given “a” and “b”, write the function for finding
    GCD(a, b) using recursion. (Hint: Euclidean Algorithm)
    */
    public static int GCD(int n, int k){
        if(k>n){
            int temp = n;
            n = k;
            k = temp;
        }
        int b = n/k;
        int r=n-b*k;
        if(r<=0){
            return k;
        }
        int res = GCD(k,r);
        return res;
    }

}