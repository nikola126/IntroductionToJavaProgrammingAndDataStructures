package com.programming.java.IntroductionToJavaNakov.ch10_Recursion;

import com.programming.java.IntroductionToJavaNakov.ch7_Arrays.ChapterSeven;

import java.util.*;

public class ChapterTen {
    public static void combinations(int N, int K) {
        int offset = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1 + offset; j <= K; j++) {
                System.out.printf("(%d %d) ", i, j);
            }
            offset += 1;
            System.out.println();
        }
    }

    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        System.out.print("Enter K: ");
        int K = scanner.nextInt();

        combinations(N, K);
    }

    public static void taskTwo() {
        VariationsNestedLoops.main(null);
    }

    public static List<String> generateBinary(int N) {
        // TODO Return List<Integer>
        List<String> asBinary = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, N); i++)
            asBinary.add(Integer.toBinaryString(i));

        return asBinary;
    }

    public static void taskThree() {
        List<String> words = new ArrayList<>(Arrays.asList("test", "rock", "fun"));
        int N = words.size();
        int K = 2;
        List<String> asBinary = generateBinary(N);

        for (String str : asBinary) {
            if (str.chars().filter(ch -> ch == '1').count() == K) {
                // only print strings with length of K
                int digit = Integer.parseInt(str, 2);
                int index = 0;
                int bit = 0;

                while (digit != 0) {
                    bit = digit % 2;
                    if (bit == 1)
                        System.out.printf("%s ", words.get(index));
                    index += 1;
                    digit /= 2;
                }
                System.out.println();
            }
        }
    }

    public static void taskFour() {
        List<String> words = new ArrayList<>(Arrays.asList("test", "rock", "fun"));
        int N = words.size();
        List<String> asBinary = generateBinary(N);

        for (String str : asBinary) {
            System.out.print("{ ");
            int asDecimal = Integer.parseInt(str, 2);

            int bit = 0;
            int index = 0;
            while (asDecimal != 0) {
                bit = asDecimal % 2;
                if (bit == 1)
                    System.out.printf("%s ", words.get(index));
                index += 1;
                asDecimal /= 2;
            }
            System.out.println(" }");
        }
    }

    public static void taskFive() {
        int[] array = new int[]{4, 42, 8, 23, 15, 16};
        System.out.println("Before sort: " + Arrays.toString(array));

        ChapterSeven.mergeSort(array, 0, array.length - 1);

        System.out.println("After sort: " + Arrays.toString(array));
    }

    public static void taskSix() {
        int N = 5;
        Permutations.initialize(N);
        Permutations.perm(N - 1);
    }

    public static void taskSeven() {
        Set<List<Integer>> validGroups = new HashSet<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        int N = list.size();
        int targetSum = 7;

        List<String> asBinary = generateBinary(N);

        for (String str : asBinary) {
            int currentSum = 0;
            List<Integer> currentGroup = new ArrayList<>();

            int asDigit = Integer.parseInt(str);
            int bit = 0;
            int index = 0;
            while (asDigit != 0) {
                bit = asDigit % 2;
                if (bit == 1) {
                    currentSum += list.get(index);
                    currentGroup.add(list.get(index));
                }
                index += 1;
                asDigit /= 2;

                if (currentSum == targetSum) {
                    validGroups.add(currentGroup);
                    break;
                }

                if (index >= list.size())
                    break;
            }
        }

        System.out.println("Target sum: " + targetSum);
        System.out.println("Valid groups: " + validGroups);
    }

    public static boolean possible(int k, int[] p, int sum) {
        // TODO 2D Array ???
        if (p[0] == sum)
            return true;

        if (k < 0)
            return false;

        return (possible(k - 1, p, sum) || possible(k - 1, p, sum - p[k]));
    }

    public static void taskEight() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int sum = 30;

        int[] p = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(p));

        System.out.println(possible(0, p, sum));
    }

    public static void taskNine() {
        Labyrinth.main(null);
    }

    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
        taskSix();
        taskSeven();
        taskEight();
        taskNine();
    }

}
