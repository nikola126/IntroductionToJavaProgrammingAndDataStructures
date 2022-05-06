package com.programming.java.IntroductionToJavaNakov.ch5_Conditionals;

import java.util.Scanner;

public class ChapterFive {
    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter integer 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter integer 2: ");
        int num2 = scanner.nextInt();

        if (num1 > num2) {
            int swap = num1;
            num1 = num2;
            num2 = swap;
        }

        System.out.println("Integer 1: " + num1);
        System.out.println("Integer 2: " + num2);
    }

    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter integer 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter integer 2: ");
        int num2 = scanner.nextInt();

        boolean isNegative = false;

        if (num1 < 0 && num2 >= 0)
            isNegative = true;
        else if (num2 < 0 && num1 >= 0)
            isNegative = true;

        System.out.println(num1 + "/" + num2 + "= " + (num1 / num2));
        System.out.println("Negative sign: " + isNegative);
    }

    public static void taskThree() {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            System.out.printf("Enter integer [%d/%d]: ", i + 1, 3);
            int input = scanner.nextInt();
            max = Math.max(input, max);
        }

        System.out.println("Max: " + max);
    }

    public static void taskFour() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter integer: ");
        int num = scanner.nextInt();

        switch (num) {
            case 0: {
                System.out.println("Нула");
                break;
            }
            case 1: {
                System.out.println("Едно");
                break;
            }
            case 2: {
                System.out.println("Две");
                break;
            }
            case 3: {
                System.out.println("Три");
                break;
            }
            case 4: {
                System.out.println("Четири");
                break;
            }
            case 5: {
                System.out.println("Пет");
                break;
            }
            case 6: {
                System.out.println("Шест");
                break;
            }
            case 7: {
                System.out.println("Седем");
                break;
            }
            case 8: {
                System.out.println("Осем");
                break;
            }
            case 9: {
                System.out.println("Девет");
                break;
            }
            default: {
                System.out.println("??");
            }
        }
    }

    public static void taskFive() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A*x^2 + B*x + C");
        System.out.print("A: ");
        double a = scanner.nextDouble();
        System.out.print("B: ");
        double b = scanner.nextDouble();
        System.out.print("C: ");
        double c = scanner.nextDouble();

        double D = Math.pow(b, 2) - 4 * a * c;
        if (D < 0) {
            System.out.println("No real roots!");
            return;
        }

        double x1 = (-b + Math.sqrt(D)) / (2 * a);
        double x2 = (-b - Math.sqrt(D)) / (2 * a);

        System.out.println("X1: " + x1);
        if (D != 0)
            System.out.println("X2: " + x2);
    }

    public static void taskSix() {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 5; i++) {
            System.out.printf("Enter integer [%d/%d]: ", i + 1, 5);
            int input = scanner.nextInt();
            max = Math.max(input, max);
        }

        System.out.println("Max: " + max);
    }

    public static void taskSeven() {
        Scanner scanner = new Scanner(System.in);
        int N = 5;
        int[] values = new int[5];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter integer [%d/%d]: ", i + 1, N);
            values[i] = scanner.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (values[i] + values[j] == 0) {
                    System.out.printf("Zero sum between %d and %d\n", values[i], values[j]);
                }
            }
        }
    }

    public static void taskEight() {
        int start = 0;
        int end = 15;
        for (int i = start; i < end; i++) {
            if (i <= 0 || i > 9)
                System.out.printf("%d\tError!\n", i);
            else if (1 <= i && i <= 3)
                System.out.printf("%d\t%d\n", i, i * 10);
            else if (4 <= i && i <= 6)
                System.out.printf("%d\t%d\n", i, i * 100);
            else if (7 <= i && i <= 9)
                System.out.printf("%d\t%d\n", i, i * 1000);
        }
    }

    public static void taskNine() {
        Scanner scanner = new Scanner(System.in);
         System.out.print("Enter a number [0..999]: ");
        int N = scanner.nextInt();

        System.out.printf("%3d\t", N);
        int ones = N % 10;
        N /= 10;
        int tens = N % 10;
        N /= 10;
        int hundreds = N % 10;

        boolean unionAdded = false;
        boolean processOnes = ones != 0;

        switch (hundreds) {
            case 1: {
                System.out.print("Сто ");
                break;
            }
            case 2: {
                System.out.print("Двеста ");
                break;
            }
            case 3: {
                System.out.print("Триста ");
                break;
            }
            case 4: {
                System.out.print("Четиристотин ");
                break;
            }
            case 5: {
                System.out.print("Петстотин ");
                break;
            }
            case 6: {
                System.out.print("Шестстотин ");
                break;
            }
            case 7: {
                System.out.print("Седемстотин ");
                break;
            }
            case 8: {
                System.out.print("Осемстотин ");
                break;
            }
            case 9: {
                System.out.print("Деветстотин ");
                break;
            }
            default: {
                break;
            }
        }

        if (tens == 0 && ones != 0) {
            System.out.print("и ");
            unionAdded = true;
        }

        switch (tens) {
            case 1: {
                System.out.print("и ");
                processOnes = false;
                switch (ones) {
                    case 1: {
                        System.out.print("Единадесет");
                        break;
                    }
                    case 2: {
                        System.out.print("Дванадесет");
                        break;
                    }
                    case 3: {
                        System.out.print("Тринадесет");
                        break;
                    }
                    case 4: {
                        System.out.print("Четиринадесет");
                        break;
                    }
                    case 5: {
                        System.out.print("Петнадесет");
                        break;
                    }
                    case 6: {
                        System.out.print("Шестнадесет");
                        break;
                    }
                    case 7: {
                        System.out.print("Седемнадесет");
                        break;
                    }
                    case 8: {
                        System.out.print("Осемнадесет");
                        break;
                    }
                    case 9: {
                        System.out.print("Деветнадесет");
                        break;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 2: {
                System.out.print("Двадесет ");
                break;
            }
            case 3: {
                System.out.print("Тридесет ");
                break;
            }
            case 4: {
                System.out.print("Четиридесет ");
                break;
            }
            case 5: {
                System.out.print("Петдесет ");
                break;
            }
            case 6: {
                System.out.print("Шестдесет ");
                break;
            }
            case 7: {
                System.out.print("Седемдесет ");
                break;
            }
            case 8: {
                System.out.print("Осемдесет ");
                break;
            }
            case 9: {
                System.out.print("Деветдесет ");
                break;
            }
            default: {
                break;
            }
        }

        if (hundreds == 0 && tens == 0)
            System.out.print("Нула");

        if (ones != 0 && processOnes && !unionAdded)
            System.out.print("и ");

        if (processOnes) {
            switch (ones) {
                case 1: {
                    System.out.print("Едно");
                    break;
                }
                case 2: {
                    System.out.print("Две");
                    break;
                }
                case 3: {
                    System.out.print("Три");
                    break;
                }
                case 4: {
                    System.out.print("Четири");
                    break;
                }
                case 5: {
                    System.out.print("Пет");
                    break;
                }
                case 6: {
                    System.out.print("Шест");
                    break;
                }
                case 7: {
                    System.out.print("Седем");
                    break;
                }
                case 8: {
                    System.out.print("Осем");
                    break;
                }
                case 9: {
                    System.out.print("Девет");
                    break;
                }
                default: {
                    break;
                }
            }
        }

        System.out.println();
    }

    public static void printAll() {
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

    public static void main(String[] args) {
        printAll();
    }
}
