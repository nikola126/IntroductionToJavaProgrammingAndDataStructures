package com.programming.java.IntroductionToJavaNakov.ch10_Recursion;

import java.util.Arrays;

public class Permutations {
    public static int[] p;
    public static int N;

    public static void initialize(int n) {
        N = n;
        p = new int[N];

        for (int i = 0; i < N; i++)
            p[i] = i + 1;
    }

    public static void perm(int k) {
        if (k == 0)
            printArray();

        for (int i = 0; i <= k; i++) {
            int swap = p[i];
            p[i] = p[k];
            p[k] = swap;

            perm(k - 1);

            swap = p[i];
            p[i] = p[k];
            p[k] = swap;
        }
    }

    public static void printArray() {
        System.out.println(Arrays.toString(p));
    }
}
