package org.example;

import java.util.Scanner;

public class Main {

    public static void permutation(int i,  int n, int[] arr){
        if(i>n){
            return;
        }
        arr[0]= i;
        for (int k = 1; k <= n ; k++) {
            arr[1]= k;
            System.out.println(arr[0] + " " + arr[1]);
        }

        permutation(++i,n,arr);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[scan.nextInt()];
        int i =1;
        permutation(i,scan.nextInt(),arr);
    }
}